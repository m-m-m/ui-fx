/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.temporal;

import java.time.LocalDateTime;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.input.FxInput;
import io.github.mmm.ui.widget.temporal.UiDateTimeInput;

/**
 * Implementation of {@link UiDateTimeInput} for JavaFx using {@link DateTimePicker}.
 *
 * @since 1.0.0
 */
public class FxDateTimeInput extends FxInput<DateTimePicker, LocalDateTime> implements UiDateTimeInput {

  private String autocomplete;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxDateTimeInput(UiContext context) {

    super(context, new DateTimePicker());
  }

  @Override
  public LocalDateTime getValueOrThrow() {

    return this.widget.getDateTimeValue();
  }

  @Override
  protected void setValueNative(LocalDateTime value) {

    this.widget.setDateTimeValue(value);
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
