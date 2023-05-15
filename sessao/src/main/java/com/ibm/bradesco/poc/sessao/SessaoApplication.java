package com.ibm.bradesco.poc.sessao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication(scanBasePackages = {"com.ibm.bradesco.poc.sessao", "com.ibm.bradesco.poc.sessao.jpa"})
@EnableRedisRepositories
public class SessaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessaoApplication.class, args);
	}

}
