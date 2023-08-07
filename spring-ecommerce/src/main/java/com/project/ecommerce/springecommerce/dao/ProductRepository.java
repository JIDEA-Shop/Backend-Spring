package com.project.ecommerce.springecommerce.dao;

import com.project.ecommerce.springecommerce.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;
import java.util.List;

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
     * url = "http://localhost:5000/api/products/search/findByNameContaining?name=?
     */
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
    /**
     * Example of using custom query :)
     */
//    @Query(value = "select p from Product p where p.category.id = :id " +
//           "and lower(p.name) like lower(concat('%',:name,'%'))")
//    Page<Product> findByCategoryIdAndNameContaining(@Param("id") String id, @Param("name") String name, Pageable pageable);

    /**
     * Query to get search product sorted by price.
     * url = "http://localhost:5000/api/products/search/searchAndOrderByPriceAsc?keyword=?"
     */
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(concat('%', :keyword, '%')) " +
            "ORDER BY p.unit_price ASC")
    Page<Product> searchAndOrderByPriceAsc(@Param("keyword") String keyword,Pageable pageable);

    /**
     * http://localhost:8080/api/products/search/searchAndOrderByPriceDesc?keyword=?
     * @param keyword
     * @param pageable
     * @return
     */
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(concat('%', :keyword, '%')) " +
            "ORDER BY p.unit_price DESC")
    Page<Product> searchAndOrderByPriceDesc(@Param("keyword") String keyword,Pageable pageable);

    /**
     * Find By Category_Id, Sorted Order
     * http://localhost:5000/api/products/search/findByCategoryAndOrderByPriceDesc?id=1
     */
    @Query("SELECT p FROM Product p WHERE p.category.id = :id " +
            "ORDER BY p.unit_price DESC")
    Page<Product> findByCategoryAndOrderByPriceDesc(@Param("id") Long categoryId,Pageable pageable);

    /**
     * http://localhost:5000/api/products/search/findByCategoryAndOrderByPriceAsc?id=1
     * @param categoryId
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * from `shop-for-home`.product WHERE category_id = :id ORDER BY unit_price ASC;",nativeQuery = true)
    Page<Product> findByCategoryAndOrderByPriceAsc(@Param("id") Long categoryId,Pageable pageable);

    /**
     * find Oldest updated product for promotions
     * http://localhost:5000/api/products/search/findOldestUpdatedProducts
     */
    @Query(value = "SELECT * from `shop-for-home`.product ORDER BY last_updated ASC LIMIT 5;", nativeQuery = true)
    List<Product> findOldestUpdatedProducts();
//  No USE!!!
//    /**
//     * http://localhost:5000/api/products/search/updateLastUpdated?productId=1&newLastUpdated=2023-08-06
//     * @param productId
//     * @param newLastUpdated
//     */
//    @Modifying
//    @Transactional
//    @Query("UPDATE Product p SET p.last_updated = :newLastUpdated WHERE p.id = :productId")
//    void updateLastUpdated(@Param("productId") Long productId, @Param("newLastUpdated") Date newLastUpdated);

}
