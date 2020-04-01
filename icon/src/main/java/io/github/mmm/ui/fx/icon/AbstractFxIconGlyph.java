/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.icon;

import javafx.scene.text.Font;

/**
 * Abstract base Implementation of {@link FxIconGlyph}.
 *
 * @since 1.0.0
 */
public abstract class AbstractFxIconGlyph implements FxIconGlyph {

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    Font font = getFont();
    if (font != null) {
      sb.append("Font:");
      sb.append(font.getName());
      sb.append(";");
    }
    String unicode = getUnicode();
    if (unicode != null) {
      sb.append("Unicode:\\u");
      for (int i = 0; i < unicode.length(); i++) {
        sb.append(String.format("%04x", (int) unicode.charAt(i)));
      }
      sb.append(";");
    }
    String fill = getFill();
    if (fill != null) {
      sb.append("Fill:");
      sb.append(fill);
      sb.append(";");
    }
    String stroke = getStroke();
    if (stroke != null) {
      sb.append("Stroke:");
      sb.append(stroke);
      sb.append(";");
    }
    return sb.toString();
  }

}
