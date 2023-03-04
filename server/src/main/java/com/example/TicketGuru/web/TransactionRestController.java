package com.example.TicketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.TransactionRepository;

@RestController
public class TransactionRestController {
	
	@Autowired
	private TransactionRepository transactionRepository;

}
