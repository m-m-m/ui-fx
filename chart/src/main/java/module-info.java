import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.factory.chart.FxFactoryPieChart;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of UI media widgets based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.chart {

  requires transitive io.github.mmm.ui.fx.core;

  provides UiSingleWidgetFactoryNative with //
      FxFactoryPieChart;

  exports io.github.mmm.ui.fx.factory.chart;

  exports io.github.mmm.ui.fx.widget.chart;

}
