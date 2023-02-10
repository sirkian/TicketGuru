package com.example.TicketGuru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.TicketGuru.domain.TicketRepository;
import com.example.TicketGuru.domain.TicketType;
import com.example.TicketGuru.domain.TicketTypeRepository;
import com.example.TicketGuru.domain.TransactionRepository;

@SpringBootApplication
public class TicketGuruApplication {
	
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	TicketTypeRepository ticketTypeRepository;
	@Autowired
	TransactionRepository transactionRepository;

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean
	public CommandLineRunner ticketguru(TicketRepository ticketRepository, TicketTypeRepository ticketTypeRepository, TransactionRepository transactionRepository) {
		return (args) -> {
			
			ticketTypeRepository.save(new TicketType("Opiskelija-lippu", 15.0));
			ticketTypeRepository.save(new TicketType("Eläkeläinen", 12.0));
			
			for (TicketType ticketType : ticketTypeRepository.findAll()) {
				System.out.println("TicketType: " + ticketType.toString());
			}
		
	};
	}
	}


