package com.pokidin.a.kava;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopLevelFragment extends Fragment {
    private static final String TAG = "TopLevelFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_level, container, false);
        Button button = view.findViewById(R.id.btn_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), KavaListActivity.class);
//                startActivity(intent);
//                Log.i(TAG, "Intent started");


                FragmentManager fragmentManager = getChildFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.fr_container, getFragment())
                        .addToBackStack(RecyclerViewFragment.class.getSimpleName())
                        .commit();
                Log.i(TAG, "RecyclerViewFragment started");
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private RecyclerViewFragment getFragment(){
        return RecyclerViewFragment.newInstance();
    }



    public static TopLevelFragment newInstance() {

        Bundle args = new Bundle();

        TopLevelFragment fragment = new TopLevelFragment();
        fragment.setArguments(args);
        Log.i(TAG, "TopLevelFragment created");
        return fragment;
    }

    public TopLevelFragment() {
        // Required empty public constructor
    }

}
