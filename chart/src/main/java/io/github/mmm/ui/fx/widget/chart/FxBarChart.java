/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.chart.UiDataSeries;
import io.github.mmm.ui.datatype.chart.UiDataSet;
import io.github.mmm.ui.fx.widget.chart.fx.AdvancedChart;
import io.github.mmm.ui.widget.chart.UiBarChart;
import io.github.mmm.ui.widget.chart.UiBarChartHorizontal;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 * Implementation of {@link UiBarChart} for JavaFx.
 *
 * @param <X> type of data for X-axis.
 * @param <Y> type of data for Y-axis.
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxBarChart<W extends BarChart<X, Y> & AdvancedChart<Series<X, Y>>, X, Y>
    extends FxChart<W, UiDataSeries, Series<X, Y>> implements UiBarChart {

  private final boolean horizontal;

  private String[] seriesLabels;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxBarChart(UiContext context, W widget) {

    super(context, widget);
    this.horizontal = (this instanceof UiBarChartHorizontal);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void setSeriesLabels(String... labels) {

    this.seriesLabels = labels;
    for (Series<X, Y> series : this.widget.getData()) {
      int i = 0;
      for (Data data : series.getData()) {
        if (this.horizontal) {
          data.setYValue(getSeriesLabel(i++));
        } else {
          data.setXValue(getSeriesLabel(i++));
        }
      }
    }
  }

  private String getSeriesLabel(int i) {

    String label = null;
    if ((this.seriesLabels != null) && (i < this.seriesLabels.length)) {
      label = this.seriesLabels[i];
    }
    if (label == null) {
      label = Integer.toString(i);
    }
    return label;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected Series<X, Y>[] createDataArray(int length) {

    return new Series[length];
  }

  @Override
  protected Series<X, Y> convertData(UiDataSet<UiDataSeries> dataSet) {

    Series<X, Y> series = new Series<>();
    series.setName(dataSet.getTitle());
    ObservableList<Data<X, Y>> list = series.getData();
    UiDataSeries data = dataSet.getData();
    int count = data.getCount();
    for (int i = 0; i < count; i++) {
      list.add(convert(data, i));
    }
    return series;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  private Data<X, Y> convert(UiDataSeries data, int i) {

    if (this.horizontal) {
      return new Data(data.getNumber(i), getSeriesLabel(i));
    } else {
      return new Data(getSeriesLabel(i), data.getNumber(i));
    }
  }

  @Override
  protected void setDataColor(Series<X, Y> series, String color) {

    for (Data<X, Y> data : series.getData()) {
      data.getNode().setStyle("-fx-bar-fill:" + color + ";");
    }
  }

}
