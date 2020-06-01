/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.ui.api.widget.input.UiRadioChoice;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiRadioChoice} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public class FxRadioChoice<V> extends FxAbstractChoice<RadioButton, V, V> implements UiRadioChoice<V> {

  private final ToggleGroup group;

  private final HBox topWidget;

  private final List<RadioButton> radios;

  /**
   * The constructor.
   */
  public FxRadioChoice() {

    super(new RadioButton());
    this.group = new ToggleGroup();
    this.widget.setToggleGroup(this.group);
    this.widget.setText("uninitialized");
    this.topWidget = new HBox();
    this.topWidget.getChildren().add(this.widget);
    this.radios = new ArrayList<>();
    this.radios.add(this.widget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.group.selectedToggleProperty().addListener(this::onValueChange);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    for (RadioButton rb : this.radios) {
      rb.setDisable(!enabled);
    }
  }

  @Override
  public void setOptions(List<V> options) {

    super.setOptions(options);
    int optionCount = this.options.size();
    ensureRadioButtonCount(optionCount);
    ObservableList<Node> children = this.topWidget.getChildren();
    List<RadioButton> rbs = this.radios;
    if (optionCount < this.radios.size()) {
      rbs = this.radios.subList(0, optionCount);
    }
    children.setAll(rbs);
    for (int i = 0; i < optionCount; i++) {
      V option = this.options.get(i);
      RadioButton rb = this.radios.get(i);
      rb.setUserData(option);
      rb.setText(format(option));
    }
  }

  private void ensureRadioButtonCount(int count) {

    for (int i = this.radios.size(); i < count; i++) {
      RadioButton rb = new RadioButton();
      rb.setToggleGroup(this.group);
      rb.focusedProperty().addListener(this::onFocusChange);
      setTooltip(rb, getTooltip());
      this.radios.add(rb);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public V getValueOrThrow() {

    Toggle selection = this.group.getSelectedToggle();
    return (V) selection.getUserData();
  }

  @Override
  protected void setValueNative(V value) {

    int size = this.options.size();
    for (int i = 0; i < size; i++) {
      if (this.options.get(i) == value) {
        this.radios.get(i).setSelected(true);
      }
    }
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

  @Override
  public void setTooltipNative(String tooltipText) {

    int size = this.radios.size();
    for (int i = 0; i < size; i++) {
      setTooltip(this.radios.get(i), tooltipText);
    }
  }

}
