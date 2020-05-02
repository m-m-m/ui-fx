/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of controller manager with routing and navigation for JavaFx.
 */
module io.github.mmm.ui.fx.controller {

  requires transitive io.github.mmm.ui.api.controller;

  requires transitive io.github.mmm.ui.fx.core;

  provides io.github.mmm.ui.api.controller.UiNavigationManager with //
      io.github.mmm.ui.fx.controller.FxNavigationManager;

}
