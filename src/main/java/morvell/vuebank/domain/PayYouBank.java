package morvell.vuebank.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table
@Data
public class PayYouBank {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  @Length(min = 10, max = 12)
  private String paymentFrom;

  @NotBlank
  @Length(min = 9, max = 9)
  private String bic;

  @NotBlank
  private String paymentNumber;

  @NotBlank
  private String paymentFor;

  @NotNull
  @Min(1000)
  @Max(75000)
  private Integer paymentSum;

  private String owner;

  private byte[] report;

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
