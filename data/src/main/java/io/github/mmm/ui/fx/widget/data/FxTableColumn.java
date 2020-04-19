/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.data;

import java.util.Comparator;

import io.github.mmm.base.sort.SortOrder;
import io.github.mmm.ui.api.widget.data.UiAbstractDataWidget.ColumnAdapter;
import io.github.mmm.ui.api.widget.data.UiColumn;
import io.github.mmm.ui.fx.widget.FxWidgetObject;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableColumn.SortType;

/**
 * Implementation of {@link UiColumn} for JavaFx.
 *
 * @param <R> type of the row data. Typically a {@link io.github.mmm.bean.Bean}.
 * @param <V> type of the value for the cells in this column.
 * @since 1.0.0
 */
public class FxTableColumn<R, V> extends FxWidgetObject<TableColumn<R, V>> implements UiColumn<R, V> {

  private ColumnAdapter<R, V> adapter;

  private EventHandler<CellEditEvent<R, V>> editCommitter;

  /**
   * The constructor.
   */
  public FxTableColumn() {

    super(new TableColumn<>());
  }

  @Override
  public String getId() {

    return this.widget.getId();
  }

  @Override
  public void setId(String id) {

    this.widget.setId(id);
  }

  @Override
  public String getTitle() {

    return this.widget.getText();
  }

  @Override
  public void setTitle(String title) {

    this.widget.setText(title);
  }

  @Override
  public boolean isResizable() {

    return this.widget.isResizable();
  }

  @Override
  public void setResizable(boolean resizable) {

    this.widget.setResizable(resizable);
  }

  @Override
  public boolean isFiltering() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setFiltering(boolean filtering) {

    // TODO Auto-generated method stub

  }

  @Override
  public String getFilterText() {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SortOrder getSortOrder() {

    SortType sortType = this.widget.getSortType();
    if (sortType != null) {
      switch (sortType) {
        case ASCENDING:
          return SortOrder.ASCENDING;
        case DESCENDING:
          return SortOrder.DESCENDING;
      }
    }
    return null;
  }

  @Override
  public Comparator<V> getSortComparator() {

    return this.widget.getComparator();
  }

  @Override
  public void setSortComparator(Comparator<V> sortComparator) {

    this.widget.setComparator(sortComparator);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    this.widget.setVisible(visible);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    // widget.setEditable(enabled);
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    boolean editable = !readOnly;
    if (editable && (this.editCommitter == null)) {
      newEditCommitter();
    }
    this.widget.setEditable(editable);
  }

  /**
   * @param adapter the {@link io.github.mmm.ui.api.widget.data.UiAbstractDataWidget.ColumnAdapter}.
   */
  public void setAdapter(ColumnAdapter<R, V> adapter) {

    this.adapter = adapter;
    this.widget.setCellValueFactory(dataFeatures -> {
      CellDataFeatures<R, V> dataFeatures2 = dataFeatures;
      R data = dataFeatures2.getValue();
      if (data == null) {
        return null;
      }
      V value = adapter.get(data);
      return new ReadOnlyObjectWrapper<>(value);
    });
    if (this.editCommitter != null) {
      if (isSortable()) {
        newEditCommitter();
      } else {
        this.editCommitter = null;
      }
    }
  }

  private void newEditCommitter() {

    this.editCommitter = event -> {
      V value = event.getNewValue();
      this.adapter.set(event.getRowValue(), value);
      // event.getTableView().refresh();
    };
    this.widget.setOnEditCommit(this.editCommitter);
  }

}
