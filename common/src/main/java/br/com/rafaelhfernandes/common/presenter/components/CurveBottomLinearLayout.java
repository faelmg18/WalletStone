package br.com.rafaelhfernandes.common.presenter.components;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import br.com.rafaelhfernandes.common.R;

public class CurveBottomLinearLayout extends LinearLayout {
    public CurveBottomLinearLayout(Context context) {
        super(context);
        init();
    }

    public CurveBottomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CurveBottomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CurveBottomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            setBackgroundDrawable(new CurveBottomDrawable(R.color.orange));
        } else {
            setBackground(new CurveBottomDrawable(R.color.orange));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
