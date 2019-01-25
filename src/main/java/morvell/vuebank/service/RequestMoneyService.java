package morvell.vuebank.service;

import java.util.List;
import morvell.vuebank.domain.PayAnyCard;
import morvell.vuebank.domain.RequestMoney;

public interface RequestMoneyService {

  List<RequestMoney> findAllWithSort(String field, String sort);

  List<RequestMoney> finaAllWithFilter(String field, String like);
}
