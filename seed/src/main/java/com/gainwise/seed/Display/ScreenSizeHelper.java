package com.gainwise.seed.Display;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;

public class ScreenSizeHelper {

    int displayWidth, displayHeight;
    public ScreenSizeHelper(Activity activity) {
        Display display =
                activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //below is px
        displayWidth = size.x;
        displayHeight = size.y;

    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public int pxToDp(int px) {

        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
    public int dpToPx(int dp) {

        int px = Math.round(dp * Resources.getSystem().getDisplayMetrics().density);
        return px;
    }
}