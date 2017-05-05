package com.pansijing.newsmth.view;

import com.pansijing.newsmth.model.bean.Top10;
import java.util.List;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@hotmail.com
 * @desc
 */
public interface IMain {

    void getTop10Success(List<Top10> data);

    void getTop10Failed(String data);
}
