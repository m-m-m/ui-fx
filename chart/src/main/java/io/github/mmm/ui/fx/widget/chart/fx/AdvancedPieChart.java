/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart.fx;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.Pane;

/**
 * {@link PieChart} implementing {@link AdvancedChart}.
 *
 * @since 1.0.0
 */
public class AdvancedPieChart extends PieChart implements AdvancedChart<Data> {

  @Override
  public void setAllData(Data... data) {

    getData().addAll(data);
  }

  @Override
  public Pane getLegendAsPane() {

    return (Pane) getLegend();
  }

}