/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.bitmask.BitMask;
import io.github.mmm.ui.event.UiValueChangeEvent;
import io.github.mmm.ui.fx.widget.FxActiveWidget;
import io.github.mmm.ui.fx.widget.FxLabel;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.input.UiInput;
import io.github.mmm.validation.Validator;
import javafx.scene.control.Control;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Implementation of {@link UiInput} using JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <V> type of {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxInput<W extends Control, V> extends FxActiveWidget<W> implements UiInput<V> {

  private String name;

  private FxLabel nameWidget;

  private FxInputContainer containerWidget;

  private Validator<? super V> validator;

  private V originalValue;

  private long modificationTimestamp;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxInput(UiContext context, W widget) {

    super(context, widget);
    HBox.setHgrow(this.widget, Priority.ALWAYS);
    this.validator = Validator.none();
    this.modificationTimestamp = -1;
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
      this.nameWidget = new FxLabel(this.context);
      if (this.name != null) {
        this.nameWidget.setText(this.name);
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
      this.containerWidget = new FxInputContainer(this);
    }
    return this.containerWidget;
  }

  @Override
  public void setVisible(boolean visible, BitMask flagMode) {

    super.setVisible(visible, flagMode);
    if (this.nameWidget != null) {
      this.nameWidget.setVisible(visible, flagMode);
    }
  }

  @Override
  public V getOriginalValue() {

    return this.originalValue;
  }

  @Override
  public void setOriginalValue(V originalValue) {

    this.originalValue = originalValue;
  }

  @Override
  protected void doSetValidationFailure(String error) {

    this.widget.pseudoClassStateChanged(CLASS_INVALID, (error != null));
    // TODO apply error to widget (popover/tooltip)
  }

  @Override
  public Validator<? super V> getValidator() {

    return this.validator;
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    if (validator == null) {
      this.validator = Validator.none();
    } else {
      this.validator = validator;
    }
  }

  @Override
  public long getModificationTimestamp() {

    return this.modificationTimestamp;
  }

  private void updateModificationTimestamp(boolean reset) {

    if (reset) {
      this.modificationTimestamp = -1;
    } else {
      this.modificationTimestamp = System.currentTimeMillis();
    }
  }

  @Override
  public void setValue(V value, boolean forUser) {

    updateModificationTimestamp(!forUser);
    if (!forUser) {
      setOriginalValue(value);
    }
    setProgrammaticEventType(UiValueChangeEvent.TYPE);
    setValueNative(value);
  }

  /**
   * @param value the new {@link #getValue() value} to set in the native widget.
   */
  protected abstract void setValueNative(V value);

  @Override
  protected void onValueChanged(boolean programmatic) {

    super.onValueChanged(programmatic);
    if (!programmatic) {
      updateModificationTimestamp(false);
    }
  }

}
