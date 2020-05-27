/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.panel.UiGridPanel;
import io.github.mmm.ui.fx.widget.panel.FxGridPanel;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiGridPanel}.
 *
 * @since 1.0.0
 */
public class FxFactoryGridPanel implements UiSingleWidgetFactoryNative<UiGridPanel> {

  @Override
  public Class<UiGridPanel> getType() {

    return UiGridPanel.class;
  }

  @Override
  public UiGridPanel create() {

    return new FxGridPanel();
  }

}
