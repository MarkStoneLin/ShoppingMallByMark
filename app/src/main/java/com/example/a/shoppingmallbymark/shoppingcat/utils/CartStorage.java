package com.example.a.shoppingmallbymark.shoppingcat.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;

import com.example.a.shoppingmallbymark.app.MyApplication;
import com.example.a.shoppingmallbymark.home.bean.GoodsBean;
import com.example.a.shoppingmallbymark.utils.CacheUtils;
import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark栋 on 2018/5/6.
 * purpose:
 */

public class CartStorage {

    public static final String JSON_CART = "json_cart";
    private static CartStorage instance;
    private final Context mContext;
    private SparseArray<GoodsBean> sparseArray;

    private CartStorage(Context context) {
        this.mContext = context;
        //把之前存储的数据读取出来
        sparseArray = new SparseArray<>(100);

        listToSparseArray();
    }

    /**
     * purpose:从本地读取的数据加入到sparseArray中
     * Note:
     */
    private void listToSparseArray() {
        List<GoodsBean> goodsBeanList = getAllData();
        //把列表数据转换成SparseArray
        for (int i = 0; i < goodsBeanList.size(); i++) {
            GoodsBean goodsBean = goodsBeanList.get(i);
            sparseArray.put(Integer.parseInt(goodsBean.getProduct_id()), goodsBean);
        }
    }

    //获取本地所有的数据
    public List<GoodsBean> getAllData() {
        List<GoodsBean> goodsBeanList = new ArrayList<>();
        //1.从本地获取
        String json = CacheUtils.getString(mContext, JSON_CART);
        //2.使用Gson转换成列表
        //判断不为空的时候执行
        if (!TextUtils.isEmpty(json)) {
            //把String转换成List
            goodsBeanList = new Gson().fromJson(json, new TypeToken<List<GoodsBean>>() {
            }.getType());
        }
        return goodsBeanList;
    }

    /**
     * purpose:得到购物车实例
     * Note:
     */
    public static CartStorage getInstance() {
        if (instance == null) {
            instance = new CartStorage(MyApplication.getContext());
        }
        return instance;
    }

    /**
     * purpose:添加数据
     * Note:
     */
    public void addData(GoodsBean goodsBean) {
        //1.添加到内存中sparseArray
        //如果当前数据已经存在，就修改成number递增
        GoodsBean tempData = sparseArray.get(Integer.parseInt(goodsBean.getProduct_id()));
        if (tempData != null) {
            //内存中有了这条数据
            tempData.setNumber(tempData.getNumber() + 1);
        } else {
            tempData = goodsBean;
            tempData.setNumber(1);
        }
        sparseArray.put(Integer.parseInt(tempData.getProduct_id()), tempData);

        //2.同步到本地
        saveLocal();
    }

    /**
     * purpose:删除数据
     * Note:
     */
    public void deleData(GoodsBean goodsBean) {
        //1.在内存中删除
        sparseArray.delete(Integer.parseInt(goodsBean.getProduct_id()));
        //2.把内存保存到本地
        saveLocal();
    }

    /**
     * purpose:更新数据
     * Note:
     */
    public void updateDate(GoodsBean goodsBean) {
        //1.内存中更新
        sparseArray.put(Integer.parseInt(goodsBean.getProduct_id()), goodsBean);
        //2.同步到本地
        saveLocal();
    }

    /**
     * purpose:保存数据到本地
     * Note:
     */
    private void saveLocal() {
        //1.sparseArray转换成List
        List<GoodsBean> goodsBeanList = sparseToList();
        //2.把列表转换成String类型
        String json = new Gson().toJson(goodsBeanList);
        //3.把String类型数据保存
        CacheUtils.saveString(mContext,JSON_CART,json);
    }

    private List<GoodsBean> sparseToList() {
        List<GoodsBean> goodsBeanList = new ArrayList<>();
        for (int i = 0; i < sparseArray.size(); i++) {
            GoodsBean goodsBean = sparseArray.valueAt(i);
            goodsBeanList.add(goodsBean);
        }
        return goodsBeanList;
    }

}
