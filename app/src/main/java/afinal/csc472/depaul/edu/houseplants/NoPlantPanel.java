package afinal.csc472.depaul.edu.houseplants;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class NoPlantPanel extends LinearLayout{

    public NoPlantPanel(Context context) {
        super(context);
        inflaterContextAndAddLayoutToLayout(context);
    }

    public NoPlantPanel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflaterContextAndAddLayoutToLayout(context);
    }

    public NoPlantPanel(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflaterContextAndAddLayoutToLayout(context);
    }

    public NoPlantPanel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflaterContextAndAddLayoutToLayout(context);
    }

    private void inflaterContextAndAddLayoutToLayout(Context context)
    {
        NoPlantPanel.LayoutParams params = new NoPlantPanel.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        setLayoutParams(params);
        addView(new Star(context));
        addView(new awesome(context));
        addView(new tip(context));
    }

    private class Star extends AppCompatImageView {
        public Star(Context context) {
            super(context);
            setupimg();
        }

        public Star(Context context, AttributeSet attrs) {
            super(context, attrs);
            setupimg();
        }

        public Star(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            setupimg();
        }

        public void setupimg() {
            setBackgroundResource(R.drawable.star);
            setPadding(0,30,0,30);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.topMargin = 30;
            params.gravity = Gravity.CENTER;
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.height = 0;
            params.weight = (float)0.9;
            setLayoutParams(params);
        }
    }

    private class awesome extends AppCompatTextView{
        public awesome(Context context) {
            super(context);
            setText();
        }

        public awesome(Context context, AttributeSet attrs) {
            super(context, attrs);
            setText();
        }

        public awesome(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            setText();
        }

        public void setText() {
            setText(R.string.awesome);
            setTextSize(30);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.topMargin = 30;
            params.gravity = Gravity.CENTER;
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.height = 0;
            params.weight = (float)0.25;
            setLayoutParams(params);
        }
    }

    private class tip extends  AppCompatTextView {
        public tip(Context context) {
            super(context);
            settip();
        }

        public tip(Context context, AttributeSet attrs) {
            super(context, attrs);
            settip();
        }

        public tip(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            settip();
        }

        public void settip() {
            setText(R.string.tip);
            setTextSize(30);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.leftMargin = 30;
            params.rightMargin = 30;
            params.gravity = Gravity.CENTER;
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.height = 55;
            params.weight = (float)1;
            setLayoutParams(params);
        }
    }
}
