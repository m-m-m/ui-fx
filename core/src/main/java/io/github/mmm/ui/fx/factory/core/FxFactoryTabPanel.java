/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.panel.UiTabPanel;
import io.github.mmm.ui.fx.widget.panel.FxTabPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTabPanel}.
 *
 * @since 1.0.0
 */
public class FxFactoryTabPanel implements UiSingleWidgetFactoryNative<UiTabPanel> {

  @Override
  public Class<UiTabPanel> getType() {

    return UiTabPanel.class;
  }

  @Override
  public UiTabPanel create(UiContext context) {

    return new FxTabPanel(context);
  }

}
