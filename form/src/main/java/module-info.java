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
module io.github.mmm.ui.fx.form {

  requires transitive io.github.mmm.ui.api.form;

  requires transitive io.github.mmm.ui.fx.core;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.form.FxFactoryFormGroup, //
      io.github.mmm.ui.fx.factory.form.FxFactoryFormPanel, //
      io.github.mmm.ui.fx.factory.form.FxFactoryHorizontalnput, //
      io.github.mmm.ui.fx.factory.form.FxFactoryInputContainer //
  ;

  exports io.github.mmm.ui.fx.widget.form;

}
