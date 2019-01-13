package morvell.vuebank.validators;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringEqualsValidator implements ConstraintValidator<StringEquals, String> {


  private Set<String> validStrings;

  @Override
  public void initialize(StringEquals constraint) {
    validStrings = Arrays.stream(constraint.strings()).collect(Collectors.toSet());
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return validStrings.contains(value);
  }
}
