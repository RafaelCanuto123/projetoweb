package br.projetoweb.repository;

import org.springframework.data.repository.CrudRepository;

import br.projetoweb.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
	
	Cliente findByCodigo(long codigo);
	
	

}
