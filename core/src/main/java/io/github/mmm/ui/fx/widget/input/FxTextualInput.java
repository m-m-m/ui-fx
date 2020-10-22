/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.event.UiValueChangeEvent;
import io.github.mmm.ui.api.widget.input.UiTextualInput;
import javafx.scene.control.TextInputControl;

/**
 * Implementation of {@link UiTextualInput} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxTextualInput<W extends TextInputControl, V> extends FxInput<W, V> implements UiTextualInput<V> {

  private String autocomplete;

  /**
   * The constructor.
   *
   * @param nativeWidget the {@link #getWidget() JavaFx widget}.
   */
  public FxTextualInput(W nativeWidget) {

    super(nativeWidget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.textProperty().addListener(this::onValueChange);
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    super.setReadOnlyNative(readOnly);
    this.widget.setEditable(!readOnly);
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
  public String getText() {

    return this.widget.getText();
  }

  @Override
  public void setText(String text) {

    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    this.widget.setText(text);
  }

  @Override
  public String getAutocomplete() {

    return this.autocomplete;
  }

  @Override
  public void setAutocomplete(String autocomplete) {

    // Not supported by JavaFx
    this.autocomplete = autocomplete;
  }

}
