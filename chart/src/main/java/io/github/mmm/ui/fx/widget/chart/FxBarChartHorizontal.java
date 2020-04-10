/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.api.widget.chart.UiBarChartHorizontal;
import io.github.mmm.ui.fx.widget.chart.fx.AdvancedBarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

/**
 * Implementation of {@link UiBarChartHorizontal} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxBarChartHorizontal extends FxBarChart<AdvancedBarChart<Number, String>, Number, String>
    implements UiBarChartHorizontal {

  /**
   * The constructor.
   */
  public FxBarChartHorizontal() {

    super(new AdvancedBarChart<>(new NumberAxis(), new CategoryAxis()));
  }

}
