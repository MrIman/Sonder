package manka.igor.sonder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Igor on 10.08.2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private int MAX_COUNT = 10;

    public ImageAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public void cutCount() {
        for (int i = 0; i < correctThumbIds.length; i++) {
            Log.d("OBRAZKI", "ZA DUZO");
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
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.pilka1, R.drawable.pilka1, R.drawable.pilka1, R.drawable.pilka1, R.drawable.pilka2, R.drawable.pilka1, R.drawable.pilka2, R.drawable.pilka1, R.drawable.pilka2, R.drawable.pilka1, R.drawable.pilka2, R.drawable.pilka1, R.drawable.pilka2
    };
    private Integer[] correctThumbIds = new Integer[10];

}

