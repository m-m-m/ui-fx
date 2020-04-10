/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.input.UiRadioButton;
import io.github.mmm.ui.fx.widget.input.FxRadioButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiRadioButton}.
 *
 * @since 1.0.0
 */
public class FxFactoryRadioButton implements UiSingleWidgetFactoryNative<UiRadioButton> {

  @Override
  public Class<UiRadioButton> getType() {

    return UiRadioButton.class;
  }

  @Override
  public UiRadioButton create() {

    return new FxRadioButton();
  }

}
