/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.widget.chart.UiPieChart;
import io.github.mmm.ui.fx.widget.chart.fx.AdvancedPieChart;
import javafx.scene.chart.PieChart.Data;

/**
 * Implementation of {@link UiPieChart} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxPieChart extends FxChart<AdvancedPieChart, Number, Data> implements UiPieChart {

  /**
   * The constructor.
   */
  public FxPieChart() {

    super(new AdvancedPieChart());
  }

  @Override
  protected Data[] createDataArray(int length) {

    return new Data[length];
  }

  @Override
  protected Data convertData(UiDataSet<Number> dataSet) {

    double doubleValue = 0;
    Number value = dataSet.getData();
    if (value != null) {
      doubleValue = value.doubleValue();
    }
    Data data = new Data(dataSet.getTitle(), doubleValue);
    return data;
  }

  @Override
  protected void setDataColor(Data data, String color) {

    data.getNode().setStyle("-fx-pie-color: " + color + ";");
  }

}
