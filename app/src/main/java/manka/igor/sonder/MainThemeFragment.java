package manka.igor.sonder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainThemeFragment extends Fragment {


    public MainThemeFragment() {
        // Required empty public constructor
    }

    boolean image = true; //czy obrazkowo czy tekstowo


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Fragment questionFragment = new QuestionFragment();
        FragmentTransaction questionTransaction = getChildFragmentManager().beginTransaction();
        questionTransaction.replace(R.id.question_container, questionFragment);
        questionTransaction.commit();
        if (image) {

            Fragment fragment = new ImageFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.commit();

        } else {
            Fragment fragment = new AnswersFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.commit();
        }
        View view = (View) inflater.inflate(R.layout.fragment_main_theme, container, false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
