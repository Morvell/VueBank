package morvell.vuebank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class PayYouBank {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String paymentFrom;

  private String bic;

  private String paymentNumber;

  private String paymentFor;

  private Integer paymentSum;

  private String owner;

  private byte[] report;
}
