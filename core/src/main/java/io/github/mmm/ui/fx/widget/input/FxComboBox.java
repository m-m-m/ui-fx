/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.api.widget.input.UiComboBox;
import io.github.mmm.ui.api.widget.input.UiTextInput;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * Implementation of {@link UiTextInput} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public class FxComboBox<V> extends FxAbstractChoice<ComboBox<String>, V, V> implements UiComboBox<V> {

  private String autocomplete;

  private final List<String> titles;

  private boolean change;

  /**
   * The constructor.
   */
  public FxComboBox() {

    super(new ComboBox<>());
    this.widget.setEditable(true);
    this.widget.setVisibleRowCount(10);
    this.titles = new ArrayList<>();
    ensureHandlers();
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.getEditor().textProperty().addListener(this::onTextChange);
    this.widget.getSelectionModel().selectedItemProperty().addListener(this::onValueChange);
    this.widget.showingProperty().addListener(this::onShowing);
  }

  private void onShowing(ObservableValue<?> observable, Boolean oldValue, Boolean newValue) {

    if (this.change) {
      super.onValueChange(null, null, null);
      this.change = false;
    }
  }

  @Override
  protected <W> void onValueChange(ObservableValue<? extends W> observable, W oldValue, W newValue) {

    if (this.widget.isShowing()) {
      this.change = true;
      return;
    }
    super.onValueChange(observable, oldValue, newValue);
  }

  @Override
  protected void registerFocusChangeHandler() {

    this.widget.getEditor().focusedProperty().addListener(this::onFocusChange);
  }

  @Override
  protected void onFocusChanged(boolean focusGain) {

    if (focusGain) {
      this.widget.show();
    }
    super.onFocusChanged(focusGain);
  }

  private void onTextChange(ObservableValue<? extends String> observable, String oldValue, String newValue) {

    String filterText = null;
    ObservableList<String> items = this.widget.getItems();
    int i = this.widget.getSelectionModel().getSelectedIndex();
    if ((i >= 0) && (i < items.size())) {
      String selectedItem = items.get(i);
      if (newValue.equals(selectedItem)) {
        filterText = "";
      }
    }
    if (filterText == null) {
      filterText = CaseHelper.toLowerCase(newValue);
    }
    for (String title : this.titles) {
      if (CaseHelper.toLowerCase(title).contains(filterText)) {
        if (!items.contains(title)) {
          items.add(title);
        }
      } else {
        items.remove(title);
      }
    }
    // this.widget.show();
    // this.widget.autosize();
  }

  @Override
  public void setOptions(List<V> options) {

    super.setOptions(options);
    ObservableList<String> items = this.widget.getItems();
    items.clear();
    if (options != null) {
      Function<V, String> formatter = getFormatter();
      for (V option : options) {
        String title = formatter.apply(option);
        items.add(title);
        this.titles.add(title);
      }
    }
  }

  @Override
  public V getValueOrThrow() {

    String value = this.widget.getValue();
    int i = this.titles.indexOf(value);
    if (i >= 0) {
      return this.options.get(i);
    }
    return null;
  }

  @Override
  public String getText() {

    return this.widget.getEditor().getText();
  }

  @Override
  public void setText(String text) {

    this.widget.getEditor().setText(text);
  }

  @Override
  public String getAutocomplete() {

    return this.autocomplete;
  }

  @Override
  public void setAutocomplete(String autocomplete) {

    this.autocomplete = autocomplete;
  }

  @Override
  public String getPlaceholder() {

    return this.widget.getPromptText();
  }

  @Override
  public void setPlaceholder(String placeholder) {

    this.widget.setPromptText(placeholder);
  }

  @Override
  protected void setValueNative(V value) {

    int i = this.options.indexOf(value);
    if (i >= 0) {
      this.widget.getSelectionModel().select(i);
    } else {
      this.widget.getSelectionModel().select(null);
    }
  }

}
