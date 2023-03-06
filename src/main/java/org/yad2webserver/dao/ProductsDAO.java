package org.yad2webserver.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yad2webserver.beans.Product;

import java.util.List;

public interface ProductsDAO extends JpaRepository<Product, Integer> {

    Product findByCode(String code);
    @Query(value="delete from Product p where p.code = ?1")
    void deleteByCode(String code);

}