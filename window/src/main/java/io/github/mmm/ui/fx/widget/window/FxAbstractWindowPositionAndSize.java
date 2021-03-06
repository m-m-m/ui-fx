/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.api.UiScreen;
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
   */
  public FxAbstractWindowPositionAndSize(Stage stage) {

    super();
    this.stage = stage;
    this.screen = UiScreen.get();
  }

  @Override
  public double getX() {

    double xPos = this.stage.getX();
    if ((xPos == 0) && (this.x == -1)) {
      return -1;
    }
    return xPos;
  }

  @Override
  public void setX(double x) {

    super.setX(x);
    this.stage.setX(clipZero(x));
  }

  @Override
  public double getY() {

    double yPos = this.stage.getY();
    if ((yPos == 0) && (this.y == -1)) {
      return -1;
    }
    return yPos;
  }

  @Override
  public void setY(double y) {

    super.setY(y);
    this.stage.setY(clipZero(y));
  }

  @Override
  public double getWidthInPixel() {

    return this.stage.getWidth();
  }

  @Override
  public void setWidthInPixel(double width) {

    super.setWidthInPixel(width);
    this.stage.setWidth(width);
  }

  @Override
  public double getHeightInPixel() {

    return this.stage.getHeight();
  }

  @Override
  public void setHeightInPixel(double height) {

    super.setHeightInPixel(height);
    this.stage.setHeight(height);
  }

  @Override
  protected double getScreenWidth() {

    return this.screen.getWidthInPixel();
  }

  @Override
  protected double getScreenHeight() {

    return this.screen.getHeightInPixel();
  }

  @Override
  public void centerOnScreen(boolean force) {

    // if ((this.width == 0) || (this.height == 0)) {
    // this.stage.sizeToScene();
    // if (this.width == 0) {
    // this.width = this.stage.getWidth();
    // }
    // if (this.height == 0) {
    // this.height = this.stage.getHeight();
    // }
    // }
    super.centerOnScreen(force);
    this.stage.setX(this.x);
    this.stage.setY(this.y);
    this.stage.setWidth(this.width);
    this.stage.setHeight(this.height);
  }

}
