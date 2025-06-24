package com.costa.Edicola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.costa.Edicola.model.Mensile;

import jakarta.transaction.Transactional;

@RepositoryRestResource
public interface EdicolaRepositoryMens extends JpaRepository<Mensile, Long> {
	
	public Optional<Mensile> findById(Long id);
	
	@Transactional
	public void deleteById (Long id);
}
