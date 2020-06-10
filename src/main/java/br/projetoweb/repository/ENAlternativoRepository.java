package br.projetoweb.repository;

import org.springframework.data.repository.CrudRepository;

import br.projetoweb.model.Cliente;
import br.projetoweb.model.ENAlternativo;

public interface ENAlternativoRepository extends CrudRepository<ENAlternativo, String> {
	
	Iterable<ENAlternativo> findByCliente(Cliente cliente);
	
	ENAlternativo findByCodigo(long codigo);

}
