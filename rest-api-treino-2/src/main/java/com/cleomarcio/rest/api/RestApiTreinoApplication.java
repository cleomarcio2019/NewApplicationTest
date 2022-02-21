package com.cleomarcio.rest.api;

import com.cleomarcio.rest.api.domain.entity.Cliente;
import com.cleomarcio.rest.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RestApiTreinoApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.salvar(new Cliente("Cleomarcio Celestino"));
            clientes.salvar(new Cliente("Ana Maria Moreira da Silva"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
            c.setNome(c.getNome()+" -> cliente atualizado ");
             clientes.atualizar(c);
            });
            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
            };
        };

    public static void main(String[] args) {
        SpringApplication.run(RestApiTreinoApplication.class, args);
    }
}