/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.img.FxImage;
import io.github.mmm.ui.widget.UiLabel;
import io.github.mmm.ui.widget.img.UiImage;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLabel}.
 *
 * @since 1.0.0
 */
public class FxFactoryImage implements UiSingleWidgetFactoryNative<UiImage> {

  @Override
  public Class<UiImage> getType() {

    return UiImage.class;
  }

  @Override
  public UiImage create(UiContext context) {

    return new FxImage(context);
  }

}
