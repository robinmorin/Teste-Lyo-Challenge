package br.com.teste.services.impl;

import br.com.teste.models.ExposeInvoice;
import br.com.teste.models.Invoice;
import br.com.teste.repositories.IInvoiceDao;
import br.com.teste.repositories.IItemsInvoiceDao;
import br.com.teste.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceService {

    //***
    // TODO: O mas adequado para esse caso seria criar um metodo Validator, para avaliar os valores recebidos em cada chamada.
    //       Para um desenvolvimento rapido de esse teste só estou avaliando que seja enviado o objeto Product.
    //***

    @Autowired
    private IInvoiceDao invoiceDao;

    @Autowired
    private IItemsInvoiceDao itemsInvoiceDao;

    public Long addInvoice(ExposeInvoice invoice) throws Exception {
        if(invoice == null) throw new Exception("Valores imcompletos da Nota fiscal");
        Optional<Invoice> existsInvoice = Optional.empty();
        if(invoice.getInvoice().getInvoiceid() != null) existsInvoice = invoiceDao.findById(invoice.getInvoice().getInvoiceid());
        Invoice savedInvoice;
        if(!existsInvoice.isPresent()) {
            savedInvoice = invoiceDao.save(invoice.getInvoice());
            invoice.getItemsInvoice().stream().forEach(invoiceItems -> itemsInvoiceDao.save(invoiceItems));
            return savedInvoice.getInvoiceid();
        } else {
            throw new Exception("Nota fiscal já existente com esse Id.");
        }
    }

    public boolean deleteInvoice(Long invoiceId) throws Exception {
        if(invoiceId == null) throw new Exception("Deve enviar ID da Nota fiscal");
        return true;
    }

    public List<ExposeInvoice> invoiceList() {
        return new ArrayList<ExposeInvoice>();
    }
}
