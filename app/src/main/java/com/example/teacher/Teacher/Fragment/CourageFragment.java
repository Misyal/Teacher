package com.example.teacher.Teacher.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.example.teacher.R;


import java.util.Calendar;

public class CourageFragment extends Fragment implements View.OnTouchListener {


    private EditText Cname,Ctimebegin,Ctimeend;
    private Spinner Cfool,Croom;
    private Button addc;
    private ListView Clist;

    private ArrayAdapter<String> arrayAdapter1;
    private String[] fool={"1号","2号","3号"};

    String Fool;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_courage,container,false);
        Cname=view.findViewById(R.id.Cname);
        Ctimebegin=view.findViewById(R.id.Ctimebegin);
        Ctimebegin.setOnTouchListener(this);
        Ctimeend=view.findViewById(R.id.Ctimeend);
        Ctimeend.setOnTouchListener(this);

        Cfool=view.findViewById(R.id.Cfool);
        Croom=view.findViewById(R.id.Croom);
        arrayAdapter1=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,fool);
        Cfool.setAdapter(arrayAdapter1);
        Cfool.setOnItemSelectedListener(listener);

        Clist=view.findViewById(R.id.Clist);
        addc=view.findViewById(R.id.add);
        addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        return view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View view = View.inflate(getActivity(), R.layout.date_time_dialog, null);
            final DatePicker datePicker = view.findViewById(R.id.date_picker);
            final TimePicker timePicker = view.findViewById(R.id.time_picker);
            builder.setView(view);

            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(System.currentTimeMillis());
            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

            timePicker.setIs24HourView(true);
            timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
            timePicker.setCurrentMinute(Calendar.MINUTE);

            if (v.getId() == R.id.Ctimebegin) {
                final int inType = Ctimebegin.getInputType();
                Ctimebegin.setInputType(InputType.TYPE_NULL);
                Ctimebegin.onTouchEvent(event);
                Ctimebegin.setInputType(inType);
                Ctimebegin.setSelection(Ctimebegin.getText().length());

                builder.setTitle("选取起始时间");
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        sb.append("  ");
                        sb.append(timePicker.getCurrentHour())
                                .append(":").append(timePicker.getCurrentMinute());

                        Ctimebegin.setText(sb);
                        Ctimeend.requestFocus();
                        dialog.cancel();
                    }
                });

            } else if (v.getId() == R.id.Ctimeend) {
                int inType = Ctimeend.getInputType();
                Ctimeend.setInputType(InputType.TYPE_NULL);
                Ctimeend.onTouchEvent(event);
                Ctimeend.setInputType(inType);
                Ctimeend.setSelection(Ctimeend.getText().length());
                builder.setTitle("选取结束时间");
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        sb.append("  ");
                        sb.append(timePicker.getCurrentHour())
                                .append(":").append(timePicker.getCurrentMinute());
                        Ctimeend.setText(sb);

                        dialog.cancel();
                    }
                });
            }
            Dialog dialog = builder.create();
            dialog.show();
        }
        return false;
    }

    OnItemSelectedListener listener = new OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Spinner spinner=(Spinner) parent;
            String pro = (String) spinner.getItemAtPosition(position);//获取当前选中项
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.fool,android.R.layout.simple_spinner_item );
             Fool=Cfool.getSelectedItem().toString();
            if(pro.equals("1号")){
                adapter = ArrayAdapter.createFromResource(getActivity(),R.array.Cplace,android.R.layout.simple_spinner_item);
            }else if(pro.equals("2号")){
                adapter = ArrayAdapter.createFromResource(getActivity(),R.array.Cpalce02,android.R.layout.simple_spinner_item);
            }else if(pro.equals("3号")){
                adapter = ArrayAdapter.createFromResource(getActivity(),R.array.Cpalce03,android.R.layout.simple_spinner_item);

            }
            Croom.setAdapter(adapter);
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };






}
