import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.factory.media.FxFactoryMediaPlayer;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of UI media widgets based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.media {

  requires transitive io.github.mmm.ui.api.media;

  requires transitive io.github.mmm.ui.fx.core;

  requires javafx.web;

  requires transitive javafx.media;

  provides UiSingleWidgetFactoryNative with //
      FxFactoryMediaPlayer;

  exports io.github.mmm.ui.fx.factory.media;

  exports io.github.mmm.ui.fx.widget.media;

}
