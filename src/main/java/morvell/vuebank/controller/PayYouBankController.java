package morvell.vuebank.controller;

import java.io.ByteArrayInputStream;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import morvell.vuebank.domain.PayYouBank;
import morvell.vuebank.domain.User;
import morvell.vuebank.mq.Producer;
import morvell.vuebank.repo.PayYouBankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("payYouBank")
public class PayYouBankController {

  @Autowired
  private Producer jms;

  @Autowired
  PayYouBankRepo repo;

  @PostMapping
  public long create(@Valid @RequestBody PayYouBank payYouBank, @AuthenticationPrincipal User user) {
    log.info("Receive payYouBank request with {}", payYouBank);

    payYouBank.setOwner(user.getId());

    long id = repo.save(payYouBank).getId();

    jms.send(id);

    return id;
  }

  @GetMapping("{id}")
  public ResponseEntity<InputStreamResource> getOne(@PathVariable("id") Long reportId,
      @AuthenticationPrincipal User user) {

    if (repo.findById(reportId).get().getOwner().equals(user.getId())) {

      HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Disposition", "inline; filename=report"+reportId+".pdf");

      return ResponseEntity
          .ok()
          .headers(headers)
          .contentType(MediaType.APPLICATION_PDF)
          .body(new InputStreamResource(
              new ByteArrayInputStream(repo.findById(reportId).get().getReport())));
    } else {
      return ResponseEntity
          .badRequest()
          .body(new InputStreamResource(null));
    }
  }


}
