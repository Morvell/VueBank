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
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
@Data
public class PayAnyCard {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Embedded
  private Card card;

  @NotNull
  private Integer summ;

  private String comment;

  private String email;

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
