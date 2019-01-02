package letscode.sarafan.domain;

import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Card {

  private String cardNumber;

  private String expirationDate;

  private String cvv;

}
