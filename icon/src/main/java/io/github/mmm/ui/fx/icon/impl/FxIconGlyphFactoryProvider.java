/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.icon.impl;

import java.util.ServiceLoader;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.ui.fx.icon.FxIconGlyphFactory;

/**
 * Provider of {@link FxIconGlyphFactory}.
 *
 * @since 1.0.0
 */
public final class FxIconGlyphFactoryProvider {

  /** The singleton instance. */
  public static final FxIconGlyphFactoryProvider INSTANCE = new FxIconGlyphFactoryProvider();

  private final FxIconGlyphFactory facotry;

  private FxIconGlyphFactoryProvider() {

    super();
    ServiceLoader<FxIconGlyphFactory> serviceLoader = ServiceLoader.load(FxIconGlyphFactory.class);
    FxIconGlyphFactory f = null;
    for (FxIconGlyphFactory current : serviceLoader) {
      if (f == null) {
        f = current;
      } else {
        throw new DuplicateObjectException(f, FxIconGlyphFactory.class.getSimpleName(), current);
      }
    }
    if (f == null) {
      throw new ObjectNotFoundException(FxIconGlyphFactory.class);
    }
    this.facotry = f;
  }

  /**
   * @return facotry
   */
  public FxIconGlyphFactory getFacotry() {

    return this.facotry;
  }

}
