package com.example.teacher.Manager.Fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.teacher.R;


public class NoticeFragment extends Fragment {

    private EditText conTitle;
    private EditText concon;
    private Button upload;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_notice_manger, container, false);
        conTitle =view.findViewById(R.id.conTitle);
        concon = view.findViewById(R.id.concon);
        upload = view.findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}
