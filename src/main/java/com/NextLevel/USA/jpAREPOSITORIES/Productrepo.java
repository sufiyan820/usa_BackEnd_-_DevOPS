package com.NextLevel.USA.jpAREPOSITORIES;

import com.NextLevel.USA.ENTITIES.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Productrepo extends JpaRepository<Products, Long> {
    List<Products> findByCategory(String category);
    List<Products> findByAvailableTrue();
}
