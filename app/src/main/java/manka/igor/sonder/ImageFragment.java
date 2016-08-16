package manka.igor.sonder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment implements AdapterView.OnItemClickListener {


    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        GridView imagesGridView = (GridView) getActivity().findViewById(R.id.imagesGridView);
        ImageAdapter imageAdapter = new ImageAdapter(getContext());
        if (imageAdapter.getCount() < 6) {
            imagesGridView.setNumColumns(imageAdapter.getCount());
        }
        else if(imageAdapter.getCount()>10){
            imageAdapter.cutCount();
            imagesGridView.setNumColumns(5);
            Log.d("OBRAZKI", "AA");
        }
        else
            imagesGridView.setNumColumns(5);
        imagesGridView.setAdapter(imageAdapter);
        imagesGridView.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
        Toast.makeText(getActivity(), "" + position,
                Toast.LENGTH_SHORT).show();
    }

}


