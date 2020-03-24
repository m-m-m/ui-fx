import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of UI media widgets based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.icon {

  requires transitive io.github.mmm.ui.fx.core;

  provides UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.icon.FxFactoryIcon;

}
