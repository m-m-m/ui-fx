/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.datatype.UiSeverity;
import io.github.mmm.ui.spi.AbstractUiNotifier;

/**
 * Implementation of {@link io.github.mmm.ui.api.UiNotifier} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxNotifier extends AbstractUiNotifier {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxNotifier(UiContext context) {

    super(context);
  }

  @Override
  public void showNotification(String message, UiSeverity severity) {

    // TODO
    showPopupOk(message, severity);
  }

}
