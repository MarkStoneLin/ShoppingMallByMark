package com.example.a.shoppingmallbymark.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.a.shoppingmallbymark.R;
import com.example.a.shoppingmallbymark.base.BaseFragment;
import com.example.a.shoppingmallbymark.community.fragment.CommunityFragment;
import com.example.a.shoppingmallbymark.home.fragment.HomeFragment;
import com.example.a.shoppingmallbymark.shoppingcat.fragment.ShoppingCartFragment;
import com.example.a.shoppingmallbymark.type.fragment.TypeFragment;
import com.example.a.shoppingmallbymark.user.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity {


    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;

    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    private ArrayList<BaseFragment> fragments;//装多个fragment实例集合

    private int position = 0;

    private Fragment tempFragemnt;//缓存的fragment()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //学会使用butterKnife
        ButterKnife.bind(this);

        initFragment();//初始化Fragment
        initListener();
        //通过实例化设置首页为首页
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;
                    case R.id.rb_type:
                        position = 1;
                        break;
                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_community:
                        position = 2;
                        break;
                    default:
                        position = 0;
                        break;
                }
                // 根据不同的位置取fragment
                BaseFragment baseFragment = getFragment(position);
                switchFragment(tempFragemnt, baseFragment);
            }
        });

        rgMain.check(R.id.rb_home);
    }


    /**
     * purpose:初始化
     * Note:添加的时候要按照顺序
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingCartFragment());
        fragments.add(new UserFragment());
    }

    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    /**
     * purpose:切换fragment
     * Note:
     */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {

        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
}
