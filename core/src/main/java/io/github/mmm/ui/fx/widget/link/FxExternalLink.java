/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.link;

import io.github.mmm.ui.api.widget.link.UiExternalLink;
import io.github.mmm.ui.fx.FxApplication;
import javafx.event.ActionEvent;

/**
 * Implementation of {@link UiExternalLink} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxExternalLink extends FxAbstractLink implements UiExternalLink {

  private String url;

  /**
   * The constructor.
   */
  public FxExternalLink() {

    super();
  }

  @Override
  public String getUrl() {

    return this.url;
  }

  @Override
  public void setUrl(String url) {

    assert (isAbsolute(url));
    this.url = url;
    ensureHandlers();
  }

  @Override
  protected void onAction(ActionEvent event) {

    super.onAction(event);
    if (this.url != null) {
      FxApplication.get().getHostServices().showDocument(this.url);
    }
  }

  private boolean isAbsolute(String uri) {

    return uri.startsWith("https://") || uri.startsWith("http://") || uri.startsWith("file:") || uri.startsWith("ftp:");
  }

}
