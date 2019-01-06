package morvell.vuebank.mq;

import javax.jms.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;

  @Autowired
  private Queue queue;

  public void send(String msg) {
    this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    log.info("send jms message {}", msg);
  }

}
