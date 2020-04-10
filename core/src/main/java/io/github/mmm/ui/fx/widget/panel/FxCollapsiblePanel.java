/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.panel.UiCollapsiblePanel;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiCollapsiblePanel} using JavaFx {@link TitledPane}.
 *
 * @since 1.0.0
 */
public class FxCollapsiblePanel extends FxDynamicPanel<VBox> implements UiCollapsiblePanel {

  private final TitledPane topWidget;

  /**
   * The constructor.
   */
  public FxCollapsiblePanel() {

    super(new VBox());
    this.topWidget = new TitledPane();
    this.topWidget.setContent(this.widget);
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

  @Override
  public String getText() {

    return this.topWidget.getText();
  }

  @Override
  public void setText(String name) {

    this.topWidget.setText(name);
  }

  @Override
  public boolean isCollapsed() {

    return !this.topWidget.isExpanded();
  }

  @Override
  public void setCollapsed(boolean collapsed) {

    this.topWidget.setExpanded(!collapsed);
  }

  @Override
  public boolean isCollapsible() {

    return this.topWidget.isCollapsible();
  }

  @Override
  public void setCollapsible(boolean collapsible) {

    this.topWidget.setCollapsible(collapsible);
  }

}
