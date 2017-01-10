package solid.ren.skinlibrary.statusbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;

public class StatusBarUtil {

    private Activity activity;
    private int color;


    public StatusBarUtil(Activity activity, int color) {

        this.activity = activity;
        this.color = color;


    }

    /**
     * your layout file need add android:fitsSystemWindows="true"
     */
    public void setStatusBarColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintEnabled(true);
            // tintManager.setStatusBarTintResource(color);
            tintManager.setStatusBarTintColor(color);
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {

        WindowManager.LayoutParams winParams = activity.getWindow().getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        activity.getWindow().setAttributes(winParams);
    }
}
