/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.form;

import io.github.mmm.ui.api.widget.form.UiHorizontalInput;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiHorizontalInput} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class FxHorizontalInput<V> extends FxCompositeInput<V, HBox> implements UiHorizontalInput<V> {

  /**
   * The constructor.
   */
  public FxHorizontalInput() {

    super(new HBox());
  }

}
