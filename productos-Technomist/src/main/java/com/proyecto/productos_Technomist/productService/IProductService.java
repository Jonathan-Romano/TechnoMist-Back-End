package com.proyecto.productos_Technomist.productService;

import com.proyecto.productos_Technomist.productModel.Product;

import java.util.List;

public interface IProductService {
    public Product getProduct(Long id);
    public Product getProductByCod(String codP);

    public List<Product> getProducts();

    public String saveProduct(Product product);

    public Product editProduct(Product product);

    public String deleteProduct(Long id);

}
