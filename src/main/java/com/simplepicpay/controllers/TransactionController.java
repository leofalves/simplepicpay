package com.simplepicpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplepicpay.domain.transaction.Transaction;
import com.simplepicpay.dtos.TransactionDTO;
import com.simplepicpay.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception{
		Transaction newTransaction = this.transactionService.createTransaction(transactionDTO);
		return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
	}

}
