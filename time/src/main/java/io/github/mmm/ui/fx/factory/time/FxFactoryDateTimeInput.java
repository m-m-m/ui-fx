/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.time;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.time.UiDateTimeInput;
import io.github.mmm.ui.fx.widget.time.FxDateTimeInput;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiDateTimeInput}.
 *
 * @since 1.0.0
 */
public class FxFactoryDateTimeInput implements UiSingleWidgetFactoryNative<UiDateTimeInput> {

  @Override
  public Class<UiDateTimeInput> getType() {

    return UiDateTimeInput.class;
  }

  @Override
  public UiDateTimeInput create() {

    return new FxDateTimeInput();
  }

}
