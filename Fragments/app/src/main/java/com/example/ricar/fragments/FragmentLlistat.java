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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentLlistat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentLlistat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLlistat extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView textView;

    // TODO: Rename and change types of parameters
    private int mParam1;
    private ArrayList<CicleFlorida> mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentLlistat() {
        // Required empty public constructor
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
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getParcelableArrayList(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_titulaciones, container, false);
        textView=v.findViewById(R.id.textView);
        llegir();
        return v;
    }

    private void llegir() {
        textView.setText("");
        Log.d("MIO","Antees del if");
        if(mParam2!=null){
            Log.d("MIO","Antees del for");
            for (int i=0; i<mParam2.size();i++){
                if(mParam1==1 && mParam2.get(i).getTipus()=="Mitja"){

                    textView.setText(textView.getText()+mParam2.get(i).toString()+"\n");
                }
                if(mParam1==2 && mParam2.get(i).getTipus()=="Superior"){

                }
            }
        }
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



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {


    }


}
