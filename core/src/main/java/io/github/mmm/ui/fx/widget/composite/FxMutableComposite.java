/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableComposite;
import javafx.scene.Node;

/**
 * Implementation of {@link UiMutableComposite} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxMutableComposite<W extends Node, C extends UiWidget> extends FxRemovableComposite<W, C>
    implements UiMutableComposite<C> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxMutableComposite(W widget) {

    super(widget);
  }

  @Override
  public void addChild(C child, int index) {

    addChildWidget(child, index);
    setParent(child, this);
    if (index == -1) {
      this.children.add(child);
    } else {
      this.children.add(index, child);
    }
  }

  /**
   * @param child the child to add.
   * @param index the index where to insert the child.
   * @see #addChild(UiWidget, int)
   */
  protected abstract void addChildWidget(C child, int index);

}
