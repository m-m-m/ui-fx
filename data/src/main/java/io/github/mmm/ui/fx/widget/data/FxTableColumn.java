/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.data;

import java.util.Comparator;

import io.github.mmm.base.sort.SortOrder;
import io.github.mmm.bean.ReadableBean;
import io.github.mmm.bean.WritableBean;
import io.github.mmm.ui.api.widget.data.UiAbstractDataWidget.ColumnAdapter;
import io.github.mmm.ui.api.widget.data.UiColumn;
import io.github.mmm.ui.fx.widget.FxWidget;
import io.github.mmm.value.PropertyPath;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.skin.TableColumnHeader;

/**
 * Implementation of {@link UiColumn} for JavaFx.
 *
 * @param <R> type of the row data. Typically a {@link io.github.mmm.bean.Bean}.
 * @param <V> type of the value for the cells in this column.
 * @since 1.0.0
 */
public class FxTableColumn<R, V> extends FxWidget<TableColumn<R, V>> implements UiColumn<R, V> {

  private ColumnAdapter<R, V> adapter;

  private PropertyPath<V> property;

  private EventHandler<CellEditEvent<R, V>> editCommitter;

  private Label headerLabel;

  private boolean filtering;

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

    return this.filtering;
  }

  @Override
  public void setFiltering(boolean filtering) {

    if (this.filtering == filtering) {
      return;
    }
    // TODO: implement filter and show/hide here...
    this.filtering = filtering;
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

  @Override
  protected void setTooltipNative(String newTooltip) {

    if (this.headerLabel == null) {
      // TableView<R> tableView = this.widget.getTableView();
      TableColumnHeader header = null;
    }
    if (this.headerLabel != null) {
      setTooltip(this.headerLabel, newTooltip);
    }
  }

  /**
   * @param property the {@link PropertyPath property} to bind to this column.
   */
  @SuppressWarnings("unchecked")
  public void setProperty(PropertyPath<V> property) {

    this.property = property;
    final String name = property.getName();
    this.widget.setCellValueFactory(dataFeatures -> {
      R data = dataFeatures.getValue();
      V value = null;
      if (data != null) {
        value = (V) ((ReadableBean) data).get(name);
      }
      if (value == null) {
        return null;
      }
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

  /**
   * @param adapter the {@link io.github.mmm.ui.api.widget.data.UiAbstractDataWidget.ColumnAdapter}.
   */
  public void setAdapter(ColumnAdapter<R, V> adapter) {

    this.adapter = adapter;
    this.widget.setCellValueFactory(dataFeatures -> {
      R data = dataFeatures.getValue();
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

    if (this.adapter != null) {
      this.editCommitter = event -> {
        V value = event.getNewValue();
        this.adapter.set(event.getRowValue(), value);
        // event.getTableView().refresh();
      };
    } else if (this.property != null) {
      this.editCommitter = event -> {
        V value = event.getNewValue();
        R row = event.getRowValue();
        ((WritableBean) row).set(this.property.getName(), value);
      };
    }
    this.widget.setOnEditCommit(this.editCommitter);
  }

}
