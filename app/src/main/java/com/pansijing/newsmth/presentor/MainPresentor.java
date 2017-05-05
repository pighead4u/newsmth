package com.pansijing.newsmth.presentor;

import android.util.Log;
import com.pansijing.newsmth.model.bean.Top10;
import com.pansijing.newsmth.util.GsonManager;
import com.pansijing.newsmth.util.HttpManager;
import com.pansijing.newsmth.util.JSoupManager;
import com.pansijing.newsmth.view.IMain;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@hotmail.com
 * @desc 首页
 */
public class MainPresentor {

  private static final String TAG = MainPresentor.class.getSimpleName();

  private IMain iMain;

  public MainPresentor(IMain iMain) {
    this.iMain = iMain;
  }

  public void getTop10() {
    Observable.create(new ObservableOnSubscribe<List<Top10>>() {
      @Override public void subscribe(@NonNull ObservableEmitter<List<Top10>> emitter)
          throws Exception {
        OkHttpClient client = HttpManager.getOKHttpClient();
        Request request = new Request.Builder().url(HttpManager.HOST).build();

        try {
          Response response = client.newCall(request).execute();
          String data = response.body().string();
          List<Top10> top10List = JSoupManager.convert2Top10(data);
          emitter.onNext(top10List);
        } catch (IOException e) {
          Log.e(TAG, "call: " + e);
        }
      }
    })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Top10>>() {
      @Override public void accept(@NonNull List<Top10> s) throws Exception {
            iMain.getTop10Success(s);
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            iMain.getTop10Failed(throwable.toString());
          }
        });
  }
}
