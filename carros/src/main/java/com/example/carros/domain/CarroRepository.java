package com.example.carros.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {


    Iterable<Carro> findByTipo(String tipo);
}
