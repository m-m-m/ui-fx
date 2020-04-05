/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart.fx;

import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;

/**
 * {@link LineChart} implementing {@link AdvancedChart}.
 *
 * @since 1.0.0
 */
public class AdvancedLineChart extends LineChart<Number, Number> implements AdvancedChart<Series<Number, Number>> {

  /**
   * The constructor.
   *
   * @param xAxis the horizontal {@link Axis}.
   * @param yAxis the vertical {@link Axis}.
   */
  public AdvancedLineChart(Axis<Number> xAxis, Axis<Number> yAxis) {

    super(xAxis, yAxis);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void setAllData(Series<Number, Number>... data) {

    getData().setAll(data);
  }

  @Override
  public Pane getLegendAsPane() {

    return (Pane) getLegend();
  }

}
