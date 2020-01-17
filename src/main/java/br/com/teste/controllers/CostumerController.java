package br.com.teste.controllers;

import br.com.teste.controllers.exceptions.StandardError;
import br.com.teste.models.Costumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Rest API para fazer CRUD da tabela Costumers", tags = {"Costumers"})
public class CostumerController {

    @ApiOperation(
            tags = {"Costumers"},
            value = "Add Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi criado satisfatoriamente", response = String.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PostMapping("/costumers/add")
    public ResponseEntity<Object> addCostumer(@RequestBody Costumer costumerIn){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Costumers"},
            value = "Update Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi atualizado satisfatoriamente", response = String.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PutMapping("/costumers/update")
    public ResponseEntity<Object> updateCostumer(@RequestBody Costumer costumerIn){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Costumers"},
            value = "Delete Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi apagado satisfatoriamente", response = String.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping("/costumers/delete/{costumerId}")
    public ResponseEntity<Object> deleteCostumer(@PathVariable Long costumerId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            tags = {"Costumers"},
            value = "List of Costumer of DataBase",
            notes = "This endpoint not need parameter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar ", response = String.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping("/costumers/list")
    public ResponseEntity<Object> listCostumers(){
        return ResponseEntity.ok().build();
    }

}
