/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI form widgets for JavaFx.
 * 
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.form.grid {

  requires transitive io.github.mmm.ui.api.form;

  requires transitive io.github.mmm.ui.fx.core;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.form.grid.FxFactoryFormGroup, //
      io.github.mmm.ui.fx.factory.form.grid.FxFactoryFormPanel, //
      io.github.mmm.ui.fx.factory.form.grid.FxFactoryInputContainer //
  ;

  exports io.github.mmm.ui.fx.widget.form.grid;

}
