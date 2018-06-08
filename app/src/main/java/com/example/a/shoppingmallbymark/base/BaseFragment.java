package com.example.a.shoppingmallbymark.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by A on 2018/4/20.
 * <p>
 * 首页：HomeFragment
 * 分类：TypeFragment
 * 发现：CommunityFragment
 * 购物车：ShoppingCartFragment
 * 用户中心：UserFragemnt
 * 都要继承该类
 */
//test git

public abstract class BaseFragment extends Fragment {


    protected Context mContext;
    /*
    * 被创建时回调
    * */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    /**
     * 当视图被创建的时候，回调
    * 让子类去做，所以返回抽象initView
    * */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }/**/

    public abstract View initView();//抽象类，由孩子去实现，实现不同的效果

    /*
    * 当Activity被创建的时候回调这个方法
    * */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    /*
    * 当子类需要联网请求数据的时候，可以重写该方法，在该方法中联网请求
    * */
    public void initDate(){

    }
}
