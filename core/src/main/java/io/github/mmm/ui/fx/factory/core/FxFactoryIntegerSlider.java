/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.input.FxIntegerSlider;
import io.github.mmm.ui.widget.input.UiIntegerSlider;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiIntegerSlider}.
 *
 * @since 1.0.0
 */
public class FxFactoryIntegerSlider implements UiSingleWidgetFactoryNative<UiIntegerSlider> {

  @Override
  public Class<UiIntegerSlider> getType() {

    return UiIntegerSlider.class;
  }

  @Override
  public UiIntegerSlider create(UiContext context) {

    return new FxIntegerSlider(context);
  }

}
