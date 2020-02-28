/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.chart;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.chart.FxPieChart;
import io.github.mmm.ui.widget.chart.UiPieChart;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiPieChart}.
 *
 * @since 1.0.0
 */
public class FxFactoryPieChart implements UiSingleWidgetFactoryNative<UiPieChart> {

  @Override
  public Class<UiPieChart> getType() {

    return UiPieChart.class;
  }

  @Override
  public UiPieChart create(UiContext context) {

    return new FxPieChart(context);
  }

}
