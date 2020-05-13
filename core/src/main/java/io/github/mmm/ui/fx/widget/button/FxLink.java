/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.button;

import io.github.mmm.ui.api.widget.button.UiLink;
import io.github.mmm.ui.fx.FxApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

/**
 * Implementation of {@link UiLink} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxLink extends FxAbstractButton<Hyperlink> implements UiLink {

  private String href;

  /**
   * The constructor.
   */
  public FxLink() {

    super(new Hyperlink());
  }

  @Override
  public String getHref() {

    return this.href;
  }

  @Override
  public void setHref(String href) {

    this.href = href;
    ensureHandlers();
  }

  @Override
  protected void onAction(ActionEvent event) {

    super.onAction(event);
    if (this.href != null) {
      if (isAbsolute(this.href)) {
        FxApplication.get().getHostServices().showDocument(this.href);
      } else {
        // TODO
      }
    }
  }

  private boolean isAbsolute(String url) {

    return url.startsWith("https://") || url.startsWith("http://") || url.startsWith("file:") || url.startsWith("ftp:");
  }

}
