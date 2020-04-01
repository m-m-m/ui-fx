/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.icon;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.icon.FxIconGlyph;
import io.github.mmm.ui.fx.icon.FxIconGlyphFactory;
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

  private FxIconGlyph glyph;

  private double size;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxIcon(UiContext context) {

    super(context, new Text());
    this.size = 1;
  }

  @Override
  public String getIconId() {

    return this.iconId;
  }

  @Override
  public void setIconId(String iconId) {

    this.glyph = FxIconGlyphFactory.get().getGlyph(iconId);
    if (this.glyph == null) {
      // TODO Logging
      System.out.println("WARNING: undefined Icon: " + iconId);
      this.widget.setText("");
    } else {
      this.widget.setFont(this.glyph.getFont());
      this.widget.setText(this.glyph.getUnicode());
    }
    this.iconId = iconId;
    updateStyle();
  }

  private void updateStyle() {

    StringBuilder style = new StringBuilder("-fx-font-size:");
    style.append((int) (this.size * 10));
    String fill = this.glyph.getFill();
    if (fill != null) {
      style.append(";-fx-fill:");
      style.append(fill);
    }
    String stroke = this.glyph.getStroke();
    if (stroke != null) {
      style.append(";-fx-stroke:");
      style.append(stroke);
    }
    style.append(";");

    this.widget.setStyle(style.toString());
  }

  @Override
  public double getSize() {

    return this.size;
  }

  @Override
  public void setSize(double size) {

    if (size <= 0) {
      size = 1;
    }
    this.size = size;
    updateStyle();
  }

}
