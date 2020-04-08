/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import io.github.mmm.ui.fx.widget.input.FxTextInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTextInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryTextInput implements UiSingleWidgetFactoryNative<UiTextInput> {

  @Override
  public Class<UiTextInput> getType() {

    return UiTextInput.class;
  }

  @Override
  public UiTextInput create(UiContext context) {

    return new FxTextInput(context);
  }

}
