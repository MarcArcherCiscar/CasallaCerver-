package com.example.ricar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentCicles extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button mitja;
    private Button superior;

    private ArrayList<Parcelable> mParam1;
    private int mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentCicles() {

    }


    public static FragmentCicles newInstance(ArrayList ciclos, int opcio) {
        FragmentCicles fragment = new FragmentCicles();
        Bundle args = new Bundle();
        args.putParcelableArrayList("ciclosArray", ciclos);
        args.putInt("ciclosInt", opcio);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelableArrayList("ciclosArray");
            mParam2 = getArguments().getInt("ciclosInt");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_fragment_cicles, container, false);
        Button mitja=(Button)v.findViewById(R.id.mitja);
        Button superior=(Button)v.findViewById(R.id.superior);

        if (mParam2==0){
            superior.setVisibility(View.INVISIBLE);
        }
        if(mParam2==1){
            mitja.setVisibility(View.INVISIBLE);
        }
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

    }

}
