package com.example.teacher.Manager.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teacher.R;

import java.util.ArrayList;


public class AccountFragment extends Fragment implements View.OnClickListener{


    private static FragmentManager fm ;
    private ArrayList<Fragment> fragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_account, container, false);

        view.findViewById(R.id.stuAcc).setOnClickListener(this);
        view.findViewById(R.id.teaAcc).setOnClickListener(this);


        fragments = new ArrayList<Fragment>();
        fragments.add(new StudentAccountFragment());
        fragments.add(new TeacherAccountFragment());
        fm=getChildFragmentManager();
       showFragment(new StudentAccountFragment());
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.stuAcc){
            showFragment(new StudentAccountFragment());


        }
        if(v.getId()==R.id.teaAcc){
            showFragment(new TeacherAccountFragment());
        }

    }
    public void showFragment(Fragment fragment){
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.accshow,fragment);
        ft.commit();

    }

}
