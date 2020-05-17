/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI temporal widgets based on JavaFx.
 *
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.temporal {

  requires transitive io.github.mmm.ui.api.temporal;

  requires transitive io.github.mmm.ui.fx.core;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.temporal.FxFactoryDateInput, //
      io.github.mmm.ui.fx.factory.temporal.FxFactoryDateTimeInput, //
      io.github.mmm.ui.fx.factory.temporal.FxFactoryTimeInput;

}
