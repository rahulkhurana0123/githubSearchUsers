package com.android.rahul.presentation.view.view_etc;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by rahul khurana on 13.05.2020.
 */

public class ToolbarTitleMarginBugFix extends androidx.appcompat.widget.Toolbar {

    public ToolbarTitleMarginBugFix(Context context) {
        super(context);
        setDrawingCacheEnabled(false);
        setChildrenDrawingCacheEnabled(false);
        setWillNotCacheDrawing(true);
    }

    public ToolbarTitleMarginBugFix(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawingCacheEnabled(false);
        setChildrenDrawingCacheEnabled(false);
        setWillNotCacheDrawing(true);
    }

    public ToolbarTitleMarginBugFix(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDrawingCacheEnabled(false);
        setChildrenDrawingCacheEnabled(false);
        setWillNotCacheDrawing(true);
    }

    @Override
    public int getTitleMarginBottom() {
        return ViewTools.dpToPx(56, getContext());
    }

}