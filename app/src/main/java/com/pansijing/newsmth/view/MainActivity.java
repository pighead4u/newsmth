package com.pansijing.newsmth.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.pansijing.newsmth.R;
import com.pansijing.newsmth.presentor.MainPresentor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMain {

    @BindView(R.id.content)
    TextView tvContent;

    @BindView(R.id.btn)
    Button mBtn;

    MainPresentor mMainPresentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainPresentor = new MainPresentor(this);
        mMainPresentor.getTop10();
    }

    @OnClick(R.id.btn)
    public void getTop10() {
        mMainPresentor.getTop10();
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
