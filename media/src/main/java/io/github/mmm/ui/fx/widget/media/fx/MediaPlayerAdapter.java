/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.media.fx;

import io.github.mmm.ui.api.attribute.AttributeFeatureMedia;
import javafx.scene.Node;
import javafx.scene.media.MediaPlayer;

/**
 * Interface to adapt JavaFx {@link MediaPlayer}.
 *
 * @since 1.0.0
 */
public interface MediaPlayerAdapter extends AttributeFeatureMedia {

  /**
   * @param player the new {@link MediaPlayer} (when the audio/video has changed).
   */
  void setMediaPlayer(MediaPlayer player);

  /**
   * @return the optional controls.
   */
  default Node getControls() {

    return null;
  }

}
