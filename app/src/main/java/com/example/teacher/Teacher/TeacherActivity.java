package com.example.teacher.Teacher;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.teacher.R;
import com.example.teacher.Teacher.Fragment.CourageFragment;
import com.example.teacher.Teacher.Fragment.MineFragment;
import com.example.teacher.Teacher.Fragment.SignFragment;

public class TeacherActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout Sign,Courage,Mine;
    private String TeaNum;
    private TextView tv;
    private SignFragment signFragment;
    private CourageFragment courageFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        tv=findViewById(R.id.title);

        Sign=findViewById(R.id.sign);
        Sign.setOnClickListener(this);
        Courage=findViewById(R.id.courage);
        Courage.setOnClickListener(this);
        Mine=findViewById(R.id.Mine);
        Mine.setOnClickListener(this);
        TeaNum=getIntent().getStringExtra("教师账号");

        signFragment=new SignFragment();
        courageFragment=new CourageFragment();
        mineFragment =new MineFragment();

        Bundle bundle=new Bundle();
        bundle.putString("教师账号",TeaNum);
        signFragment.setArguments(bundle);
        courageFragment.setArguments(bundle);
        mineFragment.setArguments(bundle);
        tv.setText("签到");
        replaceFragment(signFragment);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragShow,fragment);
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign) {
            tv.setText("签到");
            replaceFragment(signFragment);

        } else if (v.getId() == R.id.courage) {
            tv.setText("");
            replaceFragment(courageFragment);
        } else if (v.getId() == R.id.Mine) {
            tv.setText("我的");
            replaceFragment(mineFragment);
        }

    }
}
