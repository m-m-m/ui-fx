/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.img;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.datatype.UiSize;
import io.github.mmm.ui.api.datatype.UiSizeUnit;
import io.github.mmm.ui.api.widget.img.UiImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Implementation of {@link UiImage} for JavaFx using {@link ImageView}.
 *
 * @since 1.0.0
 */
public class FxImage extends FxAbstractImage<ImageView> implements UiImage {

  private String source;

  private UiSize width;

  private UiSize height;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxImage(UiContext context) {

    super(context, new ImageView());
    this.width = UiSize.AUTO;
    this.height = UiSize.AUTO;
  }

  @Override
  public String getSource() {

    return this.source;
  }

  @Override
  public void setSource(String source) {

    Image image = new Image(source);
    this.widget.setImage(image);
    this.source = source;
  }

  @Override
  public UiSize getWidth() {

    return this.width;
  }

  @Override
  public double getWidthInPixel() {

    return this.widget.getBoundsInLocal().getWidth();
  }

  @Override
  public void setWidth(UiSize width) {

    width = UiSize.getSafe(width);
    UiSizeUnit unit = width.getUnit();
    if (unit == null) {
      this.widget.setFitWidth(0);
    } else {
      switch (unit) {
        case PERCENT:
          this.widget.setScaleX(100d / width.getAmount());
          break;
        case PIXEL:
          this.widget.setFitWidth(width.getAmount());
          break;
        default:
          this.widget.setFitWidth(width.toPixel(1));
      }
    }
    this.width = width;
  }

  @Override
  public UiSize getHeight() {

    return this.height;
  }

  @Override
  public double getHeightInPixel() {

    return this.widget.getBoundsInLocal().getHeight();
  }

  @Override
  public void setHeight(UiSize height) {

    height = UiSize.getSafe(height);
    UiSizeUnit unit = height.getUnit();
    if (unit == null) {
      this.widget.setFitHeight(0);
    } else {
      switch (unit) {
        case PERCENT:
          this.widget.setScaleY(100d / height.getAmount());
          break;
        case PIXEL:
          this.widget.setFitHeight(height.getAmount());
          break;
        default:
          this.widget.setFitHeight(height.toPixel(1));
      }
    }
    this.height = height;
  }

}
