package org.yad2webserver.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yad2webserver.beans.Product;

public interface OrdersDAO extends JpaRepository<Product, Integer> {


}