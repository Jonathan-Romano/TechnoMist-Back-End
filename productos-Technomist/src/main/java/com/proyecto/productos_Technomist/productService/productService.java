package com.proyecto.productos_Technomist.productService;

import com.proyecto.productos_Technomist.productModel.Product;
import com.proyecto.productos_Technomist.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService implements IProductService{

    @Autowired
    IProductRepository productRepo;

    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product getProductByCod(String codP) {
        return productRepo.findByCodigo(codP);
    }



    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }


    @Override
    public String saveProduct(Product product) {
        productRepo.save(product);
        return "Producto guardado correctamente";
    }


    @Override
    public Product editProduct(Product product) {
        Product productEdit = this.getProduct(product.getIdP());
        productEdit.setPrecio(product.getPrecio());
        productEdit.setCodigo(product.getCodigo());
        productEdit.setNombre(product.getNombre());
        productEdit.setMarca(product.getMarca());
        this.saveProduct(productEdit);

        return productEdit;
    }

    @Override
    public String deleteProduct(Long id) {
        productRepo.deleteById(id);

        return "Producto eliminado correctamente";
    }
}
