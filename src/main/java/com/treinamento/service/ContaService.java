package com.treinamento.service;

import java.util.List;

import com.treinamento.model.Conta;

public interface ContaService {
	
	Conta criarConta(Conta conta);
	Conta alterarConta(Conta conta);
	Conta deletarConta(Conta conta);
	List<Conta> pesquisarContaCliente(String cliente);

}
