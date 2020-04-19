/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.event.UiValueChangeEvent;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.value.UiValidatableWidget;
import io.github.mmm.validation.Validator;
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
public abstract class FxActiveValidatableWidget<W extends Control, V> extends FxActiveWidget<W>
    implements UiValidatableWidget<V> {

  private Validator<? super V> validator;

  private V originalValue;

  private long modificationTimestamp;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxActiveValidatableWidget(W widget) {

    super(widget);
    HBox.setHgrow(this.widget, Priority.ALWAYS);
    this.validator = Validator.none();
    this.modificationTimestamp = -1;
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