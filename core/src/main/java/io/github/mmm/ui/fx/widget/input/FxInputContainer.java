/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import javafx.scene.layout.HBox;

/**
 * {@link FxWidgetNode} for {@link FxInput#getContainerWidget()}.
 *
 * @since 1.0.0
 */
public class FxInputContainer extends FxWidgetNode<HBox> implements UiRegularWidget {

  /**
   * The constructor.
   *
   * @param input the {@link FxInput}.
   */
  public FxInputContainer(FxInput<?, ?> input) {

    super(new HBox());
    this.widget.getChildren().add(input.getNameWidget().getWidget());
    this.widget.getChildren().add(input.getWidget());
  }

}
