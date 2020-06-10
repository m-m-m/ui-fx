/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.datatype.UiStyles;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiSlot;
import io.github.mmm.ui.api.widget.panel.UiBorderPanel;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * Implementation of {@link UiBorderPanel} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxBorderPanel extends FxWidgetNode<BorderPane> implements UiBorderPanel {

  private UiSlot center;

  private UiSlot top;

  private UiSlot left;

  private UiSlot bottom;

  private UiSlot right;

  private int childCount;

  /**
   * The constructor.
   */
  public FxBorderPanel() {

    super(new BorderPane());
  }

  @Override
  public int getChildCount() {

    return this.childCount;
  }

  @Override
  public int getChildIndex(UiSlot child) {

    if (this.center == child) {
      return INDEX_CENTER;
    } else if (this.top == child) {
      return INDEX_TOP;
    } else if (this.left == child) {
      return INDEX_LEFT;
    } else if (this.bottom == child) {
      return INDEX_BOTTOM;
    } else if (this.right == child) {
      return INDEX_RIGHT;
    }
    return -1;
  }

  private void ensureChildCount(int minIndex) {

    int count = minIndex + 1;
    if (this.childCount < count) {
      this.childCount = count;
    }
  }

  @Override
  public UiSlot getTop() {

    if (this.top == null) {
      this.top = new Slot(INDEX_TOP);
      ensureChildCount(INDEX_TOP);
    }
    return this.top;
  }

  @Override
  public UiSlot getBottom() {

    if (this.bottom == null) {
      this.bottom = new Slot(INDEX_BOTTOM);
      ensureChildCount(INDEX_BOTTOM);
    }
    return this.bottom;
  }

  @Override
  public UiSlot getLeft() {

    if (this.left == null) {
      this.left = new Slot(INDEX_LEFT);
      ensureChildCount(INDEX_LEFT);
    }
    return this.left;
  }

  @Override
  public UiSlot getRight() {

    if (this.right == null) {
      this.right = new Slot(INDEX_RIGHT);
      ensureChildCount(INDEX_RIGHT);
    }
    return this.right;
  }

  @Override
  public UiSlot getCenter() {

    if (this.center == null) {
      this.center = new Slot(INDEX_CENTER);
      ensureChildCount(INDEX_CENTER);
    }
    return this.center;
  }

  private class Slot extends FxWidgetNode<Node> implements UiSlot {

    private final int index;

    private UiRegularWidget child;

    /**
     * The constructor.
     *
     * @param index the {@link #getChild(int) child index}.
     */
    public Slot(int index) {

      super(null);
      this.index = index;
    }

    @Override
    protected UiStyles createStyles() {

      return createDefaultStyles();
    }

    @Override
    protected void onStylesChanged(String newStyles) {

      super.onStylesChanged(newStyles);
      if (this.widget != null) {
        String[] styles = null;
        if (newStyles != null) {
          styles = newStyles.split(" ");
        }
        this.widget.getStyleClass().setAll(styles);
      }
    }

    @Override
    public void setChild(UiRegularWidget child) {

      Node node = getTopNode(child);
      setWidget(node);
      this.child = child;
      switch (this.index) {
        case INDEX_CENTER:
          FxBorderPanel.this.widget.setCenter(node);
          break;
        case INDEX_TOP:
          FxBorderPanel.this.widget.setTop(node);
          break;
        case INDEX_LEFT:
          FxBorderPanel.this.widget.setLeft(node);
          break;
        case INDEX_BOTTOM:
          FxBorderPanel.this.widget.setBottom(node);
          break;
        case INDEX_RIGHT:
          FxBorderPanel.this.widget.setRight(node);
          break;
        default:
          throw new IllegalStateException();
      }
    }

    @Override
    public UiRegularWidget getChild() {

      return this.child;
    }

  }

}
