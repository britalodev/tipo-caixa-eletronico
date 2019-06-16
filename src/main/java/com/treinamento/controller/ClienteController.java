package com.treinamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.exception.PersistenciaBancoDadosException;
import com.treinamento.exception.Resposta;
import com.treinamento.service.ClienteService;

@RestController
@RequestMapping("/")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping("cliente/novo")
	public ResponseEntity<Object> criarCliente(@RequestParam(value = "tipo", required = true) String tipoPessoa, @RequestBody Object cliente){
		try {
			return ResponseEntity.ok(clienteService.criarConta(cliente, tipoPessoa ));	
		}catch (PersistenciaBancoDadosException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}
				
	}
}
