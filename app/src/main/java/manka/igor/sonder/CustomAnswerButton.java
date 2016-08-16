package manka.igor.sonder;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Igor on 12.08.2016.
 */
public class CustomAnswerButton extends Button {

    public CustomAnswerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("Button","tworze");

    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
//        this.setMeasuredDimension(
//                parentWidth, parentHeight);
//    }
}
