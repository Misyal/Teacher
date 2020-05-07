package com.example.teacher.Teacher.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.teacher.R;
import com.example.teacher.database.CourseHelper;
import java.util.List;


public class SignFragment extends Fragment implements View.OnClickListener,View.OnTouchListener {
    private Button creatsign,checksign;
    private Spinner tcourse;
    private ListView signsheet;
    private String Tnum;

    private CourseHelper cHelper;
    private SQLiteDatabase sqLiteDatabase;

    private ArrayAdapter<String> adapter;
    private String[] course;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sign,container,false);

        creatsign=view.findViewById(R.id.creatsign);
        creatsign.setOnClickListener(this);
        checksign=view.findViewById(R.id.checksign);
        checksign.setOnClickListener(this);
        signsheet=view.findViewById(R.id.signsheet);
        Tnum=getActivity().getIntent().getStringExtra("教师账号");

        tcourse=view.findViewById(R.id.course);


        return view;
    }




    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.creatsign){

        }
        if(v.getId()==R.id.checksign){

        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId()==R.id.course){
            cHelper=new CourseHelper(getActivity(),"user.db",null,1);
            sqLiteDatabase=cHelper.getReadableDatabase();
            List <String> coursadapter =cHelper.qCourse(sqLiteDatabase,Tnum);
            course=coursadapter.toArray(new String[coursadapter.size()]);
            adapter=new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,course);
            tcourse.setAdapter(adapter);

        }
        return false;
    }
}
