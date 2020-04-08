/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of UI format widgets based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.format {

  requires transitive io.github.mmm.ui.api.format;

  requires transitive io.github.mmm.ui.fx.core;

  requires transitive javafx.web;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.text.FxFactoryHtmlEditor;

}
