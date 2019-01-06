package morvell.vuebank.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

  @JmsListener(destination = "sample.queue")
  public void receiveQueue(String text) {
    log.info("recieve message {}", text);
  }

}
