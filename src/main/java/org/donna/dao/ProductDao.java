package org.donna.dao;

import org.donna.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> getAllProduct() {
        String sql = "select * from product";
        return jdbcTemplate.query(sql, new ProductMapper());
    }

    public Product getProduct(int id) {
        String sql = "select * from product where pid=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductMapper());
    }

    public static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductID(rs.getInt("productID"));
            product.setProductTitle(rs.getString("productTitle"));
            product.setPrice(rs.getDouble("price"));
            product.setCategory(rs.getString("category"));
            product.setImage(rs.getString("image"));
            product.setQty(rs.getInt("qty"));
            return product;
        }

    }

    public boolean saveProduct(Product product) {
        String sql = "insert into product (productTitle, price, category, image  qty) values (?, ?, ?)";

        int value = jdbcTemplate.update(sql, new Object[]{product.getProductTitle(), product.getPrice(), product.getCategory(), product.getImage(), product.getQty()});

        if (value > 0) {
            return true;
        }

        return false;
    }

    public boolean updateProduct(Product product) {
        String sql = "update product set productTitle=?, price=?, category=?, image?, qty=? where productID=?";

        int value = jdbcTemplate.update(sql, new Object[]{product.getProductTitle(), product.getPrice(), product.getCategory(), product.getImage(), product.getQty(), product.getProductID()});

        if (value > 0) {
            return true;
        }

        return false;
    }

    public boolean deleteProduct(int id) {
        String sql = "delete from product where productID=?";

        int value = jdbcTemplate.update(sql, new Object[]{id});

        if (value > 0) {
            return true;
        }

        return false;
    }
    
    

}

