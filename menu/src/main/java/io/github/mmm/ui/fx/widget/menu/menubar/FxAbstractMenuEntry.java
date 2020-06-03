/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.menubar;

import io.github.mmm.ui.api.widget.menu.UiAbstractMenuEntry;
import io.github.mmm.ui.api.widget.menu.UiMenuItemSeparator;
import io.github.mmm.ui.fx.widget.FxWidgetStyleable;
import javafx.scene.control.MenuItem;

/**
 * Implementation of {@link UiAbstractMenuEntry} for JavaFx and {@link FxMenuBar}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractMenuEntry<W extends MenuItem> extends FxWidgetStyleable<W>
    implements UiAbstractMenuEntry {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractMenuEntry(W widget) {

    super(widget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    if (!(this instanceof UiMenuItemSeparator)) {
      this.widget.setOnAction(this::onAction);
    }
  }

  @Override
  public void setId(String id) {

    this.widget.setId(id);
  }

  /**
   * @return {@link io.github.mmm.ui.api.attribute.AttributeWriteText#getText()}.
   */
  public String getText() {

    return this.widget.getText();
  }

  /**
   * @param text {@link io.github.mmm.ui.api.attribute.AttributeWriteText#setText(String)}.
   */
  public void setText(String text) {

    this.widget.setText(text);
  }

  @Override
  public void setEnabledNative(boolean enabled) {

    this.widget.setDisable(!enabled);
  }

  @Override
  public void setVisibleNative(boolean visible) {

    this.widget.setVisible(visible);
  }

  @Override
  protected void setTooltipNative(String newTooltip) {

    // not supported by JavaFx
  }

  @Override
  public boolean isFocused() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean setFocused() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  protected void doDispose() {

    super.doDispose();
    this.widget.setOnAction(null);
  }

}
