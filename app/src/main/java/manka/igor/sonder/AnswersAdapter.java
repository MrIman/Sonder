package manka.igor.sonder;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import manka.igor.sonder.model.LoginAttempt;


/**
 * Created by Igor on 12.08.2016.
 */
public class AnswersAdapter extends BaseAdapter {
    private Context context;
    private int MAX_COUNT = 10;

    public AnswersAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public void cutCount() {
        for (int i = 0; i < correctThumbIds.length; i++) {
            Log.d("Odpowiedzi", "ZA DUZO");
            correctThumbIds[i] = mThumbIds[i];
        }
        mThumbIds = null;
        mThumbIds = correctThumbIds;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        CustomAnswerButton button;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        if (convertView == null) {

            button = new CustomAnswerButton(context, null);

            button.setLayoutParams(params);
            button.setTextSize(32);
            button.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.MATCH_PARENT));
            button.setPadding(30, 30, 30, 30);
            button.setMaxLines(3);

        } else {
            button = (CustomAnswerButton) convertView;
        }
        button.setText(mThumbIds[position]);
        return button;
    }

    // references to our images
    private String[] mThumbIds = {
            "Button1", "Button2","Button1", "Button2","Button1", "Button2","Button1", "Button2"
    };
    private String[] correctThumbIds = new String[10];

}
