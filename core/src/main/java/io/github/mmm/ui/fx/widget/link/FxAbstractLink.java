/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.link;

import io.github.mmm.ui.api.widget.link.UiAbstractLink;
import io.github.mmm.ui.fx.widget.button.FxAbstractButton;
import javafx.scene.control.Hyperlink;

/**
 * Implementation of {@link UiAbstractLink} for JavaFx.
 *
 * @since 1.0.0
 */
public abstract class FxAbstractLink extends FxAbstractButton<Hyperlink> implements UiAbstractLink {

  /**
   * The constructor.
   */
  public FxAbstractLink() {

    super(new Hyperlink());
  }

}
