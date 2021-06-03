package com.project.lessalc.santanderboot.repository;

import com.project.lessalc.santanderboot.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    // O próprio Spring é inteligente o suficiente para a partir dos nomes conseguir interpretar essa função
    // Já existe um findById padrão, ele consegue entender que é um find where e como passamos Name e Date
    // No método e nos parâmetros o resto ele sabe.
    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);
    // Os dois pontos ":" antes da variável indica ao spring que deve ser o parâmetro dentro do método

    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.date = :date")
    Optional<List<Stock>> findByToday(LocalDate date);
}
