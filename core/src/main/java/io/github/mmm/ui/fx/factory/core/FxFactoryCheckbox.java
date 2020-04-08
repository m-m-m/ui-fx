/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.input.UiCheckbox;
import io.github.mmm.ui.fx.widget.input.FxCheckbox;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiButton}.
 *
 * @since 1.0.0
 */
public class FxFactoryCheckbox implements UiSingleWidgetFactoryNative<UiCheckbox> {

  @Override
  public Class<UiCheckbox> getType() {

    return UiCheckbox.class;
  }

  @Override
  public UiCheckbox create(UiContext context) {

    return new FxCheckbox(context);
  }

}
