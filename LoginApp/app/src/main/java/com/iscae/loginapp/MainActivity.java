package com.iscae.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListeners();
        AddLoginFragment();

    }

    private void initView() {
        back = findViewById(R.id.back);
    }

    private void setListeners() {
        back.setOnClickListener(this);
    }

    private void AddLoginFragment() {
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout1, new LoginFragment()).commit();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.login_frame_layout, new LoginFragment()).commit();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.back) {
            fragmentManager.popBackStack();
        }

    }
}