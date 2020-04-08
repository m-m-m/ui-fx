/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.fx.widget.FxLabel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLabel}.
 *
 * @since 1.0.0
 */
public class FxFactoryLabel implements UiSingleWidgetFactoryNative<UiLabel> {

  @Override
  public Class<UiLabel> getType() {

    return UiLabel.class;
  }

  @Override
  public UiLabel create(UiContext context) {

    return new FxLabel(context);
  }

}
