/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media.fx;

import io.github.mmm.ui.api.widget.img.UiIcon;
import io.github.mmm.ui.fx.widget.FxWidget;
import io.github.mmm.ui.fx.widget.media.FxMediaPlayer;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Controls for {@link FxMediaPlayer}.
 *
 * @since 1.0.0
 */
public class MediaPlayerControlBar extends MediaPlayerWrapper {

  private final FxMediaPlayer fxMediaPlayer;

  private final HBox controls;

  private final Button playButton;

  private final Slider positionSlider;

  private final Button muteButton;

  private final Slider volumeSlider;

  private final UiIcon playIcon;

  private final UiIcon pauseIcon;

  private final UiIcon muteIcon;

  private final UiIcon unmuteIcon;

  private Duration duration;

  private ChangeListener<? super Duration> positionListener;

  /**
   * The constructor.
   *
   * @param fxMediaPlayer the {@link FxMediaPlayer}.
   */
  public MediaPlayerControlBar(FxMediaPlayer fxMediaPlayer) {

    super();
    this.fxMediaPlayer = fxMediaPlayer;
    this.playButton = new Button();
    this.playButton.setOnAction(this::onPlay);
    this.positionSlider = new Slider();
    this.positionSlider.setMax(1);
    HBox.setHgrow(this.positionSlider, Priority.ALWAYS);
    this.muteButton = new Button();
    this.muteButton.setOnAction(this::onMute);
    this.volumeSlider = new Slider();
    this.volumeSlider.setPrefWidth(70);
    this.volumeSlider.setMinWidth(30);
    this.volumeSlider.setMax(1);
    this.volumeSlider.setValue(getVolume());
    this.volumeSlider.valueProperty().addListener(this::onVolumeChange);
    this.controls = new HBox();
    this.controls.getStyleClass().add("ui-media-controls");
    this.controls.setAlignment(Pos.CENTER);
    this.controls.getChildren().add(this.playButton);
    this.controls.getChildren().add(this.positionSlider);
    this.controls.getChildren().add(this.muteButton);
    this.controls.getChildren().add(this.volumeSlider);
    this.positionListener = (v, o, n) -> {
      System.out.println("position changed");
      Platform.runLater(() -> {
        updatePosition();
      });
    };
    this.positionSlider.valueProperty().addListener(this::onPositionChange);
    this.playIcon = UiIcon.of(UiIcon.ID_PLAY);
    this.pauseIcon = UiIcon.of(UiIcon.ID_PAUSE);
    this.muteIcon = UiIcon.of(UiIcon.ID_MUTE);
    this.unmuteIcon = UiIcon.of(UiIcon.ID_UNMUTE);
    setPlayButtonIcon(false);
    setMuteButtonIcon(false);
  }

  @Override
  protected void onEndOfMedia() {

    super.onEndOfMedia();
    setPlaying(false); // TODO consider repeat feature
  }

  private void onPlay(ActionEvent event) {

    setPlaying(!isPlaying());
  }

  @Override
  public void setPlaying(boolean playing) {

    setPlayButtonIcon(playing);
    super.setPlaying(playing);
  }

  private void setPlayButtonIcon(boolean pause) {

    UiIcon icon;
    if (pause) {
      icon = this.pauseIcon;
    } else {
      icon = this.playIcon;
    }
    this.playButton.setGraphic(FxWidget.getTopNode(icon));
  }

  private void onMute(ActionEvent event) {

    setMuted(!isMuted());
  }

  @Override
  public void setMuted(boolean muted) {

    if (muted != isMuted()) {
      setMuteButtonIcon(muted);
    }
    super.setMuted(muted);
  }

  private void setMuteButtonIcon(boolean unmute) {

    UiIcon icon;
    if (unmute) {
      icon = this.unmuteIcon;
    } else {
      icon = this.muteIcon;
    }
    this.muteButton.setGraphic(FxWidget.getTopNode(icon));
    icon.setIconId(icon.getIconId());
  }

  private void onVolumeChange(Observable o) {

    if (this.volumeSlider.isPressed()) {
      setVolume(this.volumeSlider.getValue());
    }
  }

  private void onPositionChange(Observable o) {

    if (this.positionSlider.isPressed()) {
      setPosition(this.positionSlider.getValue());
    }
  }

  @Override
  public void setMediaPlayer(MediaPlayer player) {

    if (this.mediaPlayer != null) {
      this.mediaPlayer.currentTimeProperty().removeListener(this.positionListener);
    }
    super.setMediaPlayer(player);
    this.duration = null;
    this.positionSlider.setValue(0);
    this.positionSlider.setDisable(true);
    if (this.mediaPlayer != null) {
      this.mediaPlayer.setOnReady(this::onReady);
      this.mediaPlayer.currentTimeProperty().addListener(this.positionListener);
    }
    this.fxMediaPlayer.getWidget().setMediaPlayer(player);
  }

  private void onReady() {

    if (this.mediaPlayer == null) {
      return;
    }
    this.duration = this.mediaPlayer.getMedia().getDuration();
    this.positionSlider.setDisable(false);
  }

  @Override
  public void setVolume(double volume) {

    super.setVolume(volume);
  }

  private void updatePosition() {

    System.out.println("updating position");
    MediaPlayer player = this.mediaPlayer;
    if ((player == null) || (this.duration == null)) {
      return;
    }
    Duration currentTime = player.getCurrentTime();
    this.positionSlider.setDisable(this.duration.isUnknown());
    this.positionSlider.setValue(player.getCurrentRate());
    this.positionSlider.setValue(currentTime.toMillis() / this.duration.toMillis());
  }

  @Override
  public Node getControls() {

    return this.controls;
  }

}
