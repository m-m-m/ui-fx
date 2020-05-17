
/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI media widgets based on JavaFx.
 * 
 * @provides io.github.mmm.ui.fx.icon.FxIconGlyphFactory
 */
module io.github.mmm.ui.fx.icon.fontawesome {

  requires transitive io.github.mmm.ui.fx.icon;

  provides io.github.mmm.ui.fx.icon.FxIconGlyphFactory
      with io.github.mmm.ui.fx.icon.fontawesome.FxIconGlyphFactoryFontAwesome;

}
