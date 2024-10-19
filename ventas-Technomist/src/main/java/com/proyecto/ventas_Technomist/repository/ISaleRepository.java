package com.proyecto.ventas_Technomist.repository;

import com.proyecto.ventas_Technomist.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long> {
}
