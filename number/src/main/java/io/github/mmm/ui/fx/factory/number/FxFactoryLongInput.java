/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.number;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.number.UiLongInput;
import io.github.mmm.ui.fx.widget.number.FxLongSpinner;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLongInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryLongInput implements UiSingleWidgetFactoryNative<UiLongInput> {

  @Override
  public Class<UiLongInput> getType() {

    return UiLongInput.class;
  }

  @Override
  public UiLongInput create() {

    return new FxLongSpinner();
  }

}
