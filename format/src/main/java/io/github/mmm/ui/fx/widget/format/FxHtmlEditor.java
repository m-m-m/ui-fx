/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.format;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.format.UiHtmlEditor;
import io.github.mmm.ui.fx.widget.input.FxInput;
import javafx.scene.web.HTMLEditor;

/**
 * Implementation of {@link UiHtmlEditor} using JavaFx {@link HTMLEditor}.
 *
 * @since 1.0.0
 */
public class FxHtmlEditor extends FxInput<HTMLEditor, String> implements UiHtmlEditor {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxHtmlEditor(UiContext context) {

    super(context, new HTMLEditor());
  }

  @Override
  public String getValueOrThrow() {

    return this.widget.getHtmlText();
  }

  @Override
  public void setValueNative(String value) {

    this.widget.setHtmlText(value);
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    // not supported by JavaFx
    // it seems we need to add a parent node as container and switch child between HTMLEditor and WebView
    super.setReadOnlyNative(readOnly);
  }

}
