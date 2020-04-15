/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.img;

import io.github.mmm.ui.api.widget.img.UiAbstractImage;
import io.github.mmm.ui.fx.widget.FxAtomicWidget;
import javafx.scene.Node;

/**
 * Implementation of {@link UiAbstractImage} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractImage<W extends Node> extends FxAtomicWidget<W> implements UiAbstractImage {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractImage(W widget) {

    super(widget);
  }

  @Override
  public String getAltText() {

    return this.widget.getAccessibleHelp();
  }

  @Override
  public void setAltText(String altText) {

    this.widget.setAccessibleHelp(altText);
  }

}
