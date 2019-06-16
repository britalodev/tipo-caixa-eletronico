package com.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.model.Cliente;
import com.treinamento.model.ClientePJ;

@Repository
public interface ClientePJRepository extends JpaRepository<ClientePJ, Long> {

}
