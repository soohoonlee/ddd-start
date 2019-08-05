package com.ssoon.myshop.order.infra.dao;

import com.ssoon.myshop.order.query.dao.OrderViewDao;
import com.ssoon.myshop.order.query.dto.OrderView;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderViewDao implements OrderViewDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<OrderView> selectByOrderer(String ordererId) {
    String selectQuery =
        "select new com.ssoon.myshop.order.query.dto.OrderView(o, m, p) " +
        "from Order o join o.orderLines ol, Member m, Product p " +
        "where o.orderer.memberId.id = :ordererId " +
        "and o.orderer.memberId = m.id " +
        "and index(ol) = 0 " +
        "and ol.productId = p.id " +
        "order by o.number.number desc";
    TypedQuery<OrderView> query = entityManager.createQuery(selectQuery, OrderView.class);
    query.setParameter("ordererId", ordererId);
    return query.getResultList();
  }
}
