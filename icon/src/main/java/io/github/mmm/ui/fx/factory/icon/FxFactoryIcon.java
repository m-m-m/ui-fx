/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.icon;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.img.UiIcon;
import io.github.mmm.ui.fx.widget.icon.FxIcon;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiLabel}.
 *
 * @since 1.0.0
 */
public class FxFactoryIcon implements UiSingleWidgetFactoryNative<UiIcon> {

  @Override
  public Class<UiIcon> getType() {

    return UiIcon.class;
  }

  @Override
  public UiIcon create() {

    return new FxIcon();
  }

}
