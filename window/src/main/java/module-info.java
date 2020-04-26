
/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.window {

  requires transitive io.github.mmm.ui.api.window;

  requires transitive io.github.mmm.ui.fx.core;

  requires java.logging;

  provides io.github.mmm.ui.api.notifier.UiNotifier with //
      io.github.mmm.ui.fx.notifier.FxNotifier;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.window.FxFactoryMainWindow, //
      io.github.mmm.ui.fx.factory.window.FxFactoryPopup, //
      io.github.mmm.ui.fx.factory.window.FxFactoryWindow;

  exports io.github.mmm.ui.fx.widget.window;

}
