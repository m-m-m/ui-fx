/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.api.UiDispatcher;
import io.github.mmm.ui.api.UiNotifier;
import io.github.mmm.ui.api.UiScreen;
import io.github.mmm.ui.api.UiToggleGroup;
import io.github.mmm.ui.spi.AbstractUiContext;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Implementation of {@link io.github.mmm.ui.api.UiContext} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxContext extends AbstractUiContext {

  private final Stage primaryStage;

  private final FxScreen screen;

  private final FxDispatcher dispatcher;

  /**
   * The constructor.
   *
   * @param primaryStage the primary {@link Stage}.
   */
  public FxContext(Stage primaryStage) {

    super();
    this.primaryStage = primaryStage;
    this.screen = new FxScreen(Screen.getPrimary());
    this.dispatcher = new FxDispatcher();
  }

  /**
   * @return the primary {@link Stage}.
   */
  public Stage getPrimaryStage() {

    return this.primaryStage;
  }

  @Override
  public UiScreen getScreen() {

    return this.screen;
  }

  @Override
  public UiDispatcher getDispatcher() {

    return this.dispatcher;
  }

  @Override
  public UiToggleGroup createToggleGroup() {

    return new FxToggleGroup();
  }

  @Override
  protected UiNotifier createDefaultNotifier() {

    return new FxNotifier(this);
  }

}
