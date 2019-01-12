package morvell.vuebank.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class RequestMoney {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  private String requestConsumer;

  @Pattern(regexp = "[0-9]{9}")
  private String bic;

  @NotBlank
  private String paymentNumber;

  @NotBlank
  private String paymentFor;

  @NotNull
  @Min(1000)
  @Max(75000)
  private Integer paymentSum;

  @Email
  @NotBlank
  private String mail;

  @NotBlank
  @Pattern(regexp = "[0-9]{10}")
  private String telephoneNumber;

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
