/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI navigation widgets based on JavaFx.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.navigation {

  requires transitive io.github.mmm.ui.api.navigation;

  requires transitive io.github.mmm.ui.fx.window;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.navigation.FxFactoryMenuBar, //
      io.github.mmm.ui.fx.factory.navigation.FxFactoryNavigationBar //
  ;
}
