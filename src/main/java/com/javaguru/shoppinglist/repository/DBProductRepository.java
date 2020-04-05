package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
@Profile("localhost")
public class DBProductRepository implements ProductRepositoryInterface{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DBProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product insert(Product product) {
        String query = "insert into PRODUCT (name, price, category, discount, description, id) values (?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->  {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setString(2,product.getDescription());
            return ps;
        }, keyHolder);
        product.setId(keyHolder.getKey().longValue());
        return product;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public Optional<Product> findProductById(Long id) {
        String query = "select * from PRODUCT where id = ?";
        List<Product> products = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class), id);
        if (!products.isEmpty())
            return Optional.ofNullable(products.get(0));

        return Optional.empty();
    }

    @Override
    public boolean existsByName(String name) {

        String query = "SELECT" +
                        " CASE WHEN count(*) > 0 " +
                        " THEN true ELSE false END " +
                        " FROM PRODUCT WHERE name = ?";
        return jdbcTemplate.queryForObject(query, Boolean.class, name);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return Optional.empty();
    }
}
