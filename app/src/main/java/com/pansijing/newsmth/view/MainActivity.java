package com.pansijing.newsmth.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.pansijing.newsmth.R;
import com.pansijing.newsmth.presentor.MainPresentor;

public class MainActivity extends AppCompatActivity implements IMain {
  private static final String TAG = "MainActivity";

  MainPresentor mMainPresentor;
  Button btn;
  TextView tvContent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
    mMainPresentor = new MainPresentor(this);
  }

  void initView() {
    btn = (Button) findViewById(R.id.btn);
    tvContent = (TextView) findViewById(R.id.content);

    btn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Log.e(TAG, "fetchTopData: ");
        mMainPresentor.getTop10();
      }
    });
  }

  @Override public void getTop10Success(String data) {
    tvContent.setText(data);
  }

  @Override public void getTop10Failed(String data) {
    tvContent.setText(data);
  }
}
