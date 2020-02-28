import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.factory.text.FxFactoryHtmlEditor;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of UI text widgets based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.text {

  requires transitive io.github.mmm.ui.fx.core;

  requires transitive javafx.web;

  provides UiSingleWidgetFactoryNative with //
      FxFactoryHtmlEditor;

}
