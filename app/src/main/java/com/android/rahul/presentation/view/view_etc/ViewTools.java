package com.android.rahul.presentation.view.view_etc;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by rahul khurana on 13.05.2020.
 */

public class ViewTools {

    public static int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}
