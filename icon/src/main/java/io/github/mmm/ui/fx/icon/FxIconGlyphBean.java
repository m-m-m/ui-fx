/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.icon;

import javafx.scene.text.Font;

/**
 * Implementation of {@link FxIconGlyph} as mutable Java bean.
 *
 * @since 1.0.0
 */
public class FxIconGlyphBean extends AbstractFxIconGlyph {

  private Font font;

  private String unicode;

  private String fill;

  private String stroke;

  /**
   * The constructor.
   */
  public FxIconGlyphBean() {

    super();
  }

  /**
   * The constructor.
   *
   * @param font - see {@link #getFont()}.
   * @param unicode - see {@link #getUnicode()}.
   */
  public FxIconGlyphBean(Font font, String unicode) {

    this(font, unicode, null, null);
  }

  /**
   * The constructor.
   *
   * @param font - see {@link #getFont()}.
   * @param unicode - see {@link #getUnicode()}.
   * @param fill - see {@link #getFill()}.
   */
  public FxIconGlyphBean(Font font, String unicode, String fill) {

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
  public FxIconGlyphBean(Font font, String unicode, String fill, String stroke) {

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
  public FxIconGlyphBean(FxIconGlyph template) {

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

  /**
   * @param font new value of {@link #getFont()}.
   */
  public void setFont(Font font) {

    this.font = font;
  }

  @Override
  public String getUnicode() {

    return this.unicode;
  }

  /**
   * @param unicode new value of {@link #getUnicode()}.
   */
  public void setUnicode(String unicode) {

    this.unicode = unicode;
  }

  @Override
  public String getFill() {

    return this.fill;
  }

  /**
   * @param fill new value of {@link #getFill()}.
   */
  public void setFill(String fill) {

    this.fill = fill;
  }

  @Override
  public String getStroke() {

    return this.stroke;
  }

  /**
   * @param stroke new value of {@link #getStroke()}.
   */
  public void setStroke(String stroke) {

    this.stroke = stroke;
  }

}
