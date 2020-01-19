package br.com.teste.repositories;

import br.com.teste.models.Costumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICostumerDao extends CrudRepository<Costumer,Long> {
}
