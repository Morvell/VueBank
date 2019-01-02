package letscode.sarafan.controller;

import letscode.sarafan.domain.PayAnyCard;
import letscode.sarafan.repo.PayAnyCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payAnyCard")
public class PayAnyCardController {
  private final PayAnyCardRepo payAnyCardRepo;

  @Autowired
  public PayAnyCardController(PayAnyCardRepo payAnyCardRepo) {
    this.payAnyCardRepo = payAnyCardRepo;
  }

  @PostMapping
  public PayAnyCard create(@RequestBody PayAnyCard payAnyCard) {
    return payAnyCardRepo.save(payAnyCard);
  }
}
