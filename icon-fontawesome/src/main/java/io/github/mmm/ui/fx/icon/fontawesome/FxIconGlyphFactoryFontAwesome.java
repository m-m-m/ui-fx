/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.icon.fontawesome;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.api.widget.img.UiIcon;
import io.github.mmm.ui.fx.icon.FxIconGlyph;
import io.github.mmm.ui.fx.icon.FxIconGlyphFactory;
import io.github.mmm.ui.fx.icon.FxIconGlyphType;
import javafx.scene.text.Font;

/**
 * Implementation of {@link FxIconGlyphFactory} using FontAwesome.
 *
 * @since 1.0.0
 */
public final class FxIconGlyphFactoryFontAwesome implements FxIconGlyphFactory {

  private static final Font FONT;

  private static final Map<String, FxIconGlyph> ICONS = new HashMap<>();

  static {
    try (InputStream in = FxIconGlyphFactoryFontAwesome.class.getResource("fa-solid-900.ttf").openStream()) {
      FONT = Font.loadFont(in, 10.0);
      Objects.requireNonNull(FONT);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load Font.", e);
    }
    register(UiIcon.ID_ERROR, "\uf057", "#FF0000");
    register(UiIcon.ID_WARNING, "\uf071", "#C0C000");
    register(UiIcon.ID_INFORMATION, "\uf05a", "#2070D0");
    register(UiIcon.ID_QUESTION, "\uf059");
    register(UiIcon.ID_PLAY, "\uf04b");
    register(UiIcon.ID_PAUSE, "\uf04c");
    register(UiIcon.ID_MUTE, "\uf6a9");
    register(UiIcon.ID_UNMUTE, "\uf026");
    register(UiIcon.ID_EXPAND, "\f0fe");
    register(UiIcon.ID_COLLAPSE, "\f146");
  }

  /**
   * The constructor.
   */
  public FxIconGlyphFactoryFontAwesome() {

    super();
  }

  private static void register(String iconId, String unicode) {

    register(iconId, unicode, null, null);
  }

  private static void register(String iconId, String unicode, String fill) {

    register(iconId, unicode, fill, null);
  }

  private static void register(String iconId, String unicode, String fill, String stroke) {

    FxIconGlyphType glyph = new FxIconGlyphType(FONT, unicode, fill, stroke);
    FxIconGlyph existing = ICONS.put(iconId, glyph);
    if (existing != null) {
      throw new DuplicateObjectException(glyph, iconId, existing);
    }
  }

  /**
   * @return the fontawesome {@link Font}.
   */
  public static Font getFont() {

    return FONT;
  }

  @Override
  public FxIconGlyph getGlyph(String iconId) {

    return ICONS.get(CaseHelper.toLowerCase(iconId));
  }

}
