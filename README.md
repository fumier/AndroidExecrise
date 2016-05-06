## AndroidExecrise
Android Execrises,recording the process of android learning.

## 1、Android之Toast
### 知识点
- 参考链接：[http://fumier.github.io/2016/04/08/android-toast/](http://fumier.github.io/2016/04/08/android-toast/)

### 源代码
- 参考链接：[ToastActivity](https://github.com/fumier/AndroidExecrise/blob/master/app/src/main/java/com/example/fumier/androidexecrise/ToastActivity.java)

### 实现结果

![运行结果](https://github.com/fumier/RepManagement/blob/master/Res/images/AndroidExercises/toast1.PNG)

## 2、Android之分享弹窗
### 知识点
- 参考链接：[http://fumier.github.io/2016/05/06/android-intent/](http://fumier.github.io/2016/05/06/android-intent/)

### 实现结果
先说实现结果，再说实现步骤。
![运行结果](https://github.com/fumier/RepManagement/blob/master/Res/images/AndroidExercises/shareDialog.PNG)

### 实现步骤
上图显示的是我们自定义的分享界面。只包括微信、微信朋友圈和微博。
1、将该分享界面看作为一个Activity,首先要进行相应的布局activity_share
2、当点击“分享按钮”时，通过startActivity显示该Activity
3、该Activity的显示方式，通过getWindow()方法返回Window对象，设置当前窗体的显示效果（显示地点，弹出效果，背景色等等）。
在上述实现过程中步骤三的实现过程较为复杂。涉及到两个知识点，一个是弹出窗的theme设置；一个是弹出窗的动画设置。
- 弹出窗的theme设置，一般设置在themes文件中。
```xml
    <style name="ShareDialog" parent="android:style/Theme.Dialog">
        <!--是否显示window的标题栏-->
        <item name="android:windowNoTitle">true</item>
        <!--去掉window的白边-->
        <item name="android:windowFrame">@null</item>
        <!--是否半透明-->
        <item name="android:windowIsTranslucent">true</item>
        <!--设置window的背景-->
        <item name="android:windowBackground">@null</item>
        <!--是否浮于activity之上-->
        <item name="android:windowIsFloating">true</item>
    </style>
```
- 弹出窗的动画设置,一般设置在styles.xml文件中
```xml
    <style name="push_bottom">
        <item name="android:windowEnterAnimation">@anim/push_bottom_in</item>
        <item name="android:windowExitAnimation">@anim/push_bottom_out</item>
    </style>
```
相关代码：[ShareDialogActivity](https://github.com/fumier/AndroidExecrise/blob/master/app/src/main/java/com/example/fumier/androidexecrise/ShareDialogActivity.java)






