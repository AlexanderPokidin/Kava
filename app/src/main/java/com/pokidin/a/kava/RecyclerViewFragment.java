package com.pokidin.a.kava;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pokidin.a.kava.adapter.KavaAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private KavaAdapter mKavaAdapter;

    public static RecyclerViewFragment newInstance() {

        Bundle args = new Bundle();

        RecyclerViewFragment fragment = new RecyclerViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        mRecyclerView = view.findViewById(R.id.rw_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mKavaAdapter = new KavaAdapter();
        mRecyclerView.setAdapter(mKavaAdapter);
        // Inflate the layout for this fragment
        return view;
    }

}
