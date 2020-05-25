/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media;

import io.github.mmm.ui.api.widget.media.UiMediaPlayer;
import io.github.mmm.ui.api.widget.media.UiMediaWidget;
import io.github.mmm.ui.fx.widget.media.fx.MediaPlayerAdapter;
import io.github.mmm.ui.fx.widget.media.fx.MediaPlayerControlBar;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;

/**
 * Implementation of {@link UiMediaWidget} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxMediaPlayer extends FxMediaWidget<MediaView> implements UiMediaPlayer {

  private final VBox topWidget;

  /**
   * The constructor.
   */
  public FxMediaPlayer() {

    super(new MediaView());
    this.topWidget = new VBox() {
      @Override
      protected void layoutChildren() {

        super.layoutChildren();
        Bounds mediaBounds = FxMediaPlayer.this.widget.getBoundsInLocal();
        double mediaWidth = mediaBounds.getWidth();
        double mediaHeight = mediaBounds.getHeight();
        System.out.println("video: " + mediaWidth + "x" + mediaHeight);
        Parent parent = getParent();
        if (parent != null) {
          Bounds parentBounds = parent.getLayoutBounds();
          double parentWidth = parentBounds.getWidth();
          double parentHeight = parentBounds.getHeight();
          System.out.println("parent: " + parentWidth + "x" + parentHeight);
          double fitWidth = parentWidth;
          if (mediaHeight > 1) {
            double fitMaxWidth = (parentHeight / mediaHeight) * mediaWidth;
            if (fitWidth > fitMaxWidth) {
              fitWidth = fitMaxWidth;
            }
          }
          FxMediaPlayer.this.widget.setFitWidth(fitWidth * 0.98);
        }
        // FxMediaPlayer.this.widget.setFitHeight(getHeight() * 0.9);
      }
    };
    this.widget.setPreserveRatio(true);
    HBox.setHgrow(this.topWidget, Priority.ALWAYS);
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
