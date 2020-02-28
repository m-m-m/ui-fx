/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart;

import io.github.mmm.base.placement.Direction;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import io.github.mmm.ui.widget.chart.UiChart;
import javafx.geometry.Side;
import javafx.scene.chart.Chart;

/**
 * Implementation of {@link UiChart} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <D> type of the chart {@link io.github.mmm.ui.datatype.chart.UiDataSet#getData() data}.
 * @since 1.0.0
 */
public abstract class FxChart<W extends Chart, D> extends FxWidgetNode<W> implements UiChart<D> {

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

}
