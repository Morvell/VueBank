package morvell.vuebank;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.rmi.runtime.Log;

@Slf4j
@SpringBootApplication
public class VueBankApplication {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	public static void main(String[] args) {
		SpringApplication.run(VueBankApplication.class, args);
		log.info("start!!!!!!!!!!!!");
	}
}
