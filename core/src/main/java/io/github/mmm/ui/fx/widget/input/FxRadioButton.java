/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.UiToggleGroup;
import io.github.mmm.ui.api.event.UiClickEvent;
import io.github.mmm.ui.api.widget.input.UiRadioButton;
import io.github.mmm.ui.fx.FxToggleGroup;
import javafx.scene.control.RadioButton;

/**
 * Implementation of {@link UiRadioButton} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxRadioButton extends FxInput<RadioButton, Boolean> implements UiRadioButton {

  private FxToggleGroup toggleGroup;

  /**
   * The constructor.
   */
  public FxRadioButton() {

    super(new RadioButton());
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
  public FxToggleGroup getToggleGroup() {

    return this.toggleGroup;
  }

  @Override
  public void setToggleGroup(UiToggleGroup group) {

    this.toggleGroup = (FxToggleGroup) group;
    this.widget.setToggleGroup(this.toggleGroup.getGroup());
  }

  @Override
  public void click() {

    setValueForUser(Boolean.TRUE);
    fireEvent(new UiClickEvent(this, true));
  }

}
