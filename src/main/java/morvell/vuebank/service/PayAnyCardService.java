package morvell.vuebank.service;

import java.util.List;
import morvell.vuebank.domain.PayAnyCard;

public interface PayAnyCardService {
  List<PayAnyCard> findAllWithSort(String field, String sort);
}
