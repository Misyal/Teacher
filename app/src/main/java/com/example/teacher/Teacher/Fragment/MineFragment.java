package com.example.teacher.Teacher.Fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.teacher.R;




public class MineFragment extends Fragment {

    private Button submit;
    private EditText Tname,Ttel,Tcollege;
    private Spinner Tesx;

    private ArrayAdapter<String> arrayAdapter;
    private String[] s={"男","女"};


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mine, container, false);

        Tname=view.findViewById(R.id.Tname);
        Ttel=view.findViewById(R.id.Ttel);
        Tcollege=view.findViewById(R.id.Tcollege);

        Tesx=view.findViewById(R.id.Tsex);
        arrayAdapter=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,s);
        Tesx.setAdapter(arrayAdapter);


        submit=view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeaInsert();

            }
        });

        return view;
    }

    public void TeaInsert(){
        String name=Tname.getText().toString();
        String sex=Tesx.getSelectedItem().toString();
        String tel=Ttel.getText().toString();
        String college=Tcollege.getText().toString();


    }

}
