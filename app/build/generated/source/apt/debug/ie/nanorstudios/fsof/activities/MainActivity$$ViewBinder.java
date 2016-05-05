// Generated code from Butter Knife. Do not modify!
package ie.nanorstudios.fsof.activities;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity$$ViewBinder<T extends MainActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131296256, "method 'startAllGame'");
    unbinder.view2131296256 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startAllGame();
      }
    });
    view = finder.findRequiredView(source, 2131296257, "method 'startActionGame'");
    unbinder.view2131296257 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startActionGame();
      }
    });
    view = finder.findRequiredView(source, 2131296258, "method 'startComedyGame'");
    unbinder.view2131296258 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startComedyGame();
      }
    });
    view = finder.findRequiredView(source, 2131296259, "method 'startRomanceGame'");
    unbinder.view2131296259 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startRomanceGame();
      }
    });
    view = finder.findRequiredView(source, 2131296260, "method 'startSciFiGame'");
    unbinder.view2131296260 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startSciFiGame();
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MainActivity> implements Unbinder {
    private T target;

    View view2131296256;

    View view2131296257;

    View view2131296258;

    View view2131296259;

    View view2131296260;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      view2131296256.setOnClickListener(null);
      view2131296257.setOnClickListener(null);
      view2131296258.setOnClickListener(null);
      view2131296259.setOnClickListener(null);
      view2131296260.setOnClickListener(null);
    }
  }
}
