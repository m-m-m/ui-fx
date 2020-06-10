/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.datatype.UiEnabledFlags;
import io.github.mmm.ui.api.datatype.UiVisibleFlags;
import io.github.mmm.ui.api.event.UiClickEvent;
import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.UiFocusGainEvent;
import io.github.mmm.ui.api.event.UiFocusLossEvent;
import io.github.mmm.ui.api.event.UiHideEvent;
import io.github.mmm.ui.api.event.UiValueChangeEvent;
import io.github.mmm.ui.api.widget.UiCustomWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.spi.widget.AbstractUiNativeWidgetWrapper;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;

/**
 * Implementation of {@link io.github.mmm.ui.api.widget.UiNativeWidget} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidget<W> extends AbstractUiNativeWidgetWrapper<W> {

  /**
   * {@link PseudoClass} if JavaFx widget gets
   * {@link io.github.mmm.ui.fx.widget.input.FxInput#setValidationFailure(String) invalid}.
   */
  public static final PseudoClass CLASS_INVALID = PseudoClass.getPseudoClass("invalid");

  /**
   * {@link PseudoClass} if JavaFx widget gets {@link io.github.mmm.ui.fx.widget.input.FxInput#setReadOnly(boolean)
   * read-only}.
   */
  public static final PseudoClass CLASS_READ_ONLY = PseudoClass.getPseudoClass("read-only");

  /** @see #getWidget() */
  protected W widget;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidget(W widget) {

    super();
    this.widget = widget;
  }

  @Override
  public W getWidget() {

    return this.widget;
  }

  /**
   * @param widget the JavaFx {@link #getWidget() widget} to initialize.
   */
  protected void setWidget(W widget) {

    this.widget = widget;
    if (this.widget == null) {
      return;
    }
    if (!isVisible(UiVisibleFlags.ALL)) {
      setVisibleNative(false);
    }
    if (!isEnabled(UiEnabledFlags.ALL)) {
      setEnabledNative(false);
    }
    if (isReadOnly()) {
      setReadOnlyNative(true);
    }
    String tooltip = getTooltip();
    if (tooltip != null) {
      setTooltipNative(tooltip);
    }
  }

  /**
   * @param uiWidget the {@link UiWidget}.
   * @return the {@link #getWidget() containing} JavaFx {@link Node}.
   */
  public static Node getTopNode(UiWidget uiWidget) {

    if (uiWidget instanceof UiCustomWidget) {
      return getTopNode(((UiCustomWidget<?>) uiWidget).getDelegate());
    } else if (uiWidget != null) {
      return ((FxWidgetNode<?>) uiWidget).getTopWidget();
    }
    return null;
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

  }

  /**
   * @param widget the {@link Control} where to apply the tooltip to.
   * @param tooltip the tooltip text to apply.
   */
  public static void setTooltip(Control widget, String tooltip) {

    if ((tooltip == null) || tooltip.isEmpty()) {
      widget.setTooltip(null);
    } else {
      Tooltip fxTooltip = widget.getTooltip();
      if (fxTooltip == null) {
        fxTooltip = new Tooltip(tooltip);
        widget.setTooltip(fxTooltip);
      } else {
        fxTooltip.setText(tooltip);
      }
    }
  }

  /**
   * @param event the {@link ActionEvent}.
   */
  protected void onAction(ActionEvent event) {

    fireEvent(new UiClickEvent(this, false));
  }

  /**
   * @param observable the observable (property) that changed.
   * @param oldValue the old value.
   * @param newValue the new value.
   */
  protected void onFocusChange(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

    onFocusChanged(Boolean.TRUE.equals(newValue));
  }

  /**
   * @param focusGain {@code true} if the focus was gained, {@code false} otherwise (focus has been lost).
   */
  protected void onFocusChanged(boolean focusGain) {

    UiEvent event;
    if (focusGain) {
      event = UiFocusGainEvent.of(this, getProgrammaticEventType());
    } else {
      event = UiFocusLossEvent.of(this, getProgrammaticEventType());
      validate(false);
    }
    fireEvent(event);
  }

  /**
   * @param <V> type of the value.
   * @param observable the observable (property) that changed.
   * @param oldValue the old value.
   * @param newValue the new value.
   */
  protected <V> void onValueChange(ObservableValue<? extends V> observable, V oldValue, V newValue) {

    boolean programmatic = getProgrammaticEventType() == UiValueChangeEvent.TYPE;
    onValueChanged(programmatic);
    fireEvent(new UiValueChangeEvent(this, programmatic));
  }

  /**
   * Called from {@link #onValueChange(ObservableValue, Object, Object)} if triggered by end-user.
   *
   * @param programmatic - see {@link UiValueChangeEvent#isProgrammatic()}.
   */
  protected void onValueChanged(boolean programmatic) {

  }

  /**
   * @param event the close {@link Event}.
   */
  protected void onClose(Event event) {

    boolean programmatic = getProgrammaticEventType() == UiHideEvent.TYPE;
    fireEvent(new UiHideEvent(this, programmatic));
  }

}