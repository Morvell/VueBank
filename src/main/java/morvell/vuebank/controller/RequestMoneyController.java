package morvell.vuebank.controller;

import javax.validation.Valid;
import morvell.vuebank.domain.RequestMoney;
import morvell.vuebank.repo.RequestMoneyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("requestMoney")
public class RequestMoneyController {

  private final RequestMoneyRepo requestMoneyRepo;

  @Autowired
  public RequestMoneyController(RequestMoneyRepo requestMoneyRepo) {
    this.requestMoneyRepo = requestMoneyRepo;
  }

  @PostMapping
  public RequestMoney create(@Valid @RequestBody RequestMoney requestMoney) {
    return requestMoneyRepo.save(requestMoney);
  }
}
