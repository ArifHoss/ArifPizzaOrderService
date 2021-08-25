package com.example.arifpizzaorderservice;

import com.example.arifpizzaorderservice.entities.Pizza;
import com.example.arifpizzaorderservice.repository.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArifPizzaOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArifPizzaOrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PizzaRepository pizzaRepository){
        return args -> {
            if( pizzaRepository.count() == 0) {
                pizzaRepository.save(new Pizza("Hawaii",80,"Ost,Tomatsås,Skinka,Ananas,Bannan"));
            }
        };
    }

}
