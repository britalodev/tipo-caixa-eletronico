package com.treinamento.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.treinamento.exception.OpcaoInvalidaException;
import com.treinamento.exception.PersistenciaBancoDadosException;
import com.treinamento.model.Cliente;
import com.treinamento.model.ClientePF;
import com.treinamento.model.ClientePJ;
import com.treinamento.model.Conta;
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
			ClientePF pf = objectParaClientePf(cliente);
			novoCliente = clientePFDAO.save(pf);
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
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, String> teste = ((LinkedHashMap<String, String>) cliente);
		clientePF = mapeandoParaClientePF(clientePF, teste);
		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, LinkedHashMap <String, ?>> pre = (LinkedHashMap<String, LinkedHashMap<String, ?>>) cliente;
		
		LinkedHashMap<String, ?> contas = pre.get("conta");
		
		Conta mapeandoContas = mapeandoContas(contas);
		List<Conta> contasMapeadas = new ArrayList<>();
		contasMapeadas.add(mapeandoContas);
		clientePF.setContas(contasMapeadas);
		return clientePF;
	}

	private Conta mapeandoContas(LinkedHashMap<String, ?> contas) {
		@SuppressWarnings("serial")
		Conta conta = new Conta() {
		};
		
		conta.setAgencia(Integer.parseInt(contas.get("agencia").toString()));
		conta.setNumeroConta(Integer.parseInt(contas.get("numero_conta").toString()));
		conta.setSaldo(Double.parseDouble(contas.get("saldo").toString()));
		conta.setTipoConta(contas.get("tipo_conta").toString());
		return conta;
	}

	private ClientePF mapeandoParaClientePF(ClientePF clientePF, LinkedHashMap<String, String> teste) {
		clientePF.setNome(teste.get("nome"));
		clientePF.setEmail(teste.get("email"));
		clientePF.setTelefone(teste.get("telefone"));
		clientePF.setRg(teste.get("rg"));
		clientePF.setCpf(teste.get("cpf"));
		clientePF.setBanco(teste.get("banco"));
		clientePF.setDataAdesao(trataStringParaData(teste.get("data_adesao")));
		clientePF.setDataNascimento((trataStringParaData(teste.get("data_nascimento"))) );
		return clientePF;
	}

	private LocalDate trataStringParaData(String string) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(string, formatter);
		return localDate;
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
