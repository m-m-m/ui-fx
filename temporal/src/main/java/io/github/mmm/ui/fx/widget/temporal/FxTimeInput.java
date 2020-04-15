/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.temporal;

import java.time.LocalDate;
import java.time.LocalTime;

import io.github.mmm.ui.api.widget.temporal.UiTimeInput;
import io.github.mmm.ui.fx.widget.input.FxInput;

/**
 * Implementation of {@link UiTimeInput} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxTimeInput extends FxInput<DateTimePicker, LocalTime> implements UiTimeInput {

  private String autocomplete;

  /**
   * The constructor.
   */
  public FxTimeInput() {

    super(new DateTimePicker());
    this.widget.setFormat("HH:mm:ss");
  }

  @Override
  public LocalTime getValueOrThrow() {

    return this.widget.getDateTimeValue().toLocalTime();
  }

  @Override
  protected void setValueNative(LocalTime value) {

    if (value == null) {
      this.widget.setDateTimeValue(null);
    } else {
      this.widget.setDateTimeValue(value.atDate(LocalDate.now()));
    }
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
