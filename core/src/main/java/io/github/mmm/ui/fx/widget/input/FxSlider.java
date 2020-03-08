/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.base.range.WritableRange;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.spi.range.NumericRange;
import io.github.mmm.ui.widget.input.UiSlider;
import io.github.mmm.validation.Validator;
import javafx.scene.control.Slider;

/**
 * Implementation of {@link UiSlider} using JavaFx {@link Slider}.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxSlider<V extends Number> extends FxInput<Slider, V> implements UiSlider<V> {

  private final NumericRange<V> range;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxSlider(UiContext context) {

    super(context, new Slider());
    this.range = new NumericRange<>(getNumberType());
  }

  /**
   * @return the {@link NumberType} for the underlying {@link Number}.
   */
  protected abstract NumberType<V> getNumberType();

  @Override
  public WritableRange<V> getRange() {

    return this.range;
  }

  @Override
  public V getValueOrThrow() {

    return getNumberType().valueOf(Double.valueOf(this.widget.getValue()));
  }

  @Override
  protected void setValueNative(V value) {

    double v = 0;
    if (value != null) {
      v = this.range.clip(value).doubleValue();
    }
    this.widget.setValue(v);
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    super.setValidator(validator);
    this.range.setValidator(validator);
  }

  @Override
  public boolean isTextVisible() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setTextVisible(boolean outputVisible) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isTextEditable() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setTextEditable(boolean outputEditable) {

    // TODO Auto-generated method stub

  }

}
