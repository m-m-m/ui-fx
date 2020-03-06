/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.widget.media.fx.MediaPlayerAdapter;
import io.github.mmm.ui.fx.widget.media.fx.MediaPlayerControlBar;
import io.github.mmm.ui.widget.media.UiMediaPlayer;
import io.github.mmm.ui.widget.media.UiMediaWidget;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;

/**
 * Implementation of {@link UiMediaWidget} using JavaFx.
 *
 * @since 1.0.0
 */
public class FxMediaPlayer extends FxMediaWidget<MediaView> implements UiMediaPlayer {

  private final VBox topWidget;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxMediaPlayer(UiContext context) {

    super(context, new MediaView());
    this.topWidget = new VBox();
    this.topWidget.getChildren().add(this.widget);
    this.topWidget.getChildren().add(this.mediaPlayerAdapter.getControls());
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

  @Override
  protected MediaPlayerAdapter createMediaPlayerAdapter() {

    return new MediaPlayerControlBar(this);
  }

}
