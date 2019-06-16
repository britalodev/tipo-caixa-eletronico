package com.treinamento.service;

import java.util.List;

import com.treinamento.model.Cliente;

public interface ClienteService {
	
	
	Object criarConta(Object cliente, String tipoConta);
	Cliente alterarCliente(Cliente cliente);
	Cliente deletarCliente(Cliente cliente);
	List<Cliente> pesquisarClienteNome(String nome);

}
