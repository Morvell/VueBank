package morvell.vuebank.repo;

import morvell.vuebank.domain.RequestMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestMoneyRepo extends JpaRepository<RequestMoney, Long> {

}
