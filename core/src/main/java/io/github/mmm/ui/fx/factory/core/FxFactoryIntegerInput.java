/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiIntegerInput;
import io.github.mmm.ui.fx.widget.input.FxIntegerInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiIntegerInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryIntegerInput implements UiSingleWidgetFactoryNative<UiIntegerInput> {

  @Override
  public Class<UiIntegerInput> getType() {

    return UiIntegerInput.class;
  }

  @Override
  public UiIntegerInput create() {

    return new FxIntegerInput();
  }

}
