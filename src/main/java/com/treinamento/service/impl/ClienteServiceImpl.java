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
	@Autowired
	ClientePFRepository clientePFDAO;
	@Autowired
	ClientePJRepository clientePJDAO;
	@Autowired
	ObjectMapper mapper;

	@Override
	public Object criarConta(String cliente, String tipoConta) {

	
		Object novoCliente = null;
		try {
		if (tipoConta.equals("PF")) {			
			ClientePF pf = mapper.readValue(cliente, ClientePF.class);
			novoCliente = clientePFDAO.save(pf);
		} else if (tipoConta.equals("PJ")) {
			ClientePJ pj = mapper.readValue(cliente, ClientePJ.class);
			novoCliente = clientePJDAO.save(pj);
		} else {
			throw new OpcaoInvalidaException("Opção deve ser PF para pessoa Fisica e PJ para pessoa Jurídica");
		}

		if (novoCliente.equals(null))
			throw new PersistenciaBancoDadosException("Falha no banco de dados ao criar o Cliente");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return novoCliente;
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
