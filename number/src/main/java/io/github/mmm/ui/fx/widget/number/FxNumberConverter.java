package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;
import javafx.util.StringConverter;

/**
 * Implementation of {@link StringConverter} for {@link Number}.
 *
 * @param <N> type of the {@link Number}s to convert.
 */
public class FxNumberConverter<N extends Number & Comparable<?>> extends StringConverter<N> {

  private final NumberType<N> type;

  private FxNumberConverter(NumberType<N> type) {

    super();
    this.type = type;
  }

  @Override
  public N fromString(String string) {

    if (string == null) {
      return null;
    }
    string = string.trim();
    if (string.isEmpty()) {
      return this.type.getZero();
    }
    return this.type.parse(string);
  }

  @Override
  public String toString(N number) {

    return this.type.format(number);
  }

  static <N extends Number & Comparable<?>> FxNumberConverter<N> of(NumberType<N> type) {

    return new FxNumberConverter<>(type);
  }

}
