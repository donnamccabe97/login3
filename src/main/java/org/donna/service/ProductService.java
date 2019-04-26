package org.donna.service;

import org.donna.dao.ProductDao;
import org.donna.model.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/allProduct", method = RequestMethod.GET, params = "Accept=application/json")
    public List<Product> getAllProduct() {
        List<Product> listProduct = productDao.getAllProduct();
        return listProduct;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, params = "Accept=application/json")
    public Product getProduct(@PathVariable("id") String id) {
        Product product = productDao.getProduct(Integer.parseInt(id));
        return product;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, params = "Accept=application/json")
    public Product saveProduct(Product p) {
        productDao.saveProduct(p);
        return p;
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product p) {
        productDao.updateProduct(p);
        return p;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, params = "Accept=application/json")
    public Product delteProduct(@PathVariable("id") String id) {
        productDao.deleteProduct(Integer.parseInt(id));
        Product p = new Product();
        return p;
    }

}