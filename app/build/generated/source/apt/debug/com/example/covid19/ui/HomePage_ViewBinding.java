// Generated code from Butter Knife. Do not modify!
package com.example.covid19.ui;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.covid19.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomePage_ViewBinding implements Unbinder {
  private HomePage target;

  @UiThread
  public HomePage_ViewBinding(HomePage target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HomePage_ViewBinding(HomePage target, View source) {
    this.target = target;

    target.countryList = Utils.findRequiredViewAsType(source, R.id.countryList, "field 'countryList'", RecyclerView.class);
    target.totalConfirmedTV = Utils.findRequiredViewAsType(source, R.id.totalConfirmedTV, "field 'totalConfirmedTV'", TextView.class);
    target.NewConfirmedTV = Utils.findRequiredViewAsType(source, R.id.NewConfirmedTV, "field 'NewConfirmedTV'", TextView.class);
    target.NewDeathsTV = Utils.findRequiredViewAsType(source, R.id.NewDeathsTV, "field 'NewDeathsTV'", TextView.class);
    target.TotalDeathsTV = Utils.findRequiredViewAsType(source, R.id.TotalDeathsTV, "field 'TotalDeathsTV'", TextView.class);
    target.NewRecoveredTV = Utils.findRequiredViewAsType(source, R.id.NewRecoveredTV, "field 'NewRecoveredTV'", TextView.class);
    target.TotalRecoveredTV = Utils.findRequiredViewAsType(source, R.id.TotalRecoveredTV, "field 'TotalRecoveredTV'", TextView.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scrollView, "field 'scrollView'", NestedScrollView.class);
    target.autoCompleteTextView = Utils.findRequiredViewAsType(source, R.id.autoCompleteTextView, "field 'autoCompleteTextView'", AutoCompleteTextView.class);
    target.cancelImg = Utils.findRequiredViewAsType(source, R.id.cancelImg, "field 'cancelImg'", ImageView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomePage target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.countryList = null;
    target.totalConfirmedTV = null;
    target.NewConfirmedTV = null;
    target.NewDeathsTV = null;
    target.TotalDeathsTV = null;
    target.NewRecoveredTV = null;
    target.TotalRecoveredTV = null;
    target.scrollView = null;
    target.autoCompleteTextView = null;
    target.cancelImg = null;
    target.progressBar = null;
  }
}
