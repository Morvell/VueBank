package morvell.vuebank.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import morvell.vuebank.validators.CreditCardDate;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

@Embeddable
@Data
public class Card {

  //@CreditCardNumber
  @Length(max = 16, min = 16)
  private String cardNumber;

  @NotBlank
  @Length(min = 4, max = 4)
  @CreditCardDate
  private String expirationDate;

  @NotBlank
  @Length(max = 3, min = 3)
  private String cvv;

}
