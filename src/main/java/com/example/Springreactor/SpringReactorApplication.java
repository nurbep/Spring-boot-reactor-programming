package com.example.Springreactor;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class SpringReactorApplication {
	
	@Value("${spring.datasource.maximum-pool-size}")
	private int connectionPoolSize;

	public static void main(String[] args) {
		SpringApplication.run(SpringReactorApplication.class, args);
	}
	
	@Bean
	public Scheduler jdbcScheduler() {
		return Schedulers.fromExecutor(Executors.newFixedThreadPool(connectionPoolSize));
	}

	
	  @Bean public TransactionTemplate
	  transactionTemplate(PlatformTransactionManager transactionManager) { return
	  new TransactionTemplate(transactionManager); }
	 

}
