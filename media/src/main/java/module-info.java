/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI media widgets based on JavaFx.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.media {

  requires transitive io.github.mmm.ui.api.media;

  requires transitive io.github.mmm.ui.fx.core;

  requires javafx.web;

  requires transitive javafx.media;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.media.FxFactoryMediaPlayer;

  exports io.github.mmm.ui.fx.factory.media;

  exports io.github.mmm.ui.fx.widget.media;

}
