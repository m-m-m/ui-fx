/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.temporal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

/**
 *
 */
public class DateTimePicker extends DatePicker {

  public static final String DefaultFormat = "yyyy-MM-dd HH:mm";

  private DateTimeFormatter formatter;

  private ObjectProperty<LocalDateTime> dateTimeValue = new SimpleObjectProperty<>(LocalDateTime.now());

  private ObjectProperty<String> format = new SimpleObjectProperty<>() {
    @Override
    public void set(String newValue) {

      super.set(newValue);
      DateTimePicker.this.formatter = DateTimeFormatter.ofPattern(newValue);
    }
  };

  public void alignColumnCountWithFormat() {

    getEditor().setPrefColumnCount(getFormat().length());
  }

  public DateTimePicker() {

    getStyleClass().add("datetime-picker");
    setFormat(DefaultFormat);
    setConverter(new InternalConverter());
    alignColumnCountWithFormat();

    // Syncronize changes to the underlying date value back to the dateTimeValue
    valueProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue == null) {
        this.dateTimeValue.set(null);
      } else {
        if (this.dateTimeValue.get() == null) {
          this.dateTimeValue.set(LocalDateTime.of(newValue, LocalTime.now()));
        } else {
          LocalTime time = this.dateTimeValue.get().toLocalTime();
          this.dateTimeValue.set(LocalDateTime.of(newValue, time));
        }
      }
    });

    // Syncronize changes to dateTimeValue back to the underlying date value
    this.dateTimeValue.addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {
        LocalDate dateValue = newValue.toLocalDate();
        boolean forceUpdate = dateValue.equals(valueProperty().get());
        // Make sure the display is updated even when the date itself wasn't changed
        setValue(dateValue);
        if (forceUpdate)
          setConverter(new InternalConverter());
      } else {
        setValue(null);
      }

    });

    // Persist changes onblur
    getEditor().focusedProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue)
        simulateEnterPressed();
    });

  }

  private void simulateEnterPressed() {

    getEditor().commitValue();
  }

  public LocalDateTime getDateTimeValue() {

    return this.dateTimeValue.get();
  }

  public void setDateTimeValue(LocalDateTime dateTimeValue) {

    this.dateTimeValue.set(dateTimeValue);
  }

  public ObjectProperty<LocalDateTime> dateTimeValueProperty() {

    return this.dateTimeValue;
  }

  public String getFormat() {

    return this.format.get();
  }

  public ObjectProperty<String> formatProperty() {

    return this.format;
  }

  public void setFormat(String format) {

    this.format.set(format);
    alignColumnCountWithFormat();
  }

  class InternalConverter extends StringConverter<LocalDate> {
    @Override
    public String toString(LocalDate object) {

      LocalDateTime value = getDateTimeValue();
      return (value != null) ? value.format(DateTimePicker.this.formatter) : "";
    }

    @Override
    public LocalDate fromString(String value) {

      if (value == null || value.isEmpty()) {
        DateTimePicker.this.dateTimeValue.set(null);
        return null;
      }

      DateTimePicker.this.dateTimeValue.set(LocalDateTime.parse(value, DateTimePicker.this.formatter));
      return DateTimePicker.this.dateTimeValue.get().toLocalDate();
    }
  }
}