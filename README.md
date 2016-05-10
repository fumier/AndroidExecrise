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

## intent-filter之data

### 知识点
- 参考链接[http://fumier.github.io/2016/05/07/intent-filter/](http://fumier.github.io/2016/05/07/intent-filter/)


### 源代码
- [IntentFilterActivity](https://github.com/fumier/AndroidExecrise/blob/master/app/src/main/java/com/example/fumier/androidexecrise/IntentFilterActivity.java)
- [MySysActivity](https://github.com/fumier/AndroidExecrise/blob/master/app/src/main/java/com/example/fumier/androidexecrise/MySysActivity.java)
- [Manifest.xml](https://github.com/fumier/AndroidExecrise/blob/master/app/src/main/AndroidManifest.xml)

## android之带进度条的WebView

### 知识点
- 参考链接[http://fumier.github.io/2016/05/10/WebView/](http://fumier.github.io/2016/05/07/intent-filter/)

### 实现步骤
- 定制化一个进度条要悬浮在网页的最上端，如何自定化进度条，当然是参考系统中自带进度条的实现方式。无非是在系统进度条的基础上，改变进度条的style，也就是说自定义的进度条的style。

```xml
 <style name="Widget.ProgressBar.Horizontal.Blue" parent="android:style/Widget.ProgressBar.Horizontal">
        <item name="android:progressDrawable">@drawable/progress_horizontal_blue</item>
 </style>
```
继承Widget.Progress.Horizontal类，然后实现子类，重写progressDrawable的功能。所以我们要重新定义一个drawable文件，如何写，自然是参考Horizontal中子类progressDrawable的写法。使用layer-list相当于ps中的层叠加，进度条由一个背景色和一个表示进度的颜色组成，加入clip标签，表示进度条不断的增长的含义。

```xml
layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@android:id/background">
        <shape>
            <solid android:color="#dcdcde"/>
        </shape>
    </item>

    <item android:id="@android:id/progress">
        <clip>
            <shape>
                <solid android:color="#06B9D1"/>
            </shape>
        </clip>

    </item>

    <item android:id="@android:id/secondaryProgress">
        <clip>
            <shape>
                <solid android:color="#06B9D1"/>
            </shape>
        </clip>

    </item>

</layer-list>
```

### 实现结果
![运行结果](https://github.com/fumier/RepManagement/blob/master/Res/images/AndroidExercises/WebViewWithProgressBar.PNG)

### 参考源码
- [WebViewProgressBarActivity](https://github.com/fumier/AndroidExecrise/blob/master/app/src/main/java/com/example/fumier/androidexecrise/WebViewProgressBarActivity.java)

