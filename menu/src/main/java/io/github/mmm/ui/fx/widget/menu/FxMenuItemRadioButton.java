/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.api.UiToggleGroup;
import io.github.mmm.ui.api.widget.composite.UiComposite;
import io.github.mmm.ui.api.widget.menu.UiMenuItemRadioButton;
import io.github.mmm.ui.fx.FxToggleGroup;
import javafx.scene.control.RadioMenuItem;

/**
 * Implementation of {@link UiMenuItemRadioButton} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxMenuItemRadioButton extends FxAbstractMenuItem<RadioMenuItem> implements UiMenuItemRadioButton {

  private FxToggleGroup toggleGroup;

  /**
   * The constructor.
   */
  public FxMenuItemRadioButton() {

    super(new RadioMenuItem());
  }

  @Override
  public Boolean getValue() {

    return Boolean.valueOf(this.widget.isSelected());
  }

  @Override
  public void setValue(Boolean checked) {

    this.widget.setSelected(Boolean.TRUE.equals(checked));
  }

  @Override
  protected void setParent(UiComposite<?> parent) {

    super.setParent(parent);
    if (parent instanceof FxMenu) {
      this.toggleGroup = ((FxMenu) parent).getToggleGroup();
      this.widget.setToggleGroup(this.toggleGroup.getGroup());
    }
  }

  @Override
  public FxToggleGroup getToggleGroup() {

    return this.toggleGroup;
  }

  @Override
  public void setToggleGroup(UiToggleGroup group) {

    this.toggleGroup = (FxToggleGroup) group;
  }

}
