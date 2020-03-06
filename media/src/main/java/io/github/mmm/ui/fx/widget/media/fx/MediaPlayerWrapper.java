/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media.fx;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

/**
 * Implementation of {@link MediaPlayerAdapter} as simple wrapper.
 *
 * @since 1.0.0
 */
public class MediaPlayerWrapper implements MediaPlayerAdapter {

  private static final double MILLIS_PER_SEC = 1000000d;

  /** The initial {@link #getVolume() volume}. */
  protected static final double DEFAULT_VOLUME = 0.8;

  /** @see #setMediaPlayer(MediaPlayer) */
  protected MediaPlayer mediaPlayer;

  /** @see #getVolume() */
  protected double volume;

  /** @see #isMuted() */
  protected boolean muted;

  /**
   * The constructor.
   */
  public MediaPlayerWrapper() {

    super();
    this.volume = DEFAULT_VOLUME;
  }

  @Override
  public void setMediaPlayer(MediaPlayer player) {

    if (this.mediaPlayer != null) {
      this.mediaPlayer.stop();
    }
    this.mediaPlayer = player;
    if (this.mediaPlayer != null) {
      player.setVolume(this.volume);
    }
  }

  @Override
  public boolean isPlaying() {

    if (this.mediaPlayer == null) {
      return false;
    }
    return this.mediaPlayer.getStatus() == Status.PLAYING;
  }

  @Override
  public void setPlaying(boolean playing) {

    if (this.mediaPlayer == null) {
      return;
    }
    if (playing) {
      this.mediaPlayer.play();
    } else {
      this.mediaPlayer.pause();
    }
  }

  @Override
  public double getVolume() {

    return this.volume;
  }

  @Override
  public void setVolume(double volume) {

    if (volume == this.volume) {
      return;
    }
    if (volume < 0) {
      this.volume = 0;
    } else if (volume > 1) {
      this.volume = 1;
    } else {
      this.volume = volume;
    }
    if (this.mediaPlayer != null) {
      this.mediaPlayer.setVolume(this.volume);
    }
  }

  @Override
  public boolean isMuted() {

    return this.muted;
  }

  @Override
  public void setMuted(boolean muted) {

    if (this.mediaPlayer != null) {
      this.mediaPlayer.setMute(muted);
    }
    this.muted = muted;
  }

  @Override
  public double getPosition() {

    if (this.mediaPlayer != null) {
      return this.mediaPlayer.getCurrentRate();
    }
    return 0;
  }

  @Override
  public void setPosition(double position) {

    if (this.mediaPlayer != null) {
      if (this.mediaPlayer.getStatus() == Status.STOPPED) {
        this.mediaPlayer.play();
        this.mediaPlayer.pause();
      }
      if (position < 0) {
        position = 0;
      } else if (position > 1) {
        position = 1;
      }
      double totalSeconds = this.mediaPlayer.getTotalDuration().toSeconds();
      long posSeconds = (long) (totalSeconds * position);
      Duration seekTime = Duration.seconds(posSeconds);
      this.mediaPlayer.seek(seekTime);
    }
  }

  @Override
  public double getDuration() {

    if (this.mediaPlayer != null) {
      Duration totalDuration = this.mediaPlayer.getTotalDuration();
      return totalDuration.toMillis() / MILLIS_PER_SEC;
    }
    return 0;
  }

}
