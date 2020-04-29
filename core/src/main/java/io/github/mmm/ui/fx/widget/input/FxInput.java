/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.datatype.bitmask.BitMask;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.form.UiInputContainer;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.fx.widget.FxActiveValidatableWidget;
import io.github.mmm.ui.fx.widget.FxLabel;
import javafx.scene.control.Control;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Implementation of {@link UiInput} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxInput<W extends Control, V> extends FxActiveValidatableWidget<W, V> implements UiInput<V> {

  private String name;

  private FxLabel nameWidget;

  private UiInputContainer<V> containerWidget;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxInput(W widget) {

    super(widget);
    HBox.setHgrow(this.widget, Priority.ALWAYS);
  }

  @Override
  public String getName() {

    if (this.nameWidget == null) {
      return this.name;
    } else {
      return this.nameWidget.getText();
    }
  }

  @Override
  public void setName(String name) {

    if (this.nameWidget == null) {
      this.name = name;
    } else {
      this.nameWidget.setText(name);
    }
  }

  @Override
  public boolean hasNameWidget() {

    return (this.nameWidget != null);
  }

  @Override
  public FxLabel getNameWidget() {

    if (this.nameWidget == null) {
      this.nameWidget = new FxLabel();
      if (this.name != null) {
        this.nameWidget.setText(this.name);
      }
      if (getValidator().isMandatory()) {
        this.nameWidget.getStyles().add(STYLE_MANDATORY);
      }
      doSetVisibleState(this.nameWidget, doGetVisibleState(this));
      String id = getId();
      if (id != null) {
        this.nameWidget.setId(id + "_label");
      }
    }
    return this.nameWidget;
  }

  @Override
  public boolean hasContainerWidget() {

    return (this.containerWidget != null);
  }

  @Override
  public UiRegularWidget getContainerWidget() {

    if (this.containerWidget == null) {
      this.containerWidget = UiInputContainer.of(this);
    }
    return this.containerWidget;
  }

  @Override
  protected void setMandatory(boolean mandatory) {

    super.setMandatory(mandatory);
    if (this.nameWidget != null) {
      if (mandatory) {
        this.nameWidget.getStyles().add(STYLE_MANDATORY);
      } else {
        this.nameWidget.getStyles().remove(STYLE_MANDATORY);
      }
    }
  }

  @Override
  public void setVisible(boolean visible, BitMask flagMode) {

    super.setVisible(visible, flagMode);
    if (this.nameWidget != null) {
      this.nameWidget.setVisible(visible, flagMode);
    }
  }

  /**
   * @param value the new {@link #getValue() value} to set in the native widget.
   */
  @Override
  protected abstract void setValueNative(V value);

}
