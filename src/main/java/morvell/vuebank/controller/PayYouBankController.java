package morvell.vuebank.controller;

import lombok.extern.slf4j.Slf4j;
import morvell.vuebank.mq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("payYouBank")
public class PayYouBankController {

  @Autowired
  private Producer jms;

  @GetMapping
  public void getReport() {
    log.info("IM HERE");
    jms.send("PICKLE REEEEEECK");
  }

  @GetMapping("{id}")
  public String getOne(@PathVariable("id") String message) {
    return message;
  }
}
