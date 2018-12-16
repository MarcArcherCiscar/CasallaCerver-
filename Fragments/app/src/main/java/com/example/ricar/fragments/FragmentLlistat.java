package com.example.ricar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentLlistat extends Fragment{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView textView;
    private FragmentCicles Fc = new FragmentCicles();
    // TODO: Rename and change types of parameters
    private int mParam1;
    private ArrayList<CicleFlorida> mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentLlistat() {

    }

    public static FragmentLlistat newInstance(ArrayList mostrar, int x)  {
        FragmentLlistat fragment = new FragmentLlistat();
        Bundle args = new Bundle();
        args.putParcelableArrayList("ciclosArray", mostrar);
        args.putInt("ciclosInt", x);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt("ciclosInt");
            mParam2 = getArguments().getParcelableArrayList("ciclosArray");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_fragment_titulaciones, container, false);
        textView=v.findViewById(R.id.textView);
        llegir();
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

    private void llegir() {
        textView.setText("");
        if(mParam2!=null){
            for (int i=0; i<mParam2.size();i++){
                if(mParam1==1 && mParam2.get(i).getTipus()=="Mitja");
                {
                    textView.setText(textView.getText()+mParam2.get(i).toString()+"\n");
                }
                if(mParam1==2 && mParam2.get(i).getTipus()=="Superior")
                {
                    textView.setText(textView.getText()+mParam2.get(i).toString()+"\n");
                }
            }
        }
    }
}
