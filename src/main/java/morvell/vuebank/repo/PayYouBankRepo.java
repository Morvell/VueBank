package morvell.vuebank.repo;

import morvell.vuebank.domain.PayYouBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayYouBankRepo extends JpaRepository<PayYouBank, Long> {

}
