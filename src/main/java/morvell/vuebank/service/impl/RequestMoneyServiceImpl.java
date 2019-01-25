package morvell.vuebank.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import morvell.vuebank.domain.PayAnyCard;
import morvell.vuebank.domain.RequestMoney;
import morvell.vuebank.repo.PayAnyCardRepo;
import morvell.vuebank.repo.RequestMoneyRepo;
import morvell.vuebank.service.RequestMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestMoneyServiceImpl implements RequestMoneyService {

  @Autowired
  RequestMoneyRepo repo;

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<RequestMoney> findAllWithSort(String field, String sort) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<RequestMoney> query = cb.createQuery(RequestMoney.class);
    Root<RequestMoney> root = query.from(RequestMoney.class);
    if (sort.equals("asc")) {
      query.orderBy(cb.asc(root.get(field)));
    } else {
      query.orderBy(cb.desc(root.get(field)));
    }

    return entityManager.createQuery(query).getResultList();
  }

  @Override
  public List<RequestMoney> finaAllWithFilter(String field, String like) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<RequestMoney> query = cb.createQuery(RequestMoney.class);
    Root<RequestMoney> root = query.from(RequestMoney.class);
    if (field.equals("id") || field.equals("paymentSum")) {
      query.where(cb.equal(root.get(field),like));
    } else {
      query.where(cb.like(root.get(field), like));
    }
    return entityManager.createQuery(query).getResultList();
  }
}
