/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.chart.fx.AdvancedBarChart;
import io.github.mmm.ui.widget.chart.UiBarChartHorizontal;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

/**
 * Implementation of {@link UiBarChartHorizontal} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxBarChartHorizontal extends FxBarChart<AdvancedBarChart<String, Number>, String, Number>
    implements UiBarChartHorizontal {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxBarChartHorizontal(UiContext context) {

    super(context, new AdvancedBarChart<>(new CategoryAxis(), new NumberAxis()));
  }

}
