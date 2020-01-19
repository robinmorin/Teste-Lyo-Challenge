package br.com.teste.services;

import br.com.teste.models.ExposeInvoice;

import java.util.List;

public interface IInvoiceService {
    Long addInvoice(ExposeInvoice invoice) throws Exception;
    boolean deleteInvoice(Long invoiceId) throws Exception;
    List<ExposeInvoice> invoiceList();
}
