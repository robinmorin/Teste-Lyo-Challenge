package br.com.teste.controllers;

import br.com.teste.controllers.exceptions.StandardError;
import br.com.teste.models.Costumer;
import br.com.teste.models.StandardResponse;
import br.com.teste.services.ICostumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Rest API para fazer CRUD da tabela Costumers", tags = {"Costumers"})
public class CostumerController {

    // Não é recomendada injeção de dependencia por campo direitamente, em projeto real,
    // eu mudaria para injeção de dependencia por Construtor, mas para fines de entrega rapida deste teste, deixare assim
    @Autowired
    ICostumerService costumerService;

    @SneakyThrows
    @ApiOperation(
            tags = {"Costumers"},
            value = "Add Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi criado satisfatoriamente", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PostMapping(value = "/costumers/add", produces = {"APPLICATION/JSON"},consumes = {"APPLICATION/JSON"} )
    public ResponseEntity<Object> addCostumer(@RequestBody Costumer costumerIn){
            Long costumerID = costumerService.addCostumer(costumerIn);
            StandardResponse result = new StandardResponse(String.format("Criado corretamente o Cliente com ID: %d",costumerID));
            return ResponseEntity.ok().body(result);
    }

    @SneakyThrows
    @ApiOperation(
            tags = {"Costumers"},
            value = "Update Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi atualizado satisfatoriamente", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @PutMapping(value = "/costumers/update", produces = {"APPLICATION/JSON"},consumes = {"APPLICATION/JSON"} )
    public ResponseEntity<Object> updateCostumer(@RequestBody Costumer costumerIn){
            boolean updated = costumerService.updateCostumer(costumerIn);
            Long costumerID = costumerIn.getCostumerid();
            StandardResponse result = new StandardResponse(String.format("%s atualizado o Cliente com ID: %d",(updated?"Foi":"Não foi"),costumerID));
            return ResponseEntity.ok().body(result);
    }

    @SneakyThrows
    @ApiOperation(
            tags = {"Costumers"},
            value = "Delete Costumer in DataBase",
            notes = "This endpoint needs parameter IN Costumer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Costumer foi apagado satisfatoriamente", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping(value = "/costumers/delete/{costumerId}", produces = {"APPLICATION/JSON"})
    public ResponseEntity<Object> deleteCostumer(@PathVariable Long costumerId) {
            boolean deleted = costumerService.deleteCostumer(costumerId);
            StandardResponse result = new StandardResponse(String.format("%s apagado o Cliente com ID: %d", (deleted ? "Foi" : "Não foi"), costumerId));
            return ResponseEntity.ok().body(result);
    }

    @ApiOperation(
            tags = {"Costumers"},
            value = "List of Costumer of DataBase",
            notes = "This endpoint not need parameter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listar ", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 500, message = "Error no servidor", response = StandardError.class) })
    @GetMapping(value = "/costumers/list", produces = {"APPLICATION/JSON"} )
    public ResponseEntity<List<Costumer>> listCostumers(){
        return ResponseEntity.ok().body(costumerService.costumerList());
    }

}
