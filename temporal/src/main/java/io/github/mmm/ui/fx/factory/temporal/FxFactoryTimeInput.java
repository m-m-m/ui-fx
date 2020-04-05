/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.temporal;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.temporal.FxTimeInput;
import io.github.mmm.ui.widget.temporal.UiTimeInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTimeInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryTimeInput implements UiSingleWidgetFactoryNative<UiTimeInput> {

  @Override
  public Class<UiTimeInput> getType() {

    return UiTimeInput.class;
  }

  @Override
  public UiTimeInput create(UiContext context) {

    return new FxTimeInput(context);
  }

}
