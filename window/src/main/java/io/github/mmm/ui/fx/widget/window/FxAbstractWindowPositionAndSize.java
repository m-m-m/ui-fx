/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.UiScreen;
import io.github.mmm.ui.spi.window.UiWindowPositionAndSize;
import javafx.stage.Stage;

/**
 * Implementation of {@link UiWindowPositionAndSize} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxAbstractWindowPositionAndSize extends UiWindowPositionAndSize {

  private final Stage stage;

  private final UiScreen screen;

  /**
   * The constructor.
   *
   * @param stage the {@link Stage} (window).
   * @param screen the {@link UiScreen}.
   */
  public FxAbstractWindowPositionAndSize(Stage stage, UiScreen screen) {

    super();
    this.stage = stage;
    this.screen = screen;
  }

  @Override
  public double getX() {

    return this.stage.getX();
  }

  @Override
  public void setX(double x) {

    this.stage.setX(x);
  }

  @Override
  public double getY() {

    return this.stage.getY();
  }

  @Override
  public void setY(double y) {

    this.stage.setY(y);
  }

  @Override
  public double getWidthInPixel() {

    return this.stage.getWidth();
  }

  @Override
  public void setWidthInPixel(double width) {

    this.stage.setWidth(width);
  }

  @Override
  public double getHeightInPixel() {

    return this.stage.getHeight();
  }

  @Override
  public void setHeightInPixel(double height) {

    this.stage.setHeight(height);
  }

  @Override
  protected double getMaxScreenWidth() {

    return this.screen.getWidthInPixel();
  }

  @Override
  protected double getMaxScreenHeight() {

    return this.screen.getHeightInPixel();
  }

}
