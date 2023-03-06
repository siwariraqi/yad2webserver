package org.yad2webserver.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yad2webserver.beans.Product;
import org.yad2webserver.bl.ProductsBL;

@RestController
@RequestMapping("products")
@CrossOrigin
public class ProductsController {

    @Autowired
    private ProductsBL productsBL;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody Product product) {
        try {
            Product newProduct = this.productsBL.addProduct(product);
            return ResponseEntity.ok(newProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product Existed");
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteProduct(@PathVariable String code) {
        try {
            productsBL.deleteProduct(code);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product doesn't existed!");
        }
    }

    @PatchMapping("/{code}")
    public ResponseEntity updateProduct(@PathVariable String code, @RequestBody Product product) {
        try {
            Product updateProduct = productsBL.updateProductQuantity(code, product.getQuantity());
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product doesn't existed!");
        }
    }
}