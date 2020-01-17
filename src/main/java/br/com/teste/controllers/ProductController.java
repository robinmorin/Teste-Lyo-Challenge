package br.com.teste.controllers;

import br.com.teste.controllers.exceptions.StandardError;
import br.com.teste.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Rest API para fazer CRUD da tabela Product", tags = {"Products"})
public class ProductController {

    @ApiOperation(
            tags = {"Products"},
            value = "Add Products in DataBase",
            notes = "This endpoint needs parameter IN Product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product foi criado satisfatoriamente", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PostMapping("/products/add")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Products"},
            value = "Update values of Product in DataBase",
            notes = "This endpoint needs parameter IN Product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi atualizado satisfatoriamente", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PutMapping("/products/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Products"},
            value = "Delete Product in DataBase",
            notes = "This endpoint needs parameter productId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi apagado satisfatoriamente", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping("/products/delete/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long productId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Products"},
            value = "List All Products from DataBase",
            notes = "This endpoint not need parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de Costumers", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping("/products/list")
    public ResponseEntity<Object> listProducts(){
        return ResponseEntity.ok().build();
    }

}
