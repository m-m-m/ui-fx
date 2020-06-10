/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.tab;

import java.util.function.Supplier;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiComposite;
import io.github.mmm.ui.api.widget.tab.UiTab;
import io.github.mmm.ui.api.widget.tab.UiTabPanel;
import io.github.mmm.ui.fx.widget.FxWidgetStyleable;
import javafx.event.Event;
import javafx.scene.control.Tab;

/**
 * Implementation of {@link UiTab} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxTab extends FxWidgetStyleable<Tab> implements UiTab {

  private UiRegularWidget child;

  private Supplier<UiRegularWidget> childSupplier;

  /**
   * The constructor.
   */
  public FxTab() {

    super(new Tab());
    this.widget.setUserData(this);
    this.widget.setClosable(false);
    ensureHandlers();
  }

  private FxTabPanel getTabPanel() {

    return (FxTabPanel) getParent();
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnCloseRequest(this::onClose);
  }

  @Override
  protected void onClose(Event event) {

    super.onClose(event);
    UiComposite<?> parent = getParent();
    if (parent != null) {
      ((UiTabPanel) parent).removeChild(this);
    }
  }

  @Override
  public UiRegularWidget getChild() {

    if ((this.child == null) && (this.childSupplier != null)) {
      setChild(this.childSupplier.get());
      assert (this.child != null);
      this.childSupplier = null;
    }
    return this.child;
  }

  @Override
  public void setChild(UiRegularWidget child) {

    if (child == this.child) {
      return;
    }
    if (this.child != null) {
      setParent(this.child, null);
    }
    this.widget.setContent(getTopNode(child));
    this.child = child;
    setParent(child, this);
  }

  /**
   * @param childSupplier the {@link Supplier} {@link Supplier#get() providing} the {@link #getChild() child widget}.
   */
  public void setChild(Supplier<UiRegularWidget> childSupplier) {

    this.childSupplier = childSupplier;
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
  protected void setIdNative(String id) {

    this.widget.setId(id);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    FxTabPanel tabPanel = getTabPanel();
    if (tabPanel != null) {
      tabPanel.setTabVisible(this, visible);
    }
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    this.widget.setDisable(!enabled);
  }

  @Override
  protected void setTooltipNative(String newTooltip) {

    // currently not supported...
  }

  @Override
  public char getAccessKey() {

    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setAccessKey(char accessKey) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isFocused() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean setFocused() {

    return false;
  }

  @Override
  public boolean isClosable() {

    return this.widget.isClosable();
  }

  @Override
  public void setClosable(boolean closable) {

    this.widget.setClosable(closable);
    if (closable) {
      ensureHandlers();
    }
  }

  /**
   * @param tab the JavaFx {@link Tab}.
   * @return the owning {@link FxTab}.
   */
  public static FxTab get(Tab tab) {

    return (FxTab) tab.getUserData();
  }

}
