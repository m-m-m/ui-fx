/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart.fx;

import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;

/**
 * {@link BarChart} implementing {@link AdvancedChart}.
 * 
 * @param <X> type of data for X-axis.
 * @param <Y> type of data for Y-axis.
 *
 * @since 1.0.0
 */
public class AdvancedBarChart<X, Y> extends BarChart<X, Y> implements AdvancedChart<Series<X, Y>> {

  /**
   * The constructor.
   *
   * @param xAxis the horizontal {@link Axis}.
   * @param yAxis the vertical {@link Axis}.
   */
  public AdvancedBarChart(Axis<X> xAxis, Axis<Y> yAxis) {

    super(xAxis, yAxis);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void setAllData(Series<X, Y>... data) {

    getData().setAll(data);
  }

  @Override
  public Pane getLegendAsPane() {

    return (Pane) getLegend();
  }

}
