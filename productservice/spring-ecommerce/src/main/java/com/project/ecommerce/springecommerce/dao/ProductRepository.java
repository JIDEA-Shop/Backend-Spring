package com.project.ecommerce.springecommerce.dao;

import com.project.ecommerce.springecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Method written in this repository is auto exposed by Spring Data as REST endpoints
 * baseURL = "http://localhost:8080/api/products"
 */
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     * Query method, which start with findBy.
     * method match by id using @{@link Param} id
     * Query executed behind the scene is "SELECT * FROM product WHERE category_id = ?"
     * url = "http://localhost:8080/api/products/search/findByCategoryId?id=1
     * @param id
     * @param pageable
     * @return Page<Product>
     */
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    /**
     * new Query method for search bar. using LIKE in SQL
     */
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
    /**
     * Example of using custom query :)
     */
//    @Query(value = "select p from Product p where p.category.id = :id " +
//           "and lower(p.name) like lower(concat('%',:name,'%'))")
//    Page<Product> findByCategoryIdAndNameContaining(@Param("id") String id, @Param("name") String name, Pageable pageable);
}
