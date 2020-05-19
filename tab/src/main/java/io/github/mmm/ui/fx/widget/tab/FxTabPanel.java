/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.tab;

import java.util.function.Supplier;

import io.github.mmm.ui.api.datatype.UiVisibleFlags;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.tab.UiTab;
import io.github.mmm.ui.api.widget.tab.UiTabPanel;
import io.github.mmm.ui.fx.widget.FxAtomicWidgetMixin;
import io.github.mmm.ui.fx.widget.composite.FxMutableComposite;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Implementation of {@link UiTabPanel} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxTabPanel extends FxMutableComposite<TabPane, UiTab> implements UiTabPanel, FxAtomicWidgetMixin<TabPane> {

  /**
   * The constructor.
   */
  public FxTabPanel() {

    super(new TabPane());
    this.widget.getSelectionModel().selectedIndexProperty().addListener(this::onTabSelection);
  }

  private void onTabSelection(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

    ObservableList<Tab> tabs = this.widget.getTabs();
    int index = newValue.intValue();
    if (index >= tabs.size()) {
      return;
    }
    Tab tab = tabs.get(index);
    FxTab fxTab = FxTab.get(tab);
    if (fxTab == null) {
      return;
    }
    fxTab.getChild(); // force lazy init
  }

  private Tab getTab(UiTab child) {

    return ((FxTab) child).getWidget();
  }

  @Override
  protected void addChildWidget(UiTab child, int index) {

    FxTab fxTab = (FxTab) child;
    if (index == -1) {
      this.widget.getTabs().add(fxTab.getWidget());
    } else {
      this.widget.getTabs().add(index, fxTab.getWidget());
    }
  }

  @Override
  public UiTab addTab(String text, UiRegularWidget child) {

    FxTab tab = new FxTab();
    setParent(tab, this);
    tab.setText(text);
    tab.setChild(child);
    addChild(tab);
    return tab;
  }

  @Override
  public UiTab addTab(String text, Supplier<UiRegularWidget> childSupplier) {

    FxTab tab = new FxTab();
    setParent(tab, this);
    tab.setText(text);
    tab.setChild(childSupplier);
    addChild(tab);
    return tab;
  }

  @Override
  protected void removeChildWidget(UiTab child, int index) {

    this.widget.getTabs().remove(index);
  }

  @Override
  public UiTab getActiveChild() {

    Tab tab = this.widget.getSelectionModel().getSelectedItem();
    if (tab == null) {
      return null;
    }
    return FxTab.get(tab);
  }

  @Override
  public int getActiveChildIndex() {

    UiTab tab = getActiveChild();
    if (tab == null) {
      return -1;
    }
    return this.children.indexOf(tab);
  }

  @Override
  public boolean setActiveChild(UiTab child) {

    this.widget.getSelectionModel().select(getTab(child));
    return true;
  }

  /**
   * @param fxTab the {@link FxTab} to change visibility.
   * @param visible - {@code true} to show, {@code false} to hide.
   */
  public void setTabVisible(FxTab fxTab, boolean visible) {

    ObservableList<Tab> tabs = this.widget.getTabs();
    if (visible) {
      int index = 0;
      for (UiTab uiTab : this.children) {
        if (uiTab == fxTab) {
          tabs.add(index, fxTab.getWidget());
          break;
        } else {
          if (uiTab.isVisible(UiVisibleFlags.ANY)) {
            index++;
          }
        }
      }
    } else {
      tabs.remove(fxTab.getWidget());
    }
  }

}
