/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.event.UiClickEvent;
import io.github.mmm.ui.api.widget.input.UiCheckbox;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import javafx.scene.control.CheckBox;

/**
 * Implementation of {@link UiTextInput} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxCheckbox extends FxInput<CheckBox, Boolean> implements UiCheckbox {

  /**
   * The constructor.
   */
  public FxCheckbox() {

    super(new CheckBox());
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.selectedProperty().addListener(this::onValueChange);
    this.widget.setOnAction(this::onAction);
  }

  @Override
  public String getText() {

    return this.widget.getText();
  }

  @Override
  public void setText(String text) {

    this.widget.setText(text);
  }

  @Override
  public Boolean getValueOrThrow() {

    return Boolean.valueOf(this.widget.isSelected());
  }

  @Override
  public void setValueNative(Boolean selected) {

    this.widget.setSelected(Boolean.TRUE.equals(selected));
  }

  @Override
  public void click() {

    setValueForUser(Boolean.valueOf(!this.widget.isSelected()));
    fireEvent(new UiClickEvent(this, true));
  }

}
