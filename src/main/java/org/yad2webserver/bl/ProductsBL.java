package org.yad2webserver.bl;
import org.springframework.beans.factory.annotation.*;
import org.yad2webserver.beans.Product;
import org.yad2webserver.dao.ProductsDAO;

public class ProductsBL {

    @Autowired
    ProductsDAO productsDAO;

    public Product addProduct(Product product) throws Exception {
        //check if product exists
        Product existingProducts = this.productsDAO.findByCode(product.getCode());
        if(existingProducts == null)
        {
            return this.productsDAO.save(product);
        }
        else {
            throw new Exception("Product already existed with code"+product.getCode());
        }
    }

    public void deleteProduct(String code){
        this.productsDAO.deleteByCode(code);
    }

    public Product updateProductQuantity(String code, int quantity) throws Exception {
        Product requiredProduct = this.productsDAO.findByCode(code);
        if (requiredProduct !=null) {
            requiredProduct.setQuantity(requiredProduct.getQuantity() + quantity);
            return this.productsDAO.save(requiredProduct);
        } else {
            throw new Exception("Product not found with code: " + code);
        }
    }
}
