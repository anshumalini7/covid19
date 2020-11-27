// Generated code from Butter Knife. Do not modify!
package com.example.covid19.ui;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.covid19.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeDetails_ViewBinding implements Unbinder {
  private HomeDetails target;

  @UiThread
  public HomeDetails_ViewBinding(HomeDetails target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomeDetails_ViewBinding(HomeDetails target, View source) {
    this.target = target;

    target.countryCasesList = Utils.findRequiredViewAsType(source, R.id.countryCasesList, "field 'countryCasesList'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeDetails target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.countryCasesList = null;
    target.progressBar = null;
  }
}
