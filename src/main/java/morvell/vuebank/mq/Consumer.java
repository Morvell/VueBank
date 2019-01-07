package morvell.vuebank.mq;

import lombok.extern.slf4j.Slf4j;
import morvell.vuebank.report.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

  @Autowired
  GeneratePdfReport generatePdfReport;

  @JmsListener(destination = "sample.queue")
  public void receiveQueue(Long id) {
    log.info("recieve message {}", id);
    generatePdfReport.generateReport(id);
  }

}
