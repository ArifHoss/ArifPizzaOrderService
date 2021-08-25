package com.example.arifpizzaorderservice.repository;

import com.example.arifpizzaorderservice.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
