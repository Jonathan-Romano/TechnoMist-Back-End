package com.proyecto.productos_Technomist.productController;

import com.proyecto.productos_Technomist.productModel.Product;
import com.proyecto.productos_Technomist.productService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class productController {

    @Value("${server.port}")
    private int serverport;

    @Autowired
    IProductService productServ;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        System.out.println("---------------estoy en el puerto: " + serverport + "--------------------");
        return productServ.getProduct(id);
    }
    @GetMapping
    public Product getProduct( @RequestParam String codigo) {
        System.out.println("---------------estoy en el puerto: " + serverport + "--------------------");
        return productServ.getProductByCod(codigo);
    }
    @GetMapping("/list")
    public List<Product> getProductsList() {
        return productServ.getProducts();
    }


    @PostMapping("/create")
    public String saveProduct(@RequestBody Product product) {
        return productServ.saveProduct(product);
    }


    @PutMapping("/edit")
    public Product editProduct(@RequestBody Product product) {
        return productServ.editProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productServ.deleteProduct(id);
    }


}
