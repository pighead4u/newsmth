package com.pansijing.newsmth.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;
import com.pansijing.newsmth.R;
import com.pansijing.newsmth.model.bean.Top10;
import com.pansijing.newsmth.presentor.MainPresentor;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMain {
  private static final String TAG = "MainActivity";

  MainPresentor mMainPresentor;

  RecyclerView recyclerView;
  Top10Adapter top10Adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
    initData();
  }

  private void initData() {
    mMainPresentor = new MainPresentor(this);
    mMainPresentor.getTop10();
  }

  void initView() {
    recyclerView = (RecyclerView) findViewById(R.id.main_content);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    top10Adapter = new Top10Adapter();
    recyclerView.setAdapter(top10Adapter);
  }

  @Override public void getTop10Success(List<Top10> data) {
    top10Adapter.setData(data);
  }

  @Override public void getTop10Failed(String data) {

    Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
  }
}
