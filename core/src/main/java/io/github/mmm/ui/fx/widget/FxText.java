/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiTextAlignment;
import io.github.mmm.ui.widget.UiText;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Implementation of {@link UiText} using JavaFx {@link Text}.
 *
 * @since 1.0.0
 */
public class FxText extends FxWidgetWithTooltip<Text> implements UiText {

  private UiTextAlignment alignment;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxText(UiContext context) {

    super(context, new Text());
    this.alignment = UiTextAlignment.LEFT;
  }

  @Override
  public String getText() {

    return this.widget.getText();
  }

  @Override
  public void setText(String label) {

    this.widget.setText(label);
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
