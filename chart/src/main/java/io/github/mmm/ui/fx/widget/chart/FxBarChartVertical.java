/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.widget.chart.UiBarChartVertical;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

/**
 * Implementation of {@link UiBarChartVertical} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxBarChartVertical extends FxBarChart<BarChart<Number, String>> implements UiBarChartVertical {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxBarChartVertical(UiContext context) {

    super(context, new BarChart<>(new NumberAxis(), new CategoryAxis()));
  }

}
