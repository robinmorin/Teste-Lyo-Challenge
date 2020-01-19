package br.com.teste.services.impl;

import br.com.teste.models.Costumer;
import br.com.teste.repositories.ICostumerDao;
import br.com.teste.services.ICostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CostumerService implements ICostumerService {

    //***
    // TODO: O mas adequado para esse caso seria criar um metodo Validator, para avaliar os valores recebidos em cada chamada.
    //       Para um desenvolvimento rapido de esse teste só estou avaliando que seja enviado o objeto Costumer.
    //***

    @Autowired
    private ICostumerDao costumerDao;

    public Long addCostumer(Costumer costumer) throws Exception {
        if(costumer == null) throw new Exception("Valores imcompletos do Cliente");
        Optional<Costumer> existsCostumer = Optional.empty();
        if(costumer.getCostumerid() != null) existsCostumer = costumerDao.findById(costumer.getCostumerid());
        Costumer savedCostumer;
        if(!existsCostumer.isPresent()) {
            savedCostumer = costumerDao.save(costumer);
            return savedCostumer.getCostumerid();
        } else {
            throw new Exception("Cliente já existente com esse Id.");
        }
    }

    public boolean updateCostumer(Costumer costumer) throws Exception {
        if(costumer == null) throw new Exception("Valores imcompletos do Cliente");
        Optional<Costumer> existsCostumer = Optional.empty();
        if(costumer.getCostumerid() != null) existsCostumer = costumerDao.findById(costumer.getCostumerid());
        if(existsCostumer.isPresent()) {
            Costumer upCostumer = existsCostumer.get();
            upCostumer.setFirstname(costumer.getFirstname());
            upCostumer.setLastname(costumer.getLastname());
            upCostumer.setEmail(costumer.getEmail());
            upCostumer.setCreate_at(costumer.getCreate_at());
            upCostumer.setStatus(costumer.getStatus());
            costumerDao.save(upCostumer);
            return true;
        } else {
            throw new Exception("Cliente não existe com esse Id.");
        }
    }

    public boolean deleteCostumer(Long costumerId) throws Exception {
        if(costumerId == null) throw new Exception("Deve colocar o Id do Cliente");
        Optional<Costumer> existsCostumer = Optional.empty();
        existsCostumer = costumerDao.findById(costumerId);
        if(existsCostumer.isPresent()) {
            try {
                costumerDao.deleteById(costumerId);
                return true;
            } catch (Exception ex){
                throw new Exception(String.format("Erro gravando o Cliente (%s)",ex.getMessage()));
            }
        } else {
            throw new Exception("Cliente não existe com esse Id.");
        }
    }

    public List<Costumer> costumerList(){
        List<Costumer> costumerList = new ArrayList<>();
        costumerDao.findAll().forEach(costumer -> costumerList.add(costumer));
        return costumerList;
    }

}
