/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.form;

import io.github.mmm.ui.api.widget.form.UiFormGroup;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.fx.widget.composite.FxValuedComposite;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiFormGroup} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class FxFormGroup<V> extends FxValuedComposite<VBox, UiInput<?>, V> implements UiFormGroup<V> {

  private final TitledPane topWidget;

  /**
   * The constructor.
   */
  public FxFormGroup() {

    super(new VBox());
    this.topWidget = new TitledPane();
    this.topWidget.setContent(this.widget);
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

  @Override
  public String getName() {

    return this.topWidget.getText();
  }

  @Override
  public void setName(String name) {

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

  @Override
  protected void addChildWidget(UiInput<?> child, int index) {

    int rows = this.children.size();
    Node topNode = getTopNode(child.getContainerWidget());
    if ((index == -1) || (index == rows)) {
      this.widget.getChildren().add(topNode);
    } else if (index < rows) {
      this.widget.getChildren().add(index, topNode);
    }
  }

  @Override
  protected void removeChildWidget(UiInput<?> child, int index) {

    this.widget.getChildren().remove(index);
  }

}
