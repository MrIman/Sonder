package manka.igor.sonder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class DataArrayAdapter extends ArrayAdapter<Data> {
    public DataArrayAdapter(Context context) {
        super(context, R.layout.fragment_particle_nested);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return super.getView(position, convertView, parent);
    }
}
