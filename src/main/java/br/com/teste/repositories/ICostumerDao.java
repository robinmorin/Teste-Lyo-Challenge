package br.com.teste.repositories;

import br.com.teste.models.Costumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICostumerDao extends CrudRepository<Costumer,Long> {
}
