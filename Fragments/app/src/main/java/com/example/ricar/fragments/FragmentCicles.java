package com.example.ricar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentCicles.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentCicles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCicles extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button mitja;
    private  Button superior;

    // TODO: Rename and change types of parameters
    private ArrayList<Parcelable> mParam1;
    private int mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentCicles() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentCicles newInstance(ArrayList ciclos, int x) {
        FragmentCicles fragment = new FragmentCicles();
        Bundle args = new Bundle();
args.putParcelableArrayList("ciclosArray", ciclos);
args.putInt("ciclosInt", x);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelableArrayList("mitja");
            mParam2 = getArguments().getInt("ciclosInt");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
