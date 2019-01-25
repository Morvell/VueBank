package morvell.vuebank.service;

import java.util.List;
import morvell.vuebank.domain.RequestMoney;

public interface RequestMoneyService {

  List<RequestMoney> findAllWithSort(String field, String sort);
}
