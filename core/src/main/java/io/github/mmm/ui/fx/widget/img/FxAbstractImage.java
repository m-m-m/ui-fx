/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.img;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.FxWidgetWithTooltip;
import io.github.mmm.ui.widget.img.UiAbstractImage;
import javafx.scene.Node;

/**
 * Implementation of {@link UiAbstractImage} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractImage<W extends Node> extends FxWidgetWithTooltip<W> implements UiAbstractImage {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractImage(UiContext context, W widget) {

    super(context, widget);
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
