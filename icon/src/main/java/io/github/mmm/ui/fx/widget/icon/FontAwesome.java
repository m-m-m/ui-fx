/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.icon;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import io.github.mmm.ui.datatype.UiSeverity;
import javafx.scene.text.Font;

/**
 * Loads the Glyphicon font.
 *
 * @since 1.0.0
 */
public final class FontAwesome {

  private static final Map<String, String> ICONS = new HashMap<>();

  static {
    ICONS.put(UiSeverity.ERROR.getName(), "\f057");
    ICONS.put(UiSeverity.WARNING.getName(), "\f071");
    ICONS.put(UiSeverity.INFORMATION.getName(), "\f05a");
    ICONS.put(UiSeverity.QUESTION.getName(), "\f059");
    ICONS.put("expand", "\f0fe");
    ICONS.put("collapse", "\f146");
    try (InputStream in = FontAwesome.class.getResource("fa-solid-900.ttf").openStream()) {
      Font.loadFont(in, 10.0);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load Font.", e);
    }
  }

  /**
   * @param iconId the {@link FxIcon#getIconId() icon ID}.
   * @return the FontAwesome unicode character for the icon. May be {@code null} for undefined or unknown
   *         {@code iconId}.
   */
  public static String getUnicode(String iconId) {

    return ICONS.get(iconId);
  }

}
