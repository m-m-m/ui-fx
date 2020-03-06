import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.factory.core.FxFactoryButton;
import io.github.mmm.ui.fx.factory.core.FxFactoryButtonPanel;
import io.github.mmm.ui.fx.factory.core.FxFactoryCheckbox;
import io.github.mmm.ui.fx.factory.core.FxFactoryFormGroup;
import io.github.mmm.ui.fx.factory.core.FxFactoryFormPanel;
import io.github.mmm.ui.fx.factory.core.FxFactoryHorizontalPanel;
import io.github.mmm.ui.fx.factory.core.FxFactoryIntegerInput;
import io.github.mmm.ui.fx.factory.core.FxFactoryLabel;
import io.github.mmm.ui.fx.factory.core.FxFactoryMenu;
import io.github.mmm.ui.fx.factory.core.FxFactoryMenuItem;
import io.github.mmm.ui.fx.factory.core.FxFactoryMenuItemCheckbox;
import io.github.mmm.ui.fx.factory.core.FxFactoryMenuItemRadioButton;
import io.github.mmm.ui.fx.factory.core.FxFactoryMenuItemSeparator;
import io.github.mmm.ui.fx.factory.core.FxFactoryPasswordInput;
import io.github.mmm.ui.fx.factory.core.FxFactoryPopup;
import io.github.mmm.ui.fx.factory.core.FxFactoryRadioButton;
import io.github.mmm.ui.fx.factory.core.FxFactoryRadioChoice;
import io.github.mmm.ui.fx.factory.core.FxFactoryTab;
import io.github.mmm.ui.fx.factory.core.FxFactoryTabPanel;
import io.github.mmm.ui.fx.factory.core.FxFactoryTextArea;
import io.github.mmm.ui.fx.factory.core.FxFactoryTextInput;
import io.github.mmm.ui.fx.factory.core.FxFactoryVerticalPanel;
import io.github.mmm.ui.fx.factory.core.FxFactoryWindow;

/*
 * Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
/**
 * Provides the implementation of the UI framework based on JavaFx.
 */
@SuppressWarnings("rawtypes") //
module io.github.mmm.ui.fx.core {

  requires transitive io.github.mmm.ui;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.value;

  // TODO bug in JPMS or Eclipse as this is already a transitive dependency of ui
  requires transitive io.github.mmm.validation.main;

  requires transitive javafx.controls;

  provides UiSingleWidgetFactoryNative with //
      FxFactoryButton, //
      FxFactoryButtonPanel, //
      FxFactoryCheckbox, //
      FxFactoryFormGroup, //
      FxFactoryFormPanel, //
      FxFactoryHorizontalPanel, //
      FxFactoryIntegerInput, //
      FxFactoryLabel, //
      FxFactoryMenu, //
      FxFactoryMenuItem, //
      FxFactoryMenuItemCheckbox, //
      FxFactoryMenuItemRadioButton, //
      FxFactoryMenuItemSeparator, //
      FxFactoryPasswordInput, //
      FxFactoryPopup, //
      FxFactoryRadioButton, //
      FxFactoryRadioChoice, //
      FxFactoryTab, //
      FxFactoryTabPanel, //
      FxFactoryTextInput, //
      FxFactoryTextArea, //
      FxFactoryVerticalPanel, //
      FxFactoryWindow;

  exports io.github.mmm.ui.fx;

  exports io.github.mmm.ui.fx.widget;

  exports io.github.mmm.ui.fx.widget.input;

}
