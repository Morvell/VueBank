package morvell.vuebank.domain;

import java.time.LocalDateTime;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import morvell.vuebank.validators.CreditCardDate;
import org.hibernate.validator.constraints.Length;

@Entity
@Table
@Data
public class PayAnyCard {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

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

  @NotNull
  @Min(1000)
  @Max(75000)
  private Integer summ;

  @Length(max = 150)
  private String comment;

  @Email
  private String email;

  private Boolean notSafe = false;

  private LocalDateTime lastModify;

  private LocalDateTime created;

  @PrePersist
  protected void onCreate() {
    created = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    lastModify = LocalDateTime.now();
  }
}
