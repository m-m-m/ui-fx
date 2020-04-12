/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiMutableComposite} using JavaFx {@link Pane}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxMutableCompositePane<W extends Pane, C extends UiWidget> extends FxMutableComposite<W, C> {

  /**
   * The constructor.
   * 
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxMutableCompositePane(W widget) {

    super(widget);
  }

  @Override
  protected void addChildWidget(C child, int index) {

    ObservableList<Node> childList = this.widget.getChildren();
    if (index == -1) {
      childList.add(getTopNode(child));
    } else {
      childList.add(index, getTopNode(child));
    }
  }

  @Override
  protected void removeChildWidget(C child, int index) {

    this.widget.getChildren().remove(getTopNode(child));
  }

}
