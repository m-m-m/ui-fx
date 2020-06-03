/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiRemovableComposite;
import javafx.scene.Node;

/**
 * Implementation of {@link UiRemovableComposite} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <C> type of the {@link #getChild(int) child widgets}.
 * @since 1.0.0
 */
public abstract class FxRemovableComposite<W extends Node, C extends UiWidget> extends FxComposite<W, C>
    implements UiRemovableComposite<C> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxRemovableComposite(W widget) {

    super(widget);
  }

  @Override
  public C removeChild(int index) {

    if (index == -1) {
      index = this.children.size() - 1;
    }
    C child = this.children.remove(index);
    removeChildWidget(child, index);
    setParent(child, null);
    return child;
  }

  /**
   * @param child the child to remove.
   * @param index the index of the child to remove.
   * @see #removeChild(UiWidget)
   * @see #removeChild(int)
   */
  protected abstract void removeChildWidget(C child, int index);

}
