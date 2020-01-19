package br.com.teste.services.impl;

import br.com.teste.models.Product;
import br.com.teste.repositories.IProductDao;
import br.com.teste.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    //***
    // TODO: O mas adequado para esse caso seria criar um metodo Validator, para avaliar os valores recebidos em cada chamada.
    //       Para um desenvolvimento rapido de esse teste só estou avaliando que seja enviado o objeto Product.
    //***

    @Autowired
    private IProductDao productDao;

    public Long addProduct(Product product) throws Exception {
        if(product == null) throw new Exception("Valores imcompletos do Produto");
        Optional<Product> existsProduct = Optional.empty();
        if(product.getProductid() != null) existsProduct = productDao.findById(product.getProductid());
        Product savedProduct;
        if(!existsProduct.isPresent()) {
            savedProduct = productDao.save(product);
            return savedProduct.getProductid();
        } else {
            throw new Exception("Produto já existente com esse Id.");
        }
    }

    public boolean updateProduct(Product product) throws Exception {
        if(product == null) throw new Exception("Valores imcompletos do Produto");
        Optional<Product> existsProduct = Optional.empty();
        if(product.getProductid() != null) existsProduct = productDao.findById(product.getProductid());
        if(existsProduct.isPresent()) {
            Product upProduct = existsProduct.get();
            upProduct.setProductname(product.getProductname());
            upProduct.setPrice_unit(product.getPrice_unit());
            upProduct.setCreate_at(product.getCreate_at());
            upProduct.setStatus(product.getStatus());
            productDao.save(upProduct);
            return true;
        } else {
            throw new Exception("Produto não existe com esse Id.");
        }
    }

    public boolean deleteProduct(Long productId) throws Exception {
        if(productId == null) throw new Exception("Deve colocar o Id do Produto");
        Optional<Product> existsProduct = Optional.empty();
        existsProduct = productDao.findById(productId);
        if(existsProduct.isPresent()) {
            try {
                productDao.deleteById(productId);
                return true;
            } catch (Exception ex){
                throw new Exception(String.format("Erro gravando o Produto (%s)",ex.getMessage()));
            }
        } else {
            throw new Exception("Produto não existe com esse Id.");
        }
    }

    public List<Product> productList() {
        List<Product> productList = new ArrayList<>();
        productDao.findAll().forEach(product -> productList.add(product));
        return productList;
    }
}
