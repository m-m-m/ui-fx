/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.base.range.WritableRange;
import io.github.mmm.ui.api.widget.number.UiNumberInput;
import io.github.mmm.ui.api.widget.number.UiSlider;
import io.github.mmm.ui.fx.widget.input.FxInput;
import io.github.mmm.ui.spi.range.NumericRange;
import io.github.mmm.validation.Validator;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * Implementation of {@link UiSlider} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxSpinner<V extends Number & Comparable<?>> extends FxInput<Spinner<V>, V>
    implements UiNumberInput<V> {

  private final NumericRange<V> range;

  private String autocomplete;

  /**
   * The constructor.
   *
   * @param factory the {@link SpinnerValueFactory}.
   */
  public FxSpinner(SpinnerValueFactory<V> factory) {

    super(new Spinner<>(factory));
    this.widget.setMaxWidth(Double.MAX_VALUE);
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

    return this.widget.getValue();
  }

  @Override
  protected void setValueNative(V value) {

    this.widget.getValueFactory().setValue(value);
  }

  @Override
  public String getText() {

    V value = this.widget.getValue();
    if (value == null) {
      return null;
    }
    return value.toString();
  }

  @Override
  public void setText(String text) {

    try {
      V value = getNumberType().parse(text);
      setValueNative(value);
    } catch (NumberFormatException e) {
      setValidationFailure("Invalid number");
    }
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    super.setValidator(validator);
    this.range.setValidator(validator);
  }

  @Override
  public String getPlaceholder() {

    return this.widget.getPromptText();
  }

  @Override
  public void setPlaceholder(String placeholder) {

    this.widget.setPromptText(placeholder);
  }

  @Override
  public String getAutocomplete() {

    return this.autocomplete;
  }

  @Override
  public void setAutocomplete(String autocomplete) {

    this.autocomplete = autocomplete;
  }

}
