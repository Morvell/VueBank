package morvell.vuebank.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreditCardDateValidator implements ConstraintValidator<CreditCardDate, String> {

  @Override
  public void initialize(CreditCardDate constraintAnnotation) {

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return check(value);
  }

  private boolean check(String value) {
   String part1 = value.substring(0,2);
   String part2 = value.substring(2,4);

   int one = Integer.parseInt(part1);
   int two = Integer.parseInt(part2);

   if (one<1 || one >12) {
     return false;
   }

   if (two<19 || two >35) {
     return false;
   }

   return true;
  }

}
