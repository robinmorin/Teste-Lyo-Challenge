package br.com.teste.repositories;

import br.com.teste.models.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceDao extends CrudRepository<Invoice,Long> {
}
