package com.example.a.shoppingmallbymark.shoppingcat.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.shoppingmallbymark.base.BaseFragment;
import com.example.a.shoppingmallbymark.home.bean.GoodsBean;
import com.example.a.shoppingmallbymark.shoppingcat.utils.CartStorage;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by A on 2018/4/20.
 */



public class ShoppingCartFragment extends BaseFragment {

    private TextView textView;
    /*
    * 父类为抽象类，子类必须强制实现该方法
    * */
    @Override
    public View initView() {
        Log.e(TAG ,"购物车的Fragment的UI被初始化了" );
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initDate() {
        Log.e(TAG ,"购物车的Fragment的数据被初始化了" );
        super.initDate();


        textView.setText("购物车内容");

        List<GoodsBean> goodsBeanList = CartStorage.getInstance().getAllData();
        for(int i = 0;i<goodsBeanList.size();i++){
            Log.e("TAG",goodsBeanList.get(i).toString());
        }
    }
}
