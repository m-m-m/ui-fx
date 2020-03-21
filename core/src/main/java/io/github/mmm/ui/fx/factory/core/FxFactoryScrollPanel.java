/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.panel.FxScrollPanel;
import io.github.mmm.ui.widget.panel.UiScrollPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiScrollPanel}.
 *
 * @since 1.0.0
 */
public class FxFactoryScrollPanel implements UiSingleWidgetFactoryNative<UiScrollPanel> {

  @Override
  public Class<UiScrollPanel> getType() {

    return UiScrollPanel.class;
  }

  @Override
  public UiScrollPanel create(UiContext context) {

    return new FxScrollPanel(context);
  }

}
