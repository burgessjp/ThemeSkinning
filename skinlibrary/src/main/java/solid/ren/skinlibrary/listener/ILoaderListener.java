package solid.ren.skinlibrary.listener;

/**
 * <p>
 * Created by _SOLID
 * Date:2016/4/13
 * Time:21:07
 * </p>
 * 加载皮肤时的回调接口
 */
public interface ILoaderListener {
    void onStart();

    void onSuccess();

    void onFailed(String errMsg);

    /**
     * 当从网络上加载皮肤文件是此方法会被调用
     *
     * @param progress 下载进度
     */
    void onProgress(int progress);
}
