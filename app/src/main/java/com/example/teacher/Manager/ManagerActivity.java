package com.example.teacher.Manager;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.teacher.Manager.Fragment.AccountFragment;
import com.example.teacher.Manager.Fragment.SeatCodeFragment;
import com.example.teacher.Manager.Fragment.NoticeFragment;
import com.example.teacher.R;


public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout Seat,Notice,Account;
    private SeatCodeFragment seatCodeFragment;
    private NoticeFragment noticeFragment;
    private AccountFragment accountFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        Seat=findViewById(R.id.seat);
        Seat.setOnClickListener(this);
        Notice=findViewById(R.id.notice);
        Notice.setOnClickListener(this);
        Account=findViewById(R.id.account);
        Account.setOnClickListener(this);

        seatCodeFragment=new SeatCodeFragment();
        noticeFragment=new NoticeFragment();
        accountFragment=new AccountFragment();

        replacefragment(seatCodeFragment);

    }

    private void replacefragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragShow1,fragment);
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.seat){
            replacefragment(seatCodeFragment);
        }
        if(v.getId()==R.id.notice){
            replacefragment(noticeFragment);
        }
        if(v.getId()==R.id.account){
            replacefragment(accountFragment);
        }

    }
}
