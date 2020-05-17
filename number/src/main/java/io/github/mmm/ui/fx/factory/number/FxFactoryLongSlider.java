/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.number;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.number.UiLongSlider;
import io.github.mmm.ui.fx.widget.number.FxLongSlider;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLongSlider}.
 *
 * @since 1.0.0
 */
public class FxFactoryLongSlider implements UiSingleWidgetFactoryNative<UiLongSlider> {

  @Override
  public Class<UiLongSlider> getType() {

    return UiLongSlider.class;
  }

  @Override
  public UiLongSlider create() {

    return new FxLongSlider();
  }

}
