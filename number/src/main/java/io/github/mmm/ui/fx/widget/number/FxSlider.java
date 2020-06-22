/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.base.range.WritableRange;
import io.github.mmm.ui.api.widget.number.UiSlider;
import io.github.mmm.ui.fx.widget.input.FxInput;
import io.github.mmm.ui.spi.range.NumericRange;
import io.github.mmm.validation.Validator;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

/**
 * Implementation of {@link UiSlider} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxSlider<V extends Number> extends FxInput<Slider, V> implements UiSlider<V> {

  private final HBox topWidget;

  private final Range<V> range;

  private final TextField textWidget;

  private final TickLabelFormatter tickLabelFormatter;

  private String text;

  /**
   * The constructor.
   */
  public FxSlider() {

    super(new Slider());
    this.topWidget = new HBox();
    this.textWidget = new TextField();
    this.textWidget.setEditable(false);
    this.topWidget.getChildren().add(this.widget);
    this.topWidget.getChildren().add(this.textWidget);
    this.range = new Range<>(getNumberType());
    this.widget.setMax(1);
    this.widget.setShowTickMarks(true);
    this.widget.setShowTickLabels(true);
    this.widget.setMinorTickCount(10);
    this.widget.setMajorTickUnit(0.1);
    this.tickLabelFormatter = new TickLabelFormatter();
    this.widget.setLabelFormatter(this.tickLabelFormatter);
    this.widget.valueProperty().addListener(this::onValueChange);
    this.textWidget.textProperty().addListener(this::onValueChange);
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

  @Override
  protected <W> void onValueChange(ObservableValue<? extends W> observable, W oldValue, W newValue) {

    if (observable == this.textWidget.textProperty()) {
      try {
        String newText = this.textWidget.getText();
        if (newText.equals(this.text)) {
          return;
        }
        this.text = newText;
        V value = getNumberType().valueOf(this.text);
        this.widget.setValue(this.range.toFactor(value));
      } catch (NumberFormatException e) {
        // TODO
        setValidationFailure("Invalid number");
      }
    } else {
      super.onValueChange(observable, oldValue, newValue);
    }
  }

  @Override
  protected void onValueChanged(boolean programmatic) {

    super.onValueChanged(programmatic);
    if (!programmatic) {
      V value = getValueOrThrow();
      setValueAsText(value);
    }
  }

  private void setValueAsText(V value) {

    String newText = "";
    if (value != null) {
      newText = value.toString();
    }
    this.textWidget.setText(newText);
  }

  /**
   * @return the {@link NumberType} for the underlying {@link Number}.
   */
  protected abstract NumberType<V> getNumberType();

  @Override
  public WritableRange<V> getRange() {

    return this.range;
  }

  @Override
  public V getValueOrThrow() {

    return this.range.fromFactor(this.widget.getValue());
  }

  @Override
  protected void setValueNative(V value) {

    double v = 0;
    if (value != null) {
      v = this.range.clip(value).doubleValue();
    }
    this.widget.setValue(v);
    setValueAsText(value);
  }

  @Override
  public void setValidator(Validator<? super V> validator) {

    super.setValidator(validator);
    this.range.setValidator(validator);
  }

  @Override
  public boolean isTextVisible() {

    return this.textWidget.isVisible();
  }

  @Override
  public void setTextVisible(boolean textVisible) {

    this.textWidget.setVisible(textVisible);
  }

  @Override
  public boolean isTextEditable() {

    return this.textWidget.isEditable();
  }

  @Override
  public void setTextEditable(boolean textEditable) {

    this.textWidget.setEditable(textEditable);
  }

  private class TickLabelFormatter extends StringConverter<Double> {

    @Override
    public String toString(Double value) {

      return FxSlider.this.range.fromFactor(value.doubleValue()).toString();
    }

    @Override
    public Double fromString(String string) {

      throw new UnsupportedOperationException();
    }
  }

  private class Range<N extends Number> extends NumericRange<N> {

    public Range(NumberType<N> type) {

      super(type);
    }

    @Override
    protected void onValueChange() {

      super.onValueChange();
      FxSlider.this.widget.setLabelFormatter(FxSlider.this.tickLabelFormatter);
    }

  }

}
