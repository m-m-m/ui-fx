/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.temporal;

import java.time.LocalDate;

import io.github.mmm.ui.api.widget.temporal.UiDateInput;
import io.github.mmm.ui.fx.widget.input.FxInput;
import javafx.scene.control.DatePicker;

/**
 * Implementation of {@link UiDateInput} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxDateInput extends FxInput<DatePicker, LocalDate> implements UiDateInput {

  private String autocomplete;

  /**
   * The constructor.
   */
  public FxDateInput() {

    super(new DatePicker());
  }

  @Override
  public LocalDate getValueOrThrow() {

    return this.widget.getValue();
  }

  @Override
  protected void setValueNative(LocalDate value) {

    this.widget.setValue(value);
  }

  @Override
  public String getText() {

    return this.widget.getEditor().getText();
  }

  @Override
  public void setText(String text) {

    this.widget.getEditor().setText(text);
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
