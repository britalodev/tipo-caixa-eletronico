package com.treinamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.treinamento.exception.OpcaoInvalidaException;
import com.treinamento.exception.PersistenciaBancoDadosException;
import com.treinamento.model.Cliente;
import com.treinamento.model.ClientePF;
import com.treinamento.model.ClientePJ;
import com.treinamento.repository.ClientePFRepository;
import com.treinamento.repository.ClientePJRepository;
import com.treinamento.repository.ClienteRepository;
import com.treinamento.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteDAO;
	ClientePFRepository clientePFDAO;
	ClientePJRepository clientePJDAO;
	@Autowired
	ObjectMapper mapper;

	@Override
	public Object criarConta(Object cliente, String tipoConta) {

	
		Object novoCliente;
		if (tipoConta.equals("PF")) {			
			novoCliente = clientePFDAO.save(objectParaClientePf(cliente));
		} else if (tipoConta.equals("PJ")) {
			ClientePJ pj = (ClientePJ) cliente;
			novoCliente = clientePJDAO.save(pj);
		} else {
			throw new OpcaoInvalidaException("Opção deve ser PF para pessoa Fisica e PJ para pessoa Jurídica");
		}

		if (novoCliente.equals(null))
			throw new PersistenciaBancoDadosException("Falha no banco de dados ao criar o Cliente");
		return novoCliente;
	}
	
	private ClientePF objectParaClientePf(Object cliente) {
		ClientePF clientePF = new ClientePF();
		try {
			String clienteString = cliente.toString();
			clientePF = mapper.readValue(clienteString, ClientePF.class);
			return clientePF;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientePF;
	}

	@Override
	public Cliente alterarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente deletarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> pesquisarClienteNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
