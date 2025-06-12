package hello_spring.hello_spring;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class HelloSpringApplication {
	public static void main(String[] args) {SpringApplication.run(HelloSpringApplication.class, args);}
	}