/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.button.FxButton;
import io.github.mmm.ui.widget.button.UiButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiButton}.
 *
 * @since 1.0.0
 */
public class FxFactoryButton implements UiSingleWidgetFactoryNative<UiButton> {

  @Override
  public Class<UiButton> getType() {

    return UiButton.class;
  }

  @Override
  public UiButton create(UiContext context) {

    return new FxButton(context);
  }

}
