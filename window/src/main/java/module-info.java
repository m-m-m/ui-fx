
/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;

/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.window {

  requires transitive io.github.mmm.ui.fx.core;

  provides UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.window.FxFactoryMainWindow, //
      io.github.mmm.ui.fx.factory.window.FxFactoryPopup, //
      io.github.mmm.ui.fx.factory.window.FxFactoryWindow;

}
