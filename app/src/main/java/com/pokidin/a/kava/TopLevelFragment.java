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
                Intent intent = new Intent(getActivity(), RecyclerViewActivity.class);
                startActivity(intent);
                Log.i(TAG, "Intent started");



            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private KavaFragment getFragment(){
        return KavaFragment.newInstance();
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
