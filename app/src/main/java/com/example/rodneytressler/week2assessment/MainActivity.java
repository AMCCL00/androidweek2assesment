package com.example.rodneytressler.week2assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private fragment_welcome welcomeFragment;
    private String TAG = "TAG";

    @BindView(R.id.input_name)
    protected EditText nameInput;

    @BindView(R.id.input_email)
    protected TextView inputEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.button_register)
    protected void registerButtonClicked(){
        Account account = new Account(nameInput, inputEmail);
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG , account);
        welcomeFragment = fragment_welcome.newInstance();
        welcomeFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,welcomeFragment).commit();
    }

    private void toastRegistrationFailure() {
        Toast.makeText(this, "Please enter all fields first!", Toast.LENGTH_SHORT).show();
    }
}
