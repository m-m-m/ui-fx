
/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of data widgets for JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.data {

  requires transitive io.github.mmm.ui.api.data;

  requires transitive io.github.mmm.ui.fx.core;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.data.FxFactoryDataList;

  exports io.github.mmm.ui.fx.widget.data;

}