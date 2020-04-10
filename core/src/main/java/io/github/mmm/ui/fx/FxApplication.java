/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.api.UiContext;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Base class for you main application to build your client with JavaFx.<br>
 * Example:
 *
 * <pre>
 * public class MyFxApp extends {@link FxApplication} {
 *
 *   protected abstract void start() {
 *     MyApp myApp = new MyApp();
 *     myApp.run();
 *   }
 *
 *   public static void main(String[] args) {
 *     Application.launch(MyFxApp.class, args);
 *   }
 * }
 * </pre>
 */
public abstract class FxApplication extends Application {

  private static Stage primaryStage;

  /**
   * The constructor.
   */
  public FxApplication() {

    super();
  }

  @Override
  public final void start(Stage fxPrimaryStage) throws Exception {

    primaryStage = fxPrimaryStage;
    FxContext context = (FxContext) UiContext.get();
    context.setPrimaryStage(fxPrimaryStage);
    start();
  }

  /**
   * @return the primary {@link Stage}.
   */
  public static Stage getPrimaryStage() {

    return primaryStage;
  }

  /**
   * Starts this application.
   */
  protected abstract void start();

}
