package manka.igor.sonder;


import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnswersFragment extends Fragment implements AdapterView.OnItemClickListener {





        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_particle_nested, container, false);
        }

        @Override
        public void onStart() {
            super.onStart();

            GridView answersGridView = (GridView) getActivity().findViewById(R.id.answersGridView);
            AnswersAdapter answersAdapter = new AnswersAdapter(getContext());
            if (answersAdapter.getCount() < 6) {
                answersGridView.setNumColumns(1);
            }
            else if(answersAdapter.getCount()>10){
                answersAdapter.cutCount();
                answersGridView.setNumColumns(2);
                Log.d("Odpowiedzi", "za duzo");
            }
            else
                answersGridView.setNumColumns(2);
            answersGridView.setAdapter(answersAdapter);
            answersGridView.setOnItemClickListener(this);

        }

    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
        Toast.makeText(getActivity(), "" + position,
                Toast.LENGTH_SHORT).show();
    }



}
