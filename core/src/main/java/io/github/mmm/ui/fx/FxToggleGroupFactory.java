/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.api.UiToggleGroup;
import io.github.mmm.ui.api.factory.UiToggleGroupFactory;

/**
 * Implementation of {@link UiToggleGroupFactory} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxToggleGroupFactory implements UiToggleGroupFactory {

  @Override
  public UiToggleGroup create() {

    return new FxToggleGroup();
  }

}
