/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import io.github.mmm.base.exception.ObjectMismatchException;
import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.base.sort.SortOrder;
import io.github.mmm.bean.ReadableBean;
import io.github.mmm.property.ReadableProperty;
import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.widget.data.UiColumn;
import io.github.mmm.ui.api.widget.data.UiDataTable;
import io.github.mmm.ui.fx.widget.FxActiveValidatableWidget;
import io.github.mmm.value.PropertyPath;
import io.github.mmm.value.ReadableTypedValue;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

/**
 * Implementation of {@link UiDataTable} for JavaFx.
 *
 * @param <R> type of the data for the rows displayed by this widget. Typically a {@link io.github.mmm.bean.Bean}.
 * @since 1.0.0
 */
public class FxDataList<R> extends FxActiveValidatableWidget<TableView<R>, List<R>> implements UiDataTable<R> {

  private final List<FxTableColumn<R, ?>> columns;

  private R rowTemplate;

  private TableColumn<R, Integer> rowNumberColumn;

  private boolean showRowNumbers;

  /**
   * The constructor.
   */
  public FxDataList() {

    super(new TableView<>());
    this.columns = new ArrayList<>();
  }

  @Override
  public List<R> getValueOrThrow() {

    return this.widget.getItems();
  }

  @Override
  protected void setValueNative(List<R> value) {

    this.widget.getItems().setAll(value);
  }

  @Override
  public void setRowTemplate(R rowTemplate) {

    this.rowTemplate = rowTemplate;
  }

  @Override
  public <V> UiColumn<R, V> createColumn(PropertyPath<V> property) {

    assert verifyProperty(property);
    String title = UiLocalizer.get().localize(property.getName());
    FxTableColumn<R, V> column = createColumn(title);
    column.setProperty(property);
    return column;
  }

  @SuppressWarnings("unchecked")
  private <V> boolean verifyProperty(PropertyPath<V> property) {

    Objects.requireNonNull(property, "property");
    Objects.requireNonNull(this.rowTemplate, "rowTemplate");
    if (this.rowTemplate instanceof ReadableBean) {
      ReadableBean bean = (ReadableBean) this.rowTemplate;
      String name = property.getName();
      ReadableProperty<?> beanProperty = bean.getProperty(name);
      if (beanProperty == null) {
        throw new ObjectNotFoundException("rowTemplate.Property", name);
      }
      if (property instanceof ReadableTypedValue) {
        Class<V> valueClass = ((ReadableTypedValue<V>) property).getValueClass();
        if (!Objects.equals(valueClass, beanProperty.getValueClass())) {
          throw new ObjectMismatchException(name + ".valueClass=" + beanProperty.getValueClass(), valueClass);
        }
      }
    } else {
      throw new IllegalStateException("Invalid rowTemplate: " + this.rowTemplate.getClass().getName());
    }
    return true;
  }

  @Override
  public <V> UiColumn<R, V> createColumn(String title, ColumnAdapter<R, V> adapter) {

    FxTableColumn<R, V> column = createColumn(title);
    column.setAdapter(adapter);
    return column;
  }

  private <V> FxTableColumn<R, V> createColumn(String title) {

    FxTableColumn<R, V> column = new FxTableColumn<>();
    column.setTitle(title);
    return column;
  }

  @Override
  public int getColumnCount() {

    return this.widget.getColumns().size();
  }

  @Override
  public UiColumn<R, ?> getColumn(int index) {

    return this.columns.get(index);
  }

  @Override
  public void addColumn(UiColumn<R, ?> column) {

    FxTableColumn<R, ?> fxColumn = (FxTableColumn<R, ?>) column;
    this.columns.add(fxColumn);
    this.widget.getColumns().add(fxColumn.getWidget());
  }

  @Override
  public void sort(SortOrder order, UiColumn<R, ?>... columns) {

    SortType sortType = null;
    if (order == SortOrder.ASCENDING) {
      sortType = SortType.ASCENDING;
    } else if (order == SortOrder.DESCENDING) {
      sortType = SortType.DESCENDING;
    }
    for (int i = columns.length - 1; i >= 0; i--) {
      FxTableColumn<R, ?> column = (FxTableColumn<R, ?>) columns[i];
      column.getWidget().setSortType(sortType);
    }
  }

  @Override
  public void setFilterHandler(FilterHandler<R> filterHandler) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isShowRowNumbers() {

    return this.showRowNumbers;
  }

  @Override
  public void setShowRowNumbers(boolean showRowNumbers) {

    if (showRowNumbers == this.showRowNumbers) {
      return;
    }
    if (showRowNumbers) {
      if (this.rowNumberColumn == null) {
        this.rowNumberColumn = createRowNumberColumn();
      }
      this.widget.getColumns().add(0, this.rowNumberColumn);
    } else {
      this.widget.getColumns().remove(this.rowNumberColumn);
    }
    this.showRowNumbers = showRowNumbers;
  }

  @Override
  public R getSelection() {

    return this.widget.getSelectionModel().getSelectedItem();
  }

  @Override
  public void setSelection(R selection) {

    this.widget.getSelectionModel().select(selection);
  }

  @Override
  public List<R> getSelections() {

    return this.widget.getSelectionModel().getSelectedItems();
  }

  @Override
  public void setSelections(Collection<R> selection) {

    this.widget.getSelectionModel().getSelectedItems().setAll(selection);
  }

  @Override
  public boolean isMultiSelection() {

    return (this.widget.getSelectionModel().getSelectionMode() == SelectionMode.MULTIPLE);
  }

  @Override
  public void setMultiSelection(boolean multiSelection) {

    SelectionMode mode;
    if (multiSelection) {
      mode = SelectionMode.MULTIPLE;
    } else {
      mode = SelectionMode.SINGLE;
    }
    this.widget.getSelectionModel().setSelectionMode(mode);
  }

  static <R> TableColumn<R, Integer> createRowNumberColumn() {

    TableColumn<R, Integer> rowNumberColumn = new TableColumn<>("#");
    rowNumberColumn.setSortable(false);
    rowNumberColumn.setCellFactory(col -> {
      return new TableCell<>() {
        @Override
        protected void updateItem(Integer item, boolean empty) {

          super.updateItem(item, empty);
          TableRow<R> row = getTableRow();
          if (row != null) {
            setText(Integer.toString(row.getIndex() + 1));
          } else {
            setText("");
          }
        }
      };
    });
    return rowNumberColumn;
  }

}
