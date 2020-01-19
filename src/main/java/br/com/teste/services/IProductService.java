package br.com.teste.services;

import br.com.teste.models.Product;

import java.util.List;

public interface IProductService {
    Long addProduct(Product product) throws Exception;
    boolean updateProduct(Product product) throws Exception;
    boolean deleteProduct(Long productId) throws Exception;
    List<Product> productList();
}
