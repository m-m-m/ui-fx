/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.controller;

import io.github.mmm.ui.api.controller.UiPlace;

/**
 * Node in the navigation history containing the {@link #getPlace() place}.
 *
 * @since 1.0.0
 */
public class HistoryNode {

  final UiPlace place;

  HistoryNode previous;

  HistoryNode next;

  /**
   * The constructor.
   *
   * @param value the initial {@link #getPlace() value}.
   */
  public HistoryNode(UiPlace value) {

    super();
    this.place = value;
  }

  /**
   * @return the value (element) stored in this {@link HistoryNode}.
   */
  public UiPlace getPlace() {

    return this.place;
  }

  /**
   * @return previous
   */
  public HistoryNode getPrevious() {

    return this.previous;
  }

  /**
   * @return next
   */
  public HistoryNode getNext() {

    return this.next;
  }

}
