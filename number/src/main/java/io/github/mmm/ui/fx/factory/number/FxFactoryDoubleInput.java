/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.number;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.number.UiDoubleInput;
import io.github.mmm.ui.fx.widget.number.FxDoubleSpinner;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiDoubleInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryDoubleInput implements UiSingleWidgetFactoryNative<UiDoubleInput> {

  @Override
  public Class<UiDoubleInput> getType() {

    return UiDoubleInput.class;
  }

  @Override
  public UiDoubleInput create() {

    return new FxDoubleSpinner();
  }

}
