# Projeto REST

#### A entidade Stock
- Nosso projeto consiste em uma estrutra seguindo o padrão 
  REST para criar, armazenar, ler e deletar. Para isso primeiro
  precisamos criar uma entidade Stock, ela será usada pelo banco de 
  dados que criamos.
  
#### A Camada Controller
- Nessa camada é onde chamaremos os métodos HTTP. 
- Visando seguir o padrão RestFull nós usaremos uma classe StockDTO.
Essa classe é a responsável por fazer a transferência com o banco de dados,
  enquanto nossa entidade Stock representa diretamente a "tabela" do nosso 
  BD, o DTO é responsável pelas aplicações e métodos que serão usados.
  
- Nós usamos 4 tipos de métodos GET, POST, PUT e DELETE. Além disso, 
algums como o GET possui alguma especificação a mais.
  
#### A Camada Service
- A camada Service é a responsável por interagir com o repositório e 
criar os métodos que de fato serão utilizados para alterar nosso banco de dados
  seja por uma simples consulta, como também inserção e exclusão de dados.
  

#### A camada Mapper
- Pelo padrão Restfull devemos criar uma classe DTO que é aquele que recebe o 
objeto na requisição GET e será usado para manipular antes de transformar na 
  nossa entidade q vai para o Banco de Dados
  
#### Repository
- O repository é a camada responsável por fazer consultas ao nosso 
banco de dados. Ela extende da JPARepository, o que nos dá uma série de
  métodos pronto, mas podemos criar novos métodos a partir de Queries no 
  banco de dados.