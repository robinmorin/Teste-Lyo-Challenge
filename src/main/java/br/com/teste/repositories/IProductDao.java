package br.com.teste.repositories;

import br.com.teste.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductDao extends CrudRepository<Product,Long> {
}
