/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.panel.UiCollapsiblePanel;
import io.github.mmm.ui.fx.widget.panel.FxCollapsiblePanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiCollapsiblePanel}.
 *
 * @since 1.0.0
 */
public class FxFactoryCollapsiblePanel implements UiSingleWidgetFactoryNative<UiCollapsiblePanel> {

  @Override
  public Class<UiCollapsiblePanel> getType() {

    return UiCollapsiblePanel.class;
  }

  @Override
  public UiCollapsiblePanel create() {

    return new FxCollapsiblePanel();
  }

}
