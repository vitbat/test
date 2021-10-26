package kz.example.springrestful.repository;

import kz.example.springrestful.entity.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query(value = "select * from products p WHERE p.description = :description", nativeQuery = true)
    Product findByDescription(@Param("description") String description);

    Product findByCategoryIdAndPriceAndDescription(int categoryId, int price, String description);

    @Query(value = "select p.id,p.categoryId, p.description, a.name, p.name, p.price, a.beginDate, a.endDate from actions a join products p ON a.productId = p.id where a.beginDate = :checkDate BETWEEN a.beginDate and a.endDate", nativeQuery = true)
    Product findAllByProductsCurrentAction(@Param("checkDate") Date checkDate);
}