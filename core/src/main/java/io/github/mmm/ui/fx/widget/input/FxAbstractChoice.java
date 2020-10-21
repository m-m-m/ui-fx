/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.widget.input.UiAbstractChoice;
import io.github.mmm.ui.api.widget.input.UiRadioChoice;
import io.github.mmm.ui.spi.DefaultFormatter;
import javafx.scene.control.Control;

/**
 * Implementation of {@link UiRadioChoice} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @param <O> type of the {@link #getOptions() option}.
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract class FxAbstractChoice<W extends Control, O, V> extends FxInput<W, V>
    implements UiAbstractChoice<O, V> {

  /** @see #getOptions() */
  protected List<O> options;

  private Function<O, String> formatter;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractChoice(W widget) {

    super(widget);
    this.options = Collections.emptyList();
    setFormatter(null);
  }

  @Override
  public List<O> getOptions() {

    return this.options;
  }

  @Override
  public void setOptions(List<O> options) {

    if (options == null) {
      options = Collections.emptyList();
    }
    this.options = options;
  }

  @Override
  public Function<O, String> getFormatter() {

    return this.formatter;
  }

  @Override
  public void setFormatter(Function<O, String> formatter) {

    if (formatter == null) {
      this.formatter = DefaultFormatter.get();
    } else {
      this.formatter = formatter;
    }
  }

  /**
   * @param option the option to format.
   * @return the formatted and localized {@link String}.
   */
  protected String format(O option) {

    String string = this.formatter.apply(option);
    if (string != null) {
      Class<?> context = null;
      if (option == null) {
        int size = this.options.size();
        for (int i = 0; i < size; i++) {
          context = this.options.get(i).getClass();
          if (context != null) {
            break;
          }
        }
      } else {
        context = option.getClass();
      }
      string = UiLocalizer.get().localize(string, context);
    }
    return string;
  }

}
