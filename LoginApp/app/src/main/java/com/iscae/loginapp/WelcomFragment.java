package com.iscae.loginapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class WelcomFragment extends Fragment {

    private TextView txtNom;
    private View rootView, welcomFrag;
    private int[] color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_welcom,container,false);

        initView();
        getNom();
        BackgroundColor();

        return rootView;
    }

    private void BackgroundColor(){
        color = new int[] {Color.BLUE,Color.CYAN,Color.rgb(33,152,243),Color.rgb(98,0,238),Color.rgb(55,0,179),
                           Color.rgb(156,39,176),Color.rgb(9,113,126),Color.rgb(46,109,164)};
        int arayLength = color.length;
        Random random = new Random();
        int rNum = random.nextInt(arayLength);
        welcomFrag.setBackgroundColor(color[rNum]);
    }

    private void initView(){
        welcomFrag = rootView.findViewById(R.id.welcomFrag);
        txtNom = rootView.findViewById(R.id.textNom);
    }

    private void getNom(){
        Bundle bundle = getArguments();
        String nom = bundle.getString("Nom");

        txtNom.setText("Bienvennue "+ nom);
    }
}