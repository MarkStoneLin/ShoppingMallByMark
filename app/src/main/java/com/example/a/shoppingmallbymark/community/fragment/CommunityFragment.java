package com.example.a.shoppingmallbymark.community.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.a.shoppingmallbymark.base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * Created by A on 2018/4/20.
 */



public class CommunityFragment extends BaseFragment {

    private TextView textView;
    /*
    * 父类为抽象类，子类必须强制实现该方法
    * */
    @Override
    public View initView() {
        Log.e(TAG ,"主页面的Fragment的UI被初始化了" );
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initDate() {
        Log.e(TAG ,"主页面的Fragment的数据被初始化了" );
        super.initDate();
        textView.setText("发现栏内容");
    }
}
