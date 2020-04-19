/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.controller;

import io.github.mmm.ui.api.controller.AbstractUiControllerManager;
import io.github.mmm.ui.api.controller.UiPlace;

/**
 * Implementation of {@link io.github.mmm.ui.api.controller.UiControllerManager} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxControllerManager extends AbstractUiControllerManager {

  private HistoryNode current;

  private int index;

  private int size;

  /**
   * The constructor.
   */
  public FxControllerManager() {

    super();
  }

  @Override
  public void navigateTo(UiPlace place) {

    super.navigateTo(place);
    addToHistory(place);
  }

  /**
   * Like {@link #doNavigateTo(UiPlace)} but without adding to history.
   *
   * @param place the {@link UiPlace} to navigate to.
   */
  protected void doNavigateTo(UiPlace place) {

    super.navigateTo(place);
  }

  private void addToHistory(UiPlace place) {

    HistoryNode next = new HistoryNode(place);
    if (this.current != null) {
      clearTail(this.current.next);
      this.size = this.index;
      this.current.next = next;
      next.previous = this.current;
    }
    this.current = next;
    this.index++;
    this.size++;
  }

  private void clearTail(HistoryNode node) {

    // clean controllers?
  }

  @Override
  public UiPlace navigateBack() {

    if (this.current == null) {
      return null;
    }
    HistoryNode previous = this.current.previous;
    if (previous == null) {
      return null;
    }
    this.current = previous;
    this.index--;

    UiPlace place = this.current.place;
    doNavigateTo(place);
    return place;
  }

  @Override
  public UiPlace navigateForward() {

    if (this.current == null) {
      return null;
    }
    HistoryNode next = this.current.next;
    if (next == null) {
      return null;
    }
    this.current = next;
    this.index++;
    UiPlace place = this.current.place;
    doNavigateTo(place);
    return place;
  }

  /**
   * @return the total number of places in the history.
   */
  public int getSize() {

    return this.size;
  }

  /**
   * @return the index of the current place inside the history.
   */
  public int getIndex() {

    return this.index;
  }

}
