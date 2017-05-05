package com.pansijing.newsmth.util;

import android.support.annotation.NonNull;

import com.pansijing.newsmth.model.bean.Top10;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 16/7/2-下午1:00.
 * @email: zhuhuanhuan@hotmail.com
 * @desc: 把html页面的内容转成Java bean
 */
public final class JSoupManager {

    private static final String TAG = JSoupManager.class.getSimpleName();

    private JSoupManager() {
    }

    public static List<Top10> convert2Top10(@NonNull String data) {
        List<Top10> top10List = new ArrayList<>(10);
        Elements elements = Jsoup.parse(data).select("a[href]");

        for (Element element : elements) {
            String link = element.attr("href");
            if (link.contains("article")) {
                Top10 top10 = new Top10();
                top10.title = element.ownText().substring(0, element.ownText().length() - 2);
                top10.url = link;
                top10.countOfComment = Integer.parseInt(element.select("span").text());
                top10List.add(top10);
            }
        }

        return top10List;
    }
}
