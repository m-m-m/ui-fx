/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.fx.widget.button.FxButton;

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
  public UiButton create() {

    return new FxButton();
  }

}
