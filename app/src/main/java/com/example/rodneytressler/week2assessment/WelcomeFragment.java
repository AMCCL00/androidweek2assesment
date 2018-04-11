package com.example.rodneytressler.week2assessment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rodneytressler on 12/14/17.
 */

public class WelcomeFragment extends Fragment{

    @BindView(R.id.welcome_text)
    protected TextView welcomeText;

    @BindView(R.id.instruction_text)
    protected TextView instructionText;


    public static WelcomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        WelcomeFragment fragment = new WelcomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Account account = getArguments().getParcelable("TAG");
    }


    public void name(String username){
        welcomeText.setText("Hello " + username);
    }

    public void email(String useremail){
        instructionText.setText("Please check your email at "+useremail+ "to verify your account.");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


}
