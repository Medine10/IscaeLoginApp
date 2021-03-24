package com.iscae.loginapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button login;
    private View rootView;
    private FragmentManager fragmentManager;
    private String email;
    private String password;

    Map<String, Login> list = new HashMap<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_login, container, false);

        initView();
        setListeners();

        return rootView;
    }

    private void initView() {
        edtEmail = rootView.findViewById(R.id.email);
        edtPassword = rootView.findViewById(R.id.password);
        login = rootView.findViewById(R.id.login);
    }

    private void reset() {
        edtEmail.setText(null);
        edtPassword.setText(null);
    }

    private void setListeners() {
        login.setOnClickListener(this);
    }

    private void addUser() {

        Login login = new Login("medine@gmail.com", "medin12#E", "Medine");
        Login login1 = new Login("aichana@gmail.com", "Aicha12#na", "Aichana");
        Login login2 = new Login("lalla@gmail.com", "Lall12#a", "Lalla");
        list.put(login.getEmail(), login);
        list.put(login1.getEmail(), login1);
        list.put(login2.getEmail(), login2);
    }

    private boolean validateEmail() {
        String emailInput = edtEmail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            edtEmail.setError("Ce champ est obligatoire");
            return false;
        } else if (!Regex.EMAIL_PATTERN.matcher(emailInput).matches()) {
            //!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()
            edtEmail.setError("Adresse email doit avoir au moins 2 caractères avant @ et 3 caractères après et se " +
                    "termine soit par (.com) ou (.net) ou (.org)");
            return false;
        } else {
            edtEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = edtPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            edtPassword.setError("Ce champ est obligatoire");
            return false;
        } else if (!Regex.PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            edtPassword.setError("Le mot de passe doit être de 8 caractères contenant une lettre minuscule, " +
                    "une lettre majuscule, un chiffre et un caractère spécial");
            return false;
        } else {
            edtPassword.setError(null);
            return true;
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            if (validateEmail() == true && validatePassword() == true) {

                addUser();

                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();

                Set<Map.Entry<String, Login>> entries = list.entrySet();
                for (Map.Entry<String, Login> log : entries) {
                    if (log.getKey().equals(email) && log.getValue().getPassword().equals(password)) {
                        Bundle bundle = new Bundle();
                        //bundle.putString("Email",email);
                        //bundle.putString("Password", password);
                        bundle.putString("Nom", log.getValue().getNom());

                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        WelcomFragment welcomFragment = new WelcomFragment();
                        welcomFragment.setArguments(bundle);
                        fragmentTransaction.add(R.id.welcom_frame_layout, welcomFragment);
                        fragmentTransaction.addToBackStack("onClick");
                        fragmentTransaction.commit();

                        reset();

                    }
                }
            }
        }
    }


}