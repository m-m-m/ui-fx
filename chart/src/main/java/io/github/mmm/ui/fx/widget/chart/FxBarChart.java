/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.chart.UiDataSeries;
import io.github.mmm.ui.datatype.chart.UiDataSet;
import io.github.mmm.ui.widget.chart.UiBarChart;
import io.github.mmm.ui.widget.chart.UiBarChartHorizontal;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 * Implementation of {@link UiBarChart} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxBarChart<W extends BarChart<?, ?>> extends FxChart<W, UiDataSeries> implements UiBarChart {

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
    for (Series<?, ?> series : this.widget.getData()) {
      int i = 0;
      for (Data data : series.getData()) {
        if (this.horizontal) {
          data.setXValue(getSeriesLabel(i++));
        } else {
          data.setYValue(getSeriesLabel(i++));
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

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public void setData(UiDataSet<UiDataSeries>... dataSets) {

    Series[] elements = new Series[dataSets.length];
    int i = 0;
    for (UiDataSet<UiDataSeries> set : dataSets) {
      elements[i++] = convert(set);
    }
    this.widget.getData().setAll(elements);
  }

  @SuppressWarnings("rawtypes")
  private Series convert(UiDataSet<UiDataSeries> set) {

    Series series = new Series<>();
    series.setName(set.getTitle());
    ObservableList<Data> list = series.getData();
    UiDataSeries data = set.getData();
    int count = data.getCount();
    for (int i = 0; i < count; i++) {
      list.add(convert(data, i));
    }
    return series;
  }

  private Data<?, ?> convert(UiDataSeries data, int i) {

    if (this.horizontal) {
      return new Data<>(getSeriesLabel(i), data.getNumber(i));

    } else {
      return new Data<>(data.getNumber(i), getSeriesLabel(i));
    }
  }

}
