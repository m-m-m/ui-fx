/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.datatype.UiTextAlignment;
import io.github.mmm.ui.api.widget.UiText;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Implementation of {@link UiText} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxText extends FxWidgetNode<Text> implements UiText {

  private UiTextAlignment alignment;

  /**
   * The constructor.
   */
  public FxText() {

    super(new Text());
    this.alignment = UiTextAlignment.LEFT;
  }

  @Override
  public String getText() {

    return this.widget.getText();
  }

  @Override
  public void setText(String text) {

    this.widget.setText(text);
  }

  @Override
  public UiTextAlignment getAlignment() {

    return this.alignment;
  }

  @Override
  public void setAlignment(UiTextAlignment alignment) {

    if (this.alignment == alignment) {
      return;
    }
    this.widget.setTextAlignment(convert(alignment));
    this.alignment = alignment;
  }

  private static TextAlignment convert(UiTextAlignment alignment) {

    switch (alignment) {
      case LEFT:
        return TextAlignment.LEFT;
      case RIGHT:
        return TextAlignment.RIGHT;
      case CENTER:
        return TextAlignment.CENTER;
      case JUSTIFY:
        return TextAlignment.JUSTIFY;
    }
    throw new IllegalStateException();
  }

}
