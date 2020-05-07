package com.example.teacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.teacher.Manager.ManagerActivity;
import com.example.teacher.Teacher.TeacherActivity;
import com.example.teacher.database.TeacherHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton teacher,manager;
    private CheckBox ck_remember;
    private Button btnlogin;
    private TextView tnum,tpassword;
    private boolean bRemember = true; // 是否记住密码
    private SharedPreferences mShare1,mShare2;// 声明共享参数对象

    private TeacherHelper THelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin=findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(this);
        tnum=findViewById(R.id.et_Tnum);
        tpassword=findViewById(R.id.et_password);
        teacher=findViewById(R.id.rb_teacher);
        manager=findViewById(R.id.rb_manager);
        ck_remember = findViewById(R.id.ck_remember);
        ck_remember.setOnCheckedChangeListener(new CheckListener());

        mShare1=getSharedPreferences("Teacher",MODE_PRIVATE);
        String TeaNum=mShare1.getString("教师账号","");
        String TeaPwd=mShare1.getString("教师密码","");
        tnum.setText(TeaNum);
        tpassword.setText(TeaPwd);

        mShare2=getSharedPreferences("Manager",MODE_PRIVATE);
        String ManNum=mShare1.getString("管理员账号","");
        String ManPwd=mShare1.getString("管理员密码","");
        tnum.setText(ManNum);
        tpassword.setText(ManPwd);
    }


    private class CheckListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId() == R.id.ck_remember) {
                bRemember = isChecked;
            }
        }
    }


    @Override
    public void onClick(View v) {
        String Id=tnum.getText().toString();
        String Pwd=tpassword.getText().toString();
        THelper=new TeacherHelper(this,"uesr.db",null,1);
        sqLiteDatabase=THelper.getReadableDatabase();
        if(v.getId()==R.id.btn_login){
            if(teacher.isChecked()){

                int  Result=THelper.qureyId(sqLiteDatabase,Id,Pwd);
                if(Result==1) {
                    String TeaNum=Id;
                    Intent intent = new Intent(this, TeacherActivity.class);
                    intent.putExtra("教师账号", TeaNum);
                    startActivity(intent);
                    this.finish();
                }else
                    {
                    Toast.makeText(this,"密码错误",Toast.LENGTH_LONG).show();
                    }
            }
            if(manager.isChecked()){
                if(Id.equals("999999")&&Pwd.equals("999999")) {
                    String ManNum=Id;
                    Intent intent = new Intent(this, ManagerActivity.class);
                    intent.putExtra("管理员账号", ManNum);
                    startActivity(intent);
                    this.finish();
                }else {
                    Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
                }
            }
        }
        if (bRemember) {
            if(teacher.isChecked()) {

                SharedPreferences.Editor editor = mShare1.edit();
                editor.putString("教师账号", Id);
                editor.putString("教师密码", Pwd);
                editor.commit();//提交内容
            }
            if(manager.isChecked()){
                SharedPreferences.Editor editor = mShare2.edit();
                editor.putString("管理员账号", Id);
                editor.putString("管理员密码", Pwd);
                editor.commit();//提交内容
                }
        }
    }

}

