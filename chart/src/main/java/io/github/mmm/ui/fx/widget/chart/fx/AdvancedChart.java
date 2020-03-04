/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.chart.fx;

import javafx.scene.layout.Pane;

/**
 * Interface for features lacking in {@link javafx.scene.chart.Chart}.
 *
 * @param <D> type of the data.
 *
 * @since 1.0.0
 */
public interface AdvancedChart<D> {

  /**
   * @param data the new data to set.
   */
  @SuppressWarnings("unchecked")
  void setAllData(D... data);

  /**
   * @return the legend of the chart.
   */
  Pane getLegendAsPane();
}
