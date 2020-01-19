package br.com.teste.repositories;

import br.com.teste.models.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IInvoiceDao extends CrudRepository<Invoice,Long> {
}
