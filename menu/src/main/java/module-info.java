
/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;

/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.menu {

  requires transitive io.github.mmm.ui.fx.core;

  provides UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.menu.FxFactoryMenu, //
      io.github.mmm.ui.fx.factory.menu.FxFactoryMenuBar, //
      io.github.mmm.ui.fx.factory.menu.FxFactoryMenuItem, //
      io.github.mmm.ui.fx.factory.menu.FxFactoryMenuItemCheckbox, //
      io.github.mmm.ui.fx.factory.menu.FxFactoryMenuItemRadioButton, //
      io.github.mmm.ui.fx.factory.menu.FxFactoryMenuItemSeparator //
  ;
}
