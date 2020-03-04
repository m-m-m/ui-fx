/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.chart.UiDataSet;
import io.github.mmm.ui.datatype.color.Color;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import io.github.mmm.ui.fx.widget.chart.fx.AdvancedChart;
import io.github.mmm.ui.widget.chart.UiChart;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.Chart;
import javafx.scene.control.Label;

/**
 * Implementation of {@link UiChart} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <D> type of the chart {@link io.github.mmm.ui.datatype.chart.UiDataSet#getData() data}.
 * @param <J> type of JavaFx {@link Chart} data.
 * @since 1.0.0
 */
public abstract class FxChart<W extends Chart & AdvancedChart<J>, D, J> extends FxWidgetNode<W> implements UiChart<D> {

  private Direction legendPlacement;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxChart(UiContext context, W widget) {

    super(context, widget);
    setLegendPlacement(Direction.DOWN);
  }

  @Override
  public String getTitle() {

    return this.widget.getTitle();
  }

  @Override
  public void setTitle(String title) {

    this.widget.setTitle(title);
  }

  @Override
  public Direction getLegnedPlacement() {

    return this.legendPlacement;
  }

  @Override
  public void setLegendPlacement(Direction placement) {

    this.widget.setLegendVisible(placement != null);
    if (placement != null) {
      Side side = null;
      switch (placement) {
        case RIGHT:
          side = Side.RIGHT;
          break;
        case LEFT:
          side = Side.LEFT;
          break;
        case UP:
        case UP_RIGHT:
        case UP_LEFT:
          side = Side.TOP;
          break;
        case DOWN:
        case DOWN_RIGHT:
        case DOWN_LEFT:
          side = Side.BOTTOM;
          break;
      }
      this.widget.setLegendSide(side);
    }
    this.legendPlacement = placement;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void setData(UiDataSet<D>... dataSets) {

    J[] fxData = createDataArray(dataSets.length);
    int i = 0;
    for (UiDataSet<D> set : dataSets) {
      fxData[i++] = convertData(set);
    }
    this.widget.setAllData(fxData);
    ObservableList<Node> legendLabels = this.widget.getLegendAsPane().getChildren();
    for (i = 0; i < fxData.length; i++) {
      Color color = dataSets[i].getColor(i);
      String colStr = color.toString();
      setDataColor(fxData[i], colStr);
      Label label = (Label) legendLabels.get(i);
      label.getGraphic().setStyle("-fx-background-color:" + colStr + ";");
    }
  }

  /**
   * @param data the JavaFx chart data.
   * @param color the color to apply.
   */
  protected abstract void setDataColor(J data, String color);

  /**
   * @param length the array length.
   * @return a new array of the JavaFx chart data.
   */
  protected abstract J[] createDataArray(int length);

  /**
   * @param dataSet the {@link UiDataSet}.
   * @return the given value new converted to the JavaFx chart data.
   */
  protected abstract J convertData(UiDataSet<D> dataSet);

}
