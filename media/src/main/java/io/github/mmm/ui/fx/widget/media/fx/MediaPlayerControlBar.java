/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media.fx;

import io.github.mmm.ui.fx.widget.media.FxMediaPlayer;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

/**
 * Controls for {@link FxMediaPlayer}.
 */
public class MediaPlayerControlBar extends MediaPlayerWrapper {

  private final FxMediaPlayer fxMediaPlayer;

  private final HBox controls;

  private final Button playButton;

  private final Slider positionSlider;

  private final Button muteButton;

  private final Slider volumeSlider;

  private ChangeListener<? super Number> positionListener;

  /**
   * The constructor.
   *
   * @param fxMediaPlayer the {@link FxMediaPlayer}.
   */
  public MediaPlayerControlBar(FxMediaPlayer fxMediaPlayer) {

    super();
    this.fxMediaPlayer = fxMediaPlayer;
    this.playButton = new Button(">");
    this.playButton.setOnAction(this::onPlay);
    this.positionSlider = new Slider();
    this.positionSlider.setMax(1);
    HBox.setHgrow(this.positionSlider, Priority.ALWAYS);
    this.muteButton = new Button("M");
    this.muteButton.setOnAction(this::onMute);
    this.volumeSlider = new Slider();
    this.volumeSlider.setPrefWidth(70);
    this.volumeSlider.setMinWidth(30);
    this.volumeSlider.setMax(1);
    this.volumeSlider.setValue(getVolume());
    this.volumeSlider.valueProperty().addListener(this::onVolumeChange);
    this.controls = new HBox();
    this.controls.getChildren().add(this.playButton);
    this.controls.getChildren().add(this.positionSlider);
    this.controls.getChildren().add(this.muteButton);
    this.controls.getChildren().add(this.volumeSlider);
    this.positionListener = (v, o, n) -> {
      Platform.runLater(() -> {
        updatePosition();
      });
    };
    this.positionSlider.valueProperty().addListener(this::onPositionChange);
  }

  private void onPlay(ActionEvent event) {

    boolean playing = isPlaying();
    if (playing) {
      this.playButton.setText("||");
    } else {
      this.playButton.setText(">");
    }
    setPlaying(!playing);
  }

  private void onMute(ActionEvent event) {

    setMuted(!isMuted());
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
      this.mediaPlayer.currentRateProperty().removeListener(this.positionListener);
    }
    super.setMediaPlayer(player);
    if (this.mediaPlayer != null) {
      this.mediaPlayer.currentRateProperty().addListener(this.positionListener);
    }
    this.fxMediaPlayer.getWidget().setMediaPlayer(player);
  }

  @Override
  public void setVolume(double volume) {

    super.setVolume(volume);
  }

  private void updatePosition() {

    MediaPlayer player = this.mediaPlayer;
    if (player == null) {
      return;
    }
    this.positionSlider.setValue(player.getCurrentRate());
  }

  @Override
  public Node getControls() {

    return this.controls;
  }

}
