package com.example.ricar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Iterator;

public class FragmentTitulaciones extends Fragment  implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentTitulaciones() {
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentTitulaciones newInstance(String param1, String param2) {
        FragmentTitulaciones fragment = new FragmentTitulaciones();
        Bundle args = new Bundle();
        args.putString("ciclosInt", param1);
        args.putString("ciclosArray", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_fragment_titulaciones, container, false);
        final Button empresa=v.findViewById(R.id.empresa);
        final Button esports=v.findViewById(R.id.esports);
        final Button informatica=v.findViewById(R.id.informatica);
        empresa.setOnClickListener(this);
        esports.setOnClickListener(this);
        informatica.setOnClickListener(this);
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
    public void onClick(View v) {
        if (v.getId()==R.id.empresa){
            mListener.mostrarCicles("EMPRESA");
        }
        if (v.getId()==R.id.esports)
        {
            mListener.mostrarCicles("ESPORT");
        }
        if (v.getId()==R.id.informatica)
        {
            mListener.mostrarCicles("INFORMÀTICA");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void mostrarCicles(String cicle);

    }
}
