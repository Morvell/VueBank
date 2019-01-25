package morvell.vuebank.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import morvell.vuebank.domain.PayAnyCard;
import morvell.vuebank.repo.PayAnyCardRepo;
import morvell.vuebank.service.PayAnyCardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayAnyCardServiceImpl implements PayAnyCardService {

  @Autowired
  PayAnyCardRepo repo;

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<PayAnyCard> findAllWithSort(String field, String sort) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<PayAnyCard> query = cb.createQuery(PayAnyCard.class);
    Root<PayAnyCard> root = query.from(PayAnyCard.class);
    if (sort.equals("asc")) {
      query.orderBy(cb.asc(root.get(field)));
    } else {
      query.orderBy(cb.desc(root.get(field)));
    }

    return entityManager.createQuery(query).getResultList();
  }

  @Override
  public List<PayAnyCard> finaAllWithFilter(String field, String like) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<PayAnyCard> query = cb.createQuery(PayAnyCard.class);
    Root<PayAnyCard> root = query.from(PayAnyCard.class);
    if (field.equals("id") || field.equals("summ")) {
      query.where(cb.equal(root.get(field),like));
    } else {
      query.where(cb.like(root.get(field), like));
    }
    return entityManager.createQuery(query).getResultList();
  }
}
