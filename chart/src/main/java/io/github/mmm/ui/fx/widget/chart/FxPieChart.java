/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.chart.UiDataSet;
import io.github.mmm.ui.widget.chart.UiPieChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Implementation of {@link UiPieChart} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxPieChart extends FxChart<PieChart, Number> implements UiPieChart {
  private final Label caption = new Label("");

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxPieChart(UiContext context) {

    super(context, new PieChart());
    this.caption.setTextFill(Color.DARKORANGE);
    this.caption.setStyle("-fx-font: 24 arial;");
  }

  @SuppressWarnings("unchecked")
  @Override
  public void setData(UiDataSet<Number>... dataSets) {

    Data[] elements = new Data[dataSets.length];
    int i = 0;
    for (UiDataSet<Number> set : dataSets) {
      elements[i++] = convert(set);
    }
    this.widget.getData().addAll(elements);

    // for (Data data : elements) {
    // data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    //
    // @Override
    // public void handle(MouseEvent e) {
    //
    // FxPieChart.this.caption.setTranslateX(e.getSceneX());
    // FxPieChart.this.caption.setTranslateY(e.getSceneY());
    // FxPieChart.this.caption.setText(String.valueOf(data.getPieValue()) + "%");
    // }
    // });
    // }
  }

  private Data convert(UiDataSet<Number> set) {

    double doubleValue = 0;
    Number value = set.getData();
    if (value != null) {
      doubleValue = value.doubleValue();
    }
    Data data = new Data(set.getTitle(), doubleValue);
    return data;
  }

}
