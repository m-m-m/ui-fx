package io.github.mmm.ui.fx.widget.number;

import java.util.function.Consumer;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.spi.range.NumericRange;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.SpinnerValueFactory;

/**
 * Proper implementation of {@link SpinnerValueFactory} since the JavaFx default implementations cannot properly handle
 * {@code null} values and are incomplete.
 *
 * @param <N> type of the managed {@link Number}.
 */
public abstract class FxNumberSpinnerValueFactory<N extends Number & Comparable<N>> extends SpinnerValueFactory<N> {

  private final NumberType<N> numberType;

  private final NumericRange<N> range;

  private N amountToStepBy;

  FxNumberSpinnerValueFactory(NumberType<N> numberType, N min, N max) {

    this(numberType, min, max, null, null);
  }

  FxNumberSpinnerValueFactory(NumberType<N> numberType, N min, N max, N initialValue, N amountToStepBy) {

    super();
    this.numberType = numberType;
    this.range = new NumericRange<>(numberType, min, max);
    setAmountToStepBy(amountToStepBy);
    setConverter(FxNumberConverter.of(numberType));

    valueProperty().addListener((o, oldValue, newValue) -> {
      if (newValue == null) {
        return;
      }
      N value = this.range.clip(newValue, isWrapAround());
      if (value != newValue) {
        setValue(value);
      }
    });
    setValue(initialValue);
  }

  /**
   * @param name the {@link Property#getName() property name}.
   * @param invalidator the {@link Consumer} function to be called on invalidation of the property. May be {@code null}
   *        for no custom invalidator.
   * @return the created {@link Property}.
   */
  protected Property<N> newProperty(String name, Consumer<Property<N>> invalidator) {

    if (invalidator == null) {
      return new SimpleObjectProperty<>(this, name);
    }
    return new SimpleObjectProperty<>(this, name) {
      protected void invalidated() {

        invalidator.accept(this);
      };
    };
  }

  /**
   * @return the step amount.
   */
  public final N getAmountToStepBy() {

    return this.amountToStepBy;
  }

  /**
   * @param value the new value of {@link #getAmountToStepBy()}.
   */
  public final void setAmountToStepBy(N value) {

    if (value == null) {
      this.amountToStepBy = this.numberType.getOne();
    } else {
      assert (this.numberType.isPositive(value));
      this.amountToStepBy = value;
    }
  }

  /**
   * @return the {@link NumericRange}.
   */
  public NumericRange<N> getRange() {

    return this.range;
  }

  @Override
  public void decrement(int steps) {

    N value = getValue();
    if (value == null) {
      value = this.numberType.getZero();
    }
    N dec = getAmountToStepBy();
    if (steps != 1) {
      dec = this.numberType.multiply(Integer.valueOf(steps), dec);
    }
    value = this.numberType.subtract(value, dec);
    value = this.range.clip(value, isWrapAround());
    setValue(value);
  }

  @Override
  public void increment(int steps) {

    N value = getValue();
    if (value == null) {
      value = this.numberType.getZero();
    }
    N inc = getAmountToStepBy();
    if (steps != 1) {
      inc = this.numberType.multiply(Integer.valueOf(steps), inc);
    }
    value = this.numberType.add(value, inc);
    value = this.range.clip(value, isWrapAround());
    setValue(value);
  }

}
