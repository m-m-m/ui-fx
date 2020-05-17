/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */

/**
 * Provides the implementation of UI media widgets based on JavaFx.
 * 
 * @provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.chart {

  requires transitive io.github.mmm.ui.api.chart;

  requires transitive io.github.mmm.ui.fx.core;

  provides io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative with //
      io.github.mmm.ui.fx.factory.chart.FxFactoryBarChartVertical, //
      io.github.mmm.ui.fx.factory.chart.FxFactoryBarChartHorizontal, //
      io.github.mmm.ui.fx.factory.chart.FxFactoryLineChart, //
      io.github.mmm.ui.fx.factory.chart.FxFactoryPieChart;

  exports io.github.mmm.ui.fx.factory.chart;

  exports io.github.mmm.ui.fx.widget.chart;

}
