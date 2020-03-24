/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.icon;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.img.FxAbstractImage;
import io.github.mmm.ui.widget.img.UiIcon;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * Implementation of {@link UiIcon} for JavaFx using {@link ImageView}.
 *
 * @since 1.0.0
 */
public class FxIcon extends FxAbstractImage<Text> implements UiIcon {

  private String iconId;

  private double size;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxIcon(UiContext context) {

    super(context, new Text());
    this.size = 1;
    updateSize();
  }

  @Override
  public String getIconId() {

    return this.iconId;
  }

  @Override
  public void setIconId(String iconId) {

    String unicode = FontAwesome.getUnicode(iconId);
    if (unicode == null) {
      // undefined icon... use default?
      unicode = "";
    }
    this.widget.setText(unicode);
    this.iconId = iconId;
  }

  @Override
  public double getSize() {

    return this.size;
  }

  @Override
  public void setSize(double size) {

    this.size = size;
    updateSize();
  }

  private void updateSize() {

    this.widget.setStyle("-fx-font-family: FontAwesome; -fx-font-size: " + (this.size * 10) + ";");
  }

}
