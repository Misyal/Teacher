package com.example.teacher.Manager.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.teacher.R;


public class StudentAccountFragment extends Fragment implements View.OnClickListener{

    private Button add,delete,upload,squrey,ssubmit;
    private EditText stunum,stuname,stusex,stuclass,stupro,stucoll;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_student_account, container, false);

        stunum = view.findViewById(R.id.StuNum);
        stuname =view.findViewById(R.id.StuName);
        stusex = view.findViewById(R.id.StuSex);
        stuclass = view.findViewById(R.id.StuClass);
        stupro = view.findViewById(R.id.StuPro);
        stucoll =view.findViewById(R.id.StuCol);
        squrey=view.findViewById(R.id.Squrey);
        squrey.setOnClickListener(this);
        add = view.findViewById(R.id.Stuadd);
        add.setOnClickListener(this);
        delete = view. findViewById(R.id.StuUp);
        delete.setOnClickListener(this);
        upload = view.findViewById(R.id.StuDele);
        upload.setOnClickListener(this);
        ssubmit=view.findViewById(R.id.Stusubmit);
        ssubmit.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {


    }
}
