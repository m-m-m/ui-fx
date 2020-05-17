/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI media widgets based on JavaFx.
 * 
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 * @uses io.github.mmm.ui.fx.icon.FxIconGlyphFactory
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.icon {

  requires transitive io.github.mmm.ui.fx.core;

  uses io.github.mmm.ui.fx.icon.FxIconGlyphFactory;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.icon.FxFactoryIcon;

  exports io.github.mmm.ui.fx.icon;

}
