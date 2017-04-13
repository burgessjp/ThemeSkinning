[![Download](https://api.bintray.com/packages/solid/maven/theme-skinning/images/download.svg) ](https://bintray.com/solid/maven/theme-skinning/_latestVersion)
[![API](https://img.shields.io/badge/API-9%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=9)

### Android 主题换肤的开源库（插件化换肤）

效果图如下：

![Demo](app/capture/demo.gif)

### 1. 集成步骤：

1. 添加依赖 <code>compile 'com.solid.skin:skinlibrary:latestVersion' </code>

2. 让你的 Application 继承于 SkinBaseApplication

3. 让你的 Activity 继承于 SkinBaseActivity，如果使用了 Fragment 则继承于 SkinBaseFragment

4. 在需要换肤的根布局上添加 <code>xmlns:skin="http://schemas.android.com/android/skin" </code>，然后在需要换肤的View上加上 <code>skin:enable="true" </code>

5. 新建一个项目模块（只包含有资源文件,例如本项目的 skinpackage 模块），其中包含的资源文件的 name 一定要和原项目中有换肤需求的 View 所使用的资源name一致。

6. 拿到上一步生成的文件( ×××.apk )，改名为 ×××.skin，放入 assets 中的 skin 目录下（ skin 目录是自己新建的）

7. 调用换肤

 - 在 <code>assets/skin</code> 文件夹中的皮肤

    ```html
      SkinManager.getInstance().loadSkin("Your skin file name in assets(eg:theme.skin)",
                                    new ILoaderListener() {
                                        @Override
                                        public void onStart() {
                                            Toast.makeText(getApplicationContext(), "正在切换中", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onSuccess() {
                                            Toast.makeText(getApplicationContext(), "切换成功", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onFailed() {
                                            Toast.makeText(getApplicationContext(), "切换失败", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                            );
    ```
 - 皮肤来源于网络

    ```html
    SkinManager.getInstance().loadSkinFromUrl(skinUrl, new ILoaderListener() {
                        @Override
                        public void onStart() {
                            Log.i("ILoaderListener", "正在切换中");
                            dialog.setContent("正在从网络下载皮肤文件");
                            dialog.show();
                        }

                        @Override
                        public void onSuccess() {
                            Log.i("ILoaderListener", "切换成功");
                            dialog.dismiss();
                        }

                        @Override
                        public void onFailed(String errMsg) {
                            Log.i("ILoaderListener", "切换失败:" + errMsg);
                            dialog.setContent("换肤失败:" + errMsg);
                        }

                        @Override
                        public void onProgress(int progress) {
                            Log.i("ILoaderListener", "皮肤文件下载中:" + progress);
                            dialog.setProgress(progress);
                        }
                    });
    ```
详细的使用，请到示例项目中查看


### 2.换肤属性的扩展

本开源库默认支持 textColor 和 background 的换肤。如果你还需要对其他属性进行换肤，那么就需要去自定义了。

那么如何自定义呢？看下面这个例子：

TabLayout大家应该都用过吧。它下面会有一个指示器，当我们换肤的时候也希望这个指示器的颜色也跟着更改。

- 新建一个 TabLayoutIndicatorAttr 继承于 SkinAttr，然后重写 apply 方法。apply 方法在换肤的时候就会被调用

- 代码的详细实现
```html
public class TabLayoutIndicatorAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof TabLayout) {
            TabLayout tl = (TabLayout) view;
            if (RES_TYPE_NAME_COLOR.equals(attrValueTypeName)) {
                int color = SkinResourcesUtils.getColor(attrValueRefId);
                tl.setSelectedTabIndicatorColor(color);
            }
        }
    }
}
```

注：attrValueRefId：就是资源 id。SkinResourcesUtils 是用来获取皮肤包里的资源，这里设置color或者drawable一定要使用本工具类。

- 当上面的工作完成之后，就到我们自己的 Application 的 onCreate 方法中加入<code> SkinConfig.addSupportAttr("tabLayoutIndicator", new TabLayoutIndicatorAttr());</code>

- 最后我们就可以正常使用了，<code>dynamicAddSkinEnableView(tablayout, "tabLayoutIndicator", R.color.colorPrimaryDark);</code>

### 3. 关于字体切换

还是遵守本项目的约定大于配置的原则，所有的字体都放到 assets/fonts 文件夹下

如何切换字体:
<code> SkinManager.getInstance().loadFont("xx.ttf")</code>

关于切换字体需要配置的东西：
如果只是单纯的想要字体切换这个功能。只需<code>集成步骤</code>中的前三步就行了。

**注：字体切换功能默认不开启，需要字体切换功能请在你的Application中加入<code>SkinConfig.setCanChangeFont(true);</code>**

### 4. 其他一些重要的api

1. SkinConfig.isDefaultSkin(context):判断当前皮肤是否是默认皮肤

2. SkinManager.getInstance().restoreDefaultTheme(): 重置默认皮肤

3. dynamicAddView：当动态创建的View也需要换肤的时候,就可以调用 dynamicAddView


---
### 5. 使用注意事项：
1. 换肤默认只支持 android 的常用控件，对于支持库的控件和自定义控件的换肤需要动态添加（例如： <code>dynamicAddSkinEnableView(toolbar, "background", R.color.colorPrimaryDark);</code>），在布局文件中使用<code>skin:enable="true"</code>是无效的。

2. 默认不支持状态栏颜色的更改，如果需要换肤的同时也要更改状态栏颜色，请到您的Application文件中加入<code>SkinConfig.setCanChangeStatusColor(true);</code>，状态栏的颜色值来源于<code>colorPrimaryDark</code>

3. 本开源库使用的 Activity 是 AppCompatActivity，使用的 Fragment 是 android.support.v4.app.Fragment

4. 有换肤需求 View 所使用的资源一定要是引用值，例如：@color/red，而不是 #ff0000


### 6.项目依赖：
1. 'com.android.support:appcompat-v7:25.1.0'
2. 'com.android.support:cardview-v7:25.1.0'
3. 'com.mani:ThinDownloadManager:1.2.5'


### 7.更新日志：

- v1.4.3:由于在开启全局皮肤切换后，过度动画会带来一些问题，在这个版本中删除了过度动画
- v1.4.2:增加对全局应用皮肤方法，若开启则不需要在布局文件中添加 <code>skin:enable="true"</code>
- v1.4.1:增加从指定目录获取drawable的方法
- v1.4.0:
   - 修复[issues9](https://github.com/burgessjp/ThemeSkinning/issues/9)内存泄漏问题
   - 支持 style
   - 解决字体切换内存泄漏问题
   - 支持 mipmap
   - 状态栏颜色切换只支持 5.0 以上版本
   - 增加 debug 开关，方便开发调试
- v1.3.1:优化换字体部分代码
- v1.3.0:增加一键切换字体
- v1.2.1:完善之前版本 View 的创建
- v1.2.0:增加对换肤属性自定义扩展
- v1.1.0:可以直接加载网络上的皮肤文件

### 致谢：

本项目是基于 Android-Skin-Loader 这个开源库改进而来，再次对原作者表示感谢
[Android-Skin-Loader](https://github.com/fengjundev/Android-Skin-Loader)





### LICENSE

```html
Copyright [2016] [_SOLID]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
