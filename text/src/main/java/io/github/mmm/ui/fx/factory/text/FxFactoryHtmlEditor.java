/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.text;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.text.FxHtmlEditor;
import io.github.mmm.ui.widget.input.UiHtmlEditor;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiHtmlEditor}.
 *
 * @since 1.0.0
 */
public class FxFactoryHtmlEditor implements UiSingleWidgetFactoryNative<UiHtmlEditor> {

  @Override
  public Class<UiHtmlEditor> getType() {

    return UiHtmlEditor.class;
  }

  @Override
  public UiHtmlEditor create(UiContext context) {

    return new FxHtmlEditor(context);
  }

}
