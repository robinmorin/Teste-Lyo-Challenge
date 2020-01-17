package br.com.teste.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Method that make a conjunction of both entities.
 */
@Data
@AllArgsConstructor
public class ExposeInvoice {

    private Invoice invoice;

    private List<InvoiceItems> itemsInvoice;

}
