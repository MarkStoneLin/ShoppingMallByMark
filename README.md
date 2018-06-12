# Android商城



## 1.Welcome页面的制作

+ 欢迎页面制作的标准格式

  ```
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_welcome);
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
              finish();
  
          }
      },2000);
  }
  ```





## 2.底部选择器

+ 一组RadioGroup
  + 有好几个RadioButton
  + 需要配置Style.xml，设置颜色、宽高以及选中和未被选中时采用的图片
+ FrameLayout
  + 在RadioGroup上面是FrameLayout





## 3.实例化框架：ButterKnife

+ ButterKnife框架
  + 普通的实例化消耗性能，而ButterKnife非常高效
+ 自动生成Butterknife框架的插件工具
  + 名字叫：Android ButterKnife Zelezny，在settings里面的Plugins里搜索
  + 使用方法：光标在java代码选中想要实例化的xml的名字 --> 左键 --> Generate --> Generate ButterKnife Injection --> 勾选想要生成的代码



## 4.软件分包

+ 一个页面对应的所有的代码的实现在一个包里面
+ 按照功能分包，逻辑非常清楚，团队合作开发便捷，效率提高，便于维护



## 5.BaseFragment--基类Fragment

- 作用：
  - 给fragment画一个基本的框架，继承此fragment的类都需要照葫芦画瓢，按照这个标准去实现
- 本程序的基类fragment
  - 视图--先实现
  - 数据--后实现



## 6.子类Fragment

+ 根据底部选择器，总共有5种fragment，每种fragment在程序一开始就被初始化了，只不过在MainActivity中，通过监听事件，对想要展示的fragment进行选择和隐藏



## 7.主页面的UI设计思路

+ 主页面的布局情况

![img](file:///C:/Users/A/AppData/Local/Temp/msohtmlclip1/01/clip_image001.png) 



















