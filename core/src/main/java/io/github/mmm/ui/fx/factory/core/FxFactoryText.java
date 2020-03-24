/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.FxText;
import io.github.mmm.ui.widget.UiText;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiText}.
 *
 * @since 1.0.0
 */
public class FxFactoryText implements UiSingleWidgetFactoryNative<UiText> {

  @Override
  public Class<UiText> getType() {

    return UiText.class;
  }

  @Override
  public UiText create(UiContext context) {

    return new FxText(context);
  }

}
