/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx;

import io.github.mmm.ui.api.UiApplication;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Base class for you main application to build your client with JavaFx.<br>
 * Example:
 *
 * <pre>
 * public class MyFxApp extends {@link FxApplication} {
 *
 *   public void start() {
 *     MyApp myApp = new MyApp();
 *     myApp.run();
 *   }
 *
 *   public static void main(String[] args) {
 *     Application.launch(MyFxApp.class, args);
 *   }
 * }
 * </pre>
 *
 * @since 1.0.0
 */
public abstract class FxApplication extends Application implements UiApplication {

  /**
   * Location of the stylesheet (CSS file) to style all JavaFx stages. Add this to you app and declare it as open module
   * so it can be properly loaded and resolved.
   */
  public static final String CSS_LOCATION = "css/site.css";

  private static FxApplication app;

  private Stage primaryStage;

  /**
   * The constructor.
   */
  public FxApplication() {

    super();
    app = this;
  }

  @Override
  public final void start(Stage fxPrimaryStage) throws Exception {

    this.primaryStage = fxPrimaryStage;
    start();
  }

  /**
   * @return the primary {@link Stage}.
   */
  public Stage getPrimaryStage() {

    return this.primaryStage;
  }

  /**
   * @return the running {@link FxApplication} instance.
   */
  public static FxApplication get() {

    return app;
  }

}
