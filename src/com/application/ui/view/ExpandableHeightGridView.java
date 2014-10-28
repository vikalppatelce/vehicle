package com.application.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ExpandableHeightGridView extends GridView
{

    public ExpandableHeightGridView(Context context)
    {
        super(context);
        expanded = true;
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        expanded = true;
    }

    public ExpandableHeightGridView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        expanded = true;
    }

    public boolean isExpanded()
    {
        return expanded;
    }

    public void onMeasure(int i, int j)
    {
        if(isExpanded())
        {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(0x1fffffff, 0x80000000));
            getLayoutParams().height = getMeasuredHeight();
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setExpanded(boolean flag)
    {
        expanded = flag;
    }

    boolean expanded;
}
