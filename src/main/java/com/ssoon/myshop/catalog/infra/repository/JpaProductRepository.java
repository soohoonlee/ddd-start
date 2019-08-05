package com.ssoon.myshop.catalog.infra.repository;

import com.ssoon.myshop.catalog.domain.category.CategoryId;
import com.ssoon.myshop.catalog.domain.product.Product;
import com.ssoon.myshop.catalog.domain.product.ProductRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JpaProductRepository implements ProductRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Product> findByCategoryId(CategoryId categoryId, int page, int size) {
    TypedQuery<Product> query = entityManager.createQuery(
        "select p from Product p where :catId member of p.categoryIds order by p.id.id desc",
        Product.class);
    query.setParameter("catId", categoryId);
    query.setFirstResult((page - 1) * size);
    query.setMaxResults(size);
    return query.getResultList();
  }
}
