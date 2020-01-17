package br.com.teste.repositories;

import br.com.teste.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduct extends CrudRepository<Product,Long> {
}
