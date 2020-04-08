/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.datatype.UiPoint;
import io.github.mmm.ui.api.datatype.chart.UiDataSet;
import io.github.mmm.ui.api.widget.chart.UiLineChart;
import io.github.mmm.ui.fx.widget.chart.fx.AdvancedLineChart;
import javafx.collections.ObservableList;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 * Implementation of {@link UiLineChart} for JavaFx using.
 *
 * @since 1.0.0
 */
public class FxLineChart extends FxChart<AdvancedLineChart, UiPoint[], Series<Number, Number>> implements UiLineChart {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxLineChart(UiContext context) {

    super(context, new AdvancedLineChart(new NumberAxis(), new NumberAxis()));
  }

  @Override
  protected void setDataColor(Series<Number, Number> series, String color) {

    for (Data<Number, Number> data : series.getData()) {
      data.getNode().setStyle("-fx-stroke:" + color + ";");
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected Series<Number, Number>[] createDataArray(int length) {

    return new Series[length];
  }

  @Override
  protected Series<Number, Number> convertData(UiDataSet<UiPoint[]> dataSet) {

    Series<Number, Number> series = new Series<>();
    series.setName(dataSet.getTitle());
    ObservableList<Data<Number, Number>> list = series.getData();
    UiPoint[] data = dataSet.getData();
    int count = data.length;
    for (int i = 0; i < count; i++) {
      list.add(convert(data[i], i));
    }
    return series;
  }

  private Data<Number, Number> convert(UiPoint data, int i) {

    return new Data<>(data.getX(), data.getY());
  }

}
