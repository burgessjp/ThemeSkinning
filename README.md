
##Android 主题换肤的开源库（插件化换肤）

本开源库是基于我之前的一个博客 [Android主题换肤 无缝切换](www.jianshu.com/p/af7c0585dd5b) 不知道原理的可以去这篇博客看看。
为了方便使用我将其抽取出来，作为一个模块。

效果图如下：

![](app/capture/GIF.gif)

使用方法：

1. 添加依赖<code> compile 'com.solid.skin:skinlibrary:1.0.0'</code>

1. 让你的Application继承于SkinBaseApplication

2. 让你的Activity继承于SkinBaseActivity，如果使用了Fragment则继承于SkinBaseFragment

3. 在需要换肤的根布局上添加 <code>xmlns:skin="http://schemas.android.com/android/skin" </code>，然后在需要换肤的View上加上 <code>skin:enable="true"</code>

4. 新建一个项目模块（只包含有资源文件），其中包含的资源文件的name一定要和原项目中有换肤需求的View所使用的资源name一致。

5. 打包皮肤文件，放入assets中的skin目录下

6. 调用换肤

```html
  SkinManager.getInstance().loadSkin("Your skin file name in assets",
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


使用注意事项：

1. 默认不支持状态栏颜色的更改，如果需要换肤的同时也要更改状态栏颜色，请到您的Application文件中加入<code>SkinConfig.setCanChangeStatusColor(true);</code>，布局文件中的根布局一定要加上 **android:fitsSystemWindows="true"**

2. 本开源库使用的Activity是AppCompatActivity，使用的Fragment是android.support.v4.app.Fragment

3. 有换肤需求View所使用的资源一定要是引用值，例如：@color/red，而不是#ff0000







LICENSE

```html
Copyright [2015] [FENGJUN]

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
