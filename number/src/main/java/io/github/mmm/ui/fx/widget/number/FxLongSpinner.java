/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.number.UiLongInput;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.converter.LongStringConverter;

/**
 * Implementation of {@link UiLongInput} for JavaFx as {@link FxSpinner}.
 *
 * @since 1.0.0
 */
public class FxLongSpinner extends FxSpinner<Long> implements UiLongInput {

  private final LongSpinnerValueFactory factory;

  /**
   * The constructor.
   */
  public FxLongSpinner() {

    this(new LongSpinnerValueFactory(Long.MIN_VALUE, Long.MAX_VALUE, null, 1));
  }

  private FxLongSpinner(LongSpinnerValueFactory factory) {

    super(factory);
    this.factory = factory;
  }

  @Override
  protected NumberType<Long> getNumberType() {

    return NumberType.LONG;
  }

  @Override
  public Long getStep() {

    return Long.valueOf(this.factory.getAmountToStepBy());
  }

  @Override
  public void setStep(Long step) {

    if (step != null) {
      this.factory.setAmountToStepBy(step.longValue());
    }
  }

  private static class LongSpinnerValueFactory extends SpinnerValueFactory<Long> {

    private LongSpinnerValueFactory(long min, long max, Long initialValue, long amountToStepBy) {

      setMin(min);
      setMax(max);
      setAmountToStepBy(amountToStepBy);
      setConverter(new LongStringConverter());

      valueProperty().addListener((o, oldValue, newValue) -> {
        if (newValue == null) {
          return;
        }
        long v = newValue.longValue();
        long mimimum = getMin();
        if (v < mimimum) {
          setValue(Long.valueOf(mimimum));
        } else {
          long maximum = getMax();
          if (v > maximum) {
            setValue(Long.valueOf(maximum));
          }
        }
      });
      setValue(initialValue);
    }

    private LongProperty min = new SimpleLongProperty(this, "min") {
      @Override
      protected void invalidated() {

        Long currentValue = LongSpinnerValueFactory.this.getValue();
        if (currentValue == null) {
          return;
        }

        long minimum = get();
        long maximum = getMax();
        if (minimum > maximum) {
          setMin(maximum);
          return;
        }

        if (currentValue.longValue() < minimum) {
          LongSpinnerValueFactory.this.setValue(minimum);
        }
      }
    };

    private LongProperty max = new SimpleLongProperty(this, "max") {
      @Override
      protected void invalidated() {

        Long currentValue = LongSpinnerValueFactory.this.getValue();
        if (currentValue == null) {
          return;
        }

        long minimum = getMin();
        long maximum = get();
        if (maximum < minimum) {
          setMax(minimum);
          return;
        }

        if (currentValue.longValue() > maximum) {
          LongSpinnerValueFactory.this.setValue(maximum);
        }
      }
    };

    private LongProperty amountToStepBy = new SimpleLongProperty(this, "amountToStepBy");

    public final void setMin(long value) {

      this.min.set(value);
    }

    public final long getMin() {

      return this.min.get();
    }

    public final void setMax(long value) {

      this.max.set(value);
    }

    public final long getMax() {

      return this.max.get();
    }

    public final void setAmountToStepBy(long value) {

      this.amountToStepBy.set(value);
    }

    public final long getAmountToStepBy() {

      return this.amountToStepBy.get();
    }

    @Override
    public void decrement(int steps) {

      final long minimum = getMin();
      final long maximum = getMax();
      final Long current = getValue();
      long currentValue = 0;
      if (current != null) {
        currentValue = current.longValue();
      }
      final long newValue = currentValue - steps * getAmountToStepBy();
      setValue(newValue >= minimum ? newValue : (isWrapAround() ? wrapValue(newValue, minimum, maximum) + 1 : minimum));
    }

    /** {@inheritDoc} */
    @Override
    public void increment(int steps) {

      final long minimum = getMin();
      final long maximum = getMax();
      final Long current = getValue();
      long currentValue = 0;
      if (current != null) {
        currentValue = current.longValue();
      }
      final long newValue = currentValue + steps * getAmountToStepBy();
      setValue(newValue <= maximum ? newValue : (isWrapAround() ? wrapValue(newValue, minimum, maximum) - 1 : maximum));
    }

    private static long wrapValue(long value, long min, long max) {

      if (max == 0) {
        throw new IllegalArgumentException("max=0");
      }

      long r = value % max;
      if (r > min && max < min) {
        r = r + max - min;
      } else if (r < min && max > min) {
        r = r + max - min;
      }
      return r;
    }
  }

}
