package com.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.model.ClientePF;

@Repository
public interface ClientePFRepository extends JpaRepository<ClientePF, Long> {

}
