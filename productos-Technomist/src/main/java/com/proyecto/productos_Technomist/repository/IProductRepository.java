package com.proyecto.productos_Technomist.repository;

import com.proyecto.productos_Technomist.productModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.codigo = :codigo")
    Product findByCodigo(String codigo);
}
