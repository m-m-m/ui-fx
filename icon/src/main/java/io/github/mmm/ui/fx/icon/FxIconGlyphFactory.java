/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.icon;

import io.github.mmm.ui.fx.icon.impl.FxIconGlyphFactoryProvider;

/**
 * Factory for {@link FxIconGlyph}.
 *
 * @since 1.0.0
 */
public interface FxIconGlyphFactory {

  /**
   * @param iconId the {@link io.github.mmm.ui.api.widget.img.UiIcon#setIconId(String) ID of the icon}.
   * @return the {@link FxIconGlyph} for the given {@code iconId}.
   */
  FxIconGlyph getGlyph(String iconId);

  /**
   * @return the instance of this factory.
   */
  static FxIconGlyphFactory get() {

    return FxIconGlyphFactoryProvider.INSTANCE.getFacotry();
  }

}
