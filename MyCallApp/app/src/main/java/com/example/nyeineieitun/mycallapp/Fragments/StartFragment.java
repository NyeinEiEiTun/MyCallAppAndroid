package com.example.nyeineieitun.mycallapp.Fragments;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nyeineieitun.mycallapp.R;

public class StartFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        final Activity activity = getActivity();
        final Button clickHere = (Button) view.findViewById(R.id.btnClickHere);
        clickHere.setOnClickListener(onClickListener);
        return view;
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.btnClickHere:
                    Log.d("OnClicked", "You clicked the button");
                    createAndShowAlertDialog();
                    break;
            }

        }
    };

    private void createAndShowAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("My Title");
        builder.setPositiveButton("09-791234234", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //TODO
                //dialog.dismiss();
                String uri = "tel:" + "09-791234234".trim();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //not granted to call.
                    return;
                }else{
                    getActivity().startActivity(intent);
                }
            }
        });
        builder.setNegativeButton("09-7912342342", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //TODO
                //dialog.dismiss();
                String uri = "tel:" + "09-7912342342".trim();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //not granted to call.
                    return;
                }else{
                    getActivity().startActivity(intent);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
