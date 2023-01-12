// Generated by view binder compiler. Do not edit!
package com.elshafee.androidclasswin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.elshafee.androidclasswin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemTodoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CheckBox chktodo;

  @NonNull
  public final TextView todotxt;

  private ItemTodoBinding(@NonNull LinearLayout rootView, @NonNull CheckBox chktodo,
      @NonNull TextView todotxt) {
    this.rootView = rootView;
    this.chktodo = chktodo;
    this.todotxt = todotxt;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemTodoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemTodoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_todo, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemTodoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.chktodo;
      CheckBox chktodo = ViewBindings.findChildViewById(rootView, id);
      if (chktodo == null) {
        break missingId;
      }

      id = R.id.todotxt;
      TextView todotxt = ViewBindings.findChildViewById(rootView, id);
      if (todotxt == null) {
        break missingId;
      }

      return new ItemTodoBinding((LinearLayout) rootView, chktodo, todotxt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
