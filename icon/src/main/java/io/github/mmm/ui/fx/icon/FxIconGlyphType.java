/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.icon;

import javafx.scene.text.Font;

/**
 * Implementation of {@link FxIconGlyph} as immutable type.
 *
 * @since 1.0.0
 */
public class FxIconGlyphType extends AbstractFxIconGlyph {

  private final Font font;

  private final String unicode;

  private final String fill;

  private final String stroke;

  /**
   * The constructor.
   *
   * @param font - see {@link #getFont()}.
   * @param unicode - see {@link #getUnicode()}.
   */
  public FxIconGlyphType(Font font, String unicode) {

    this(font, unicode, null, null);
  }

  /**
   * The constructor.
   *
   * @param font - see {@link #getFont()}.
   * @param unicode - see {@link #getUnicode()}.
   * @param fill - see {@link #getFill()}.
   */
  public FxIconGlyphType(Font font, String unicode, String fill) {

    this(font, unicode, fill, null);
  }

  /**
   * The constructor.
   *
   * @param font - see {@link #getFont()}.
   * @param unicode - see {@link #getUnicode()}.
   * @param fill - see {@link #getFill()}.
   * @param stroke - see {@link #getStroke()}.
   */
  public FxIconGlyphType(Font font, String unicode, String fill, String stroke) {

    super();
    this.font = font;
    this.unicode = unicode;
    this.fill = fill;
    this.stroke = stroke;
  }

  /**
   * The constructor.
   *
   * @param template the {@link FxIconGlyph} to copy.
   */
  public FxIconGlyphType(FxIconGlyph template) {

    super();
    this.font = template.getFont();
    this.unicode = template.getUnicode();
    this.fill = template.getFill();
    this.stroke = template.getStroke();
  }

  @Override
  public Font getFont() {

    return this.font;
  }

  @Override
  public String getUnicode() {

    return this.unicode;
  }

  @Override
  public String getFill() {

    return this.fill;
  }

  @Override
  public String getStroke() {

    return this.stroke;
  }

}
