package br.com.teste.controllers;

import br.com.teste.controllers.exceptions.StandardError;
import br.com.teste.models.ExposeInvoice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Rest API para fazer CRUD da tabela Invoices", tags = {"Invoices"})
public class InvoiceController {

    @ApiOperation(
            tags = {"Invoices"},
            value = "Add Invoices in DataBase",
            notes = "This endpoint needs parameters IN type ExposeInvoice")
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Gerada Nota Fiscal Corretamente", response = String.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PostMapping("/invoices/generate")
    public ResponseEntity<Object> addInvoice(@RequestBody ExposeInvoice invoiceIn){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Invoices"},
            value = "Delete Invoices in DataBase",
            notes = "This endpoint needs parameter invoiceId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Nota Fiscal foi apagada satisfatoriamente", response = String.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping("/invoices/delete/{invoiceId}")
    public ResponseEntity<Object> deleteInvoice(@PathVariable Long invoiceId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Invoices"},
            value = "List All Invoices in DataBase",
            notes = "This endpoint is not need parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar as Nota Fiscal", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping("/invoices/list")
    public ResponseEntity<Object> listInvoices(){
        return ResponseEntity.ok().build();
    }

}
