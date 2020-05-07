package com.example.teacher.Manager.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.teacher.R;


public class TeacherAccountFragment extends Fragment implements View.OnClickListener {
    private EditText TeaNum,TeaName,TeaSex, TeaTel,TeaCol;
    private Button TeaQry,Teaadd,TeaUp,TeaDele,Teasubmit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_teacher_account, container, false);


        TeaNum = view.findViewById(R.id.TeaNum);
        TeaQry = view.findViewById(R.id.TeaQry);
        TeaName = view.findViewById(R.id.TeaName);
        TeaSex = view.findViewById(R.id.TeaSex);
        TeaTel = view.findViewById(R.id.TeaTel);
        TeaCol = view.findViewById(R.id.TeaCol);
        Teaadd = view.findViewById(R.id.Teaadd);
        TeaUp = view.findViewById(R.id.TeaUp);
        TeaDele = view.findViewById(R.id.TeaDele);
        Teasubmit = view.findViewById(R.id.Teasubmit);
        TeaQry.setOnClickListener(this);
        Teaadd.setOnClickListener(this);
        TeaDele.setOnClickListener(this);
        TeaUp.setOnClickListener(this);
        Teasubmit.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
