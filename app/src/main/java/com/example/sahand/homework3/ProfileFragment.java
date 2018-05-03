package com.example.sahand.homework3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private static final String ARG_PARAM_OCCUPATION = "occupation";
    private static final String ARG_PARAM_DESCRIPTION = "description";
    private static final String ARG_PARAM_NAMEANDAGE = "nameAndAge";

    public ProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and set it to a View variable
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView nameAndAge = view.findViewById(R.id.name_and_age_display);
        TextView occupation = view.findViewById(R.id.occupation_display);
        TextView description = view.findViewById(R.id.description_display);

        if(getArguments() != null) {
            occupation.setText(getArguments().getString(ARG_PARAM_OCCUPATION));
            description.setText(getArguments().getString(ARG_PARAM_DESCRIPTION));
            nameAndAge.setText(getArguments().getString(ARG_PARAM_NAMEANDAGE));
        }

        return view;
    }

}
