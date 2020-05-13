/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media;

import io.github.mmm.ui.api.datatype.media.UiMedia;
import io.github.mmm.ui.api.datatype.media.UiMediaSource;
import io.github.mmm.ui.api.datatype.media.UiMediaType;
import io.github.mmm.ui.api.widget.media.UiMediaWidget;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import io.github.mmm.ui.fx.widget.media.fx.MediaPlayerAdapter;
import io.github.mmm.ui.fx.widget.media.fx.MediaPlayerWrapper;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Implementation of {@link UiMediaWidget} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxMediaWidget<W extends Node> extends FxWidgetNode<W> implements UiMediaWidget {

  /** The {@link MediaPlayerAdapter}. */
  protected final MediaPlayerAdapter mediaPlayerAdapter;

  private UiMedia media;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxMediaWidget(W widget) {

    super(widget);
    this.mediaPlayerAdapter = createMediaPlayerAdapter();
  }

  /**
   * @return the {@link MediaPlayerAdapter}.
   */
  protected MediaPlayerAdapter createMediaPlayerAdapter() {

    return new MediaPlayerWrapper();
  }

  @Override
  public UiMedia getMedia() {

    return this.media;
  }

  @Override
  public void setMedia(UiMedia media) {

    if (media == this.media) {
      return;
    }
    MediaPlayer player = null;
    if (media != null) {
      checkMediaType(media.getType());
      UiMediaSource source = media.getSources().iterator().next();
      String url = source.getUrl();
      Media fxMedia = new Media(url);
      player = new MediaPlayer(fxMedia);
    }
    this.mediaPlayerAdapter.setMediaPlayer(player);
    this.media = media;
  }

  /**
   * @param type the {@link UiMediaType} to verify.
   */
  protected void checkMediaType(UiMediaType type) {

  }

  @Override
  public boolean isPlaying() {

    return this.mediaPlayerAdapter.isPlaying();
  }

  @Override
  public void setPlaying(boolean playing) {

    this.mediaPlayerAdapter.setPlaying(playing);
  }

  @Override
  public double getVolume() {

    return this.mediaPlayerAdapter.getVolume();
  }

  @Override
  public void setVolume(double volume) {

    this.mediaPlayerAdapter.setVolume(volume);
  }

  @Override
  public boolean isMuted() {

    return this.mediaPlayerAdapter.isMuted();
  }

  @Override
  public void setMuted(boolean muted) {

    this.mediaPlayerAdapter.setMuted(muted);
  }

  @Override
  public double getPosition() {

    return this.mediaPlayerAdapter.getPosition();
  }

  @Override
  public void setPosition(double position) {

    this.mediaPlayerAdapter.setPosition(position);
  }

  @Override
  public double getDuration() {

    return this.mediaPlayerAdapter.getDuration();
  }

}
