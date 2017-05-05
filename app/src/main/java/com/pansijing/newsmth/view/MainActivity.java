package com.pansijing.newsmth.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.pansijing.newsmth.R;
import com.pansijing.newsmth.presentor.MainPresentor;

public class MainActivity extends AppCompatActivity implements IMain {
  private static final String TAG = "MainActivity";

  MainPresentor mMainPresentor;
  @BindView(R.id.btn) Button btn;
  @BindView(R.id.content) TextView tvContent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    mMainPresentor = new MainPresentor(this);
  }

  @OnClick(R.id.btn) void fetchTopData() {
    Log.e(TAG, "fetchTopData: ");
    mMainPresentor.getTop10();
  }

  @Override public void getTop10Success(String data) {
    tvContent.setText(data);
  }

  @Override public void getTop10Failed(String data) {
    tvContent.setText(data);
  }

  @OnClick(R.id.btn) public void onViewClicked() {
  }
}
