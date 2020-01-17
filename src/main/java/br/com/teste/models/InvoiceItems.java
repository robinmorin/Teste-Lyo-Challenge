package br.com.teste.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@Entity
@Table(name = "items_invoice")
public class InvoiceItems implements Serializable {

    @Id
    private Long invoiceid;

    @NotNull
    private Long productid;

    @NotEmpty
    @Positive
    private Integer amount;

    @NotEmpty
    @Positive
    private Double price_unit;

}
