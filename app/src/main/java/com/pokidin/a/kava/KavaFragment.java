package com.pokidin.a.kava;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class KavaFragment extends Fragment {

    public static KavaFragment newInstance() {
        
        Bundle args = new Bundle();
        
        KavaFragment fragment = new KavaFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public KavaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kava, container, false);
    }

}
