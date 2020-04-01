/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.icon;

import javafx.scene.text.Font;

/**
 * Interface for the glyph of a {@link io.github.mmm.ui.widget.img.UiIcon} for JavaFx. As described in
 * <a href="https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html#introlimitations">Limitations of
 * JavaFX CSS Reference Guide</a> there is no support for {@code :before} pseudoclass nor is there a possibility to load
 * fonts via CSS in JavaFx. Hence the flexibility to define icons as glyphs needs to be done what is exactly the purpose
 * of this interface and {@link FxIconGlyphFactory}.
 */
public interface FxIconGlyph {

  /**
   * @return the {@link Font} to display the icon as glyph from its {@link #getUnicode() unicode}.
   */
  Font getFont();

  /**
   * @return the unicode character of the glyph representing the icon in the specified {@link #getFont() font}.
   */
  String getUnicode();

  /**
   * @return the optional CSS (default) fill color for the icon.
   */
  String getFill();

  /**
   * @return the optional CSS (default) stroke (outline) color for the icon.
   */
  String getStroke();

}
