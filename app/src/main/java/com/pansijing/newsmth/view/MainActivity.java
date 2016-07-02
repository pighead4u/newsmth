package com.pansijing.newsmth.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.pansijing.newsmth.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMain {

    @BindView(R.id.content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void getTop10Success(String data) {
        tvContent.setText(data);
    }

    @Override
    public void getTop10Failed(String data) {
        tvContent.setText(data);
    }
}
