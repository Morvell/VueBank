package morvell.vuebank.repo;


import morvell.vuebank.domain.PayAnyCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayAnyCardRepo extends JpaRepository<PayAnyCard, Long> {

}
