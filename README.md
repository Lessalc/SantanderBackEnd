# Projeto REST

### Objetivo
- O objetivo desse projeto foi criar uma API REST para armazenar, ler, alterar 
  e deletar um objeto Stock (ação). Aqui fizemos o projeto de Backend, para 
  no Frontend simular a tela do Homebroker do Santander.
  
- O projeto foi criado seguindo o padrão RESTful, separando as camadas para execução 
do projeto. 
  
- O projeto foi feito para ser armazenado em nuvem a partir de um deploy no Heroku.

- O projeto de backend foi quase todo finalizado, no entanto, ainda há um erro
após o deploy no Heroku, o qual espero solucionar em breve.
  

### O que foi criado
- Aqui vou explanar o que foi feito e para que serve cada camada. Além disso, vou repassar
alguns pontos importantes do projeto.
  
#### Conexão com o Banco de Dados
- Independente do projeto, é imprescindível a conexão com o banco de dados, para isso 
escolhemos criar um banco no Postegres usando o Docker.
  
- O Docker nos permite criar aplicações em container, evitando que seja necessário a 
instalação de um software. Para criar esses containers nos usamos **Images** existentes no`dockerhub`.
  
- Criada a imagem podemos então fazer a conexão indicando URL, user e password no `application.yml`.

- Somente a conexão não é suficiente, é necessário usar alguma implementação do JPA, aqui 
  aplicamos o `hibernate`. 

#### A entidade Stock
- Nosso projeto consiste em criar, armazenar, ler e deletar um objeto definido como
  Stock. Esse objeto é nossa tabela no banco de dados. Ele possui como atributo: nome, 
  data, preço, variação e um identificador único.
  
- As entidades são reflexos de nossas tabelas no banco de dados, no nosso caso
  particular estamos trabalhando apenas com uma tabela.
  
#### A Camada Controller
- Essa é a camada que é acessada a partir de uma API REST, é nela onde definimos os 
  métodos HTTP, ou seja, fazemos o mapeamento para que quando esses métodos sejam chamados
  nossa aplicação receba uma **_requisição_** e execute uma tarefa.
  
- Visando seguir o padrão RESTful nós usaremos uma classe StockDTO.
Essa classe é a responsável por interagir com o controlador.
  
- Enquanto Stock representa diretamente nossa "Tabela" do banco de dados, o StockDTO
é onde trabalhamos o dado e aplicamos métodos.

- Nós usamos 4 tipos de métodos GET, POST, PUT e DELETE. Esses são os métodos
  que fazem a requisição HTTP onde foi mapeado pelo controlador.
  - Em especial ao método GET foram adicionadas especificações. Isto é, um **path** foi 
  adicionado para que operações do tipo GET fossem realizadas de forma diferente.
    Assim, podemos chamar um GET para retornar todos os dados, ou dado(s) específico(s) a 
    partir de um **ID** ou de uma **Data**.
  
#### A Camada Service
- Essa é a camada onde se localiza as regras de negócio, enquanto na camada controller
  nos fazemos o mapeamento, essa camada é onde as requisições vão ser executadas de acordo com a regra
  de negócio definida.
  
- Nessa camada iremos interagir com o Banco de Dados, a partir da camada Repository.
Aqui será responsável por adicionar, alterar ou excluir um dado ao nosso banco. Fazemos 
  isso a partir de métodos do Repository, que herda a classe JPA Repository.
  
- Na camada service recebemos um objeto DTO, mas passamos uma entidade. Para isso
usamos também outra camada a Mapper.

#### A camada Mapper
- Essa camada é a responsável por fazer uma transformação de um objeto DTO para uma
entidade, assim como de uma entidade para o DTO.
  
#### Repository
- O repository é a camada responsável por fazer consultas, inserções e delets ao nosso 
banco de dados. Ela extende da JPARepository, o que nos dá uma série de métodos pronto.
  
- Podemos criar novos métodos a partir de **Queries** no 
  banco de dados.
  
### Conclusão
- Cada camada tem uma característica e uma funcionalidade, o objetivo nesse pequeno
resumo foi pôr em palavras os conceitos que foram vistos ao longo do curso e da elaboração
  do projeto.
  
- O projeto foi feito acompanhando o que foi feito pelo professor, é essencial compreender
os conceitos visto de forma a saber quando e como aplicá-los. 
  