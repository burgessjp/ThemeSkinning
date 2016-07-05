package solid.ren.skinlibrary.listener;

/**
 * Created by _SOLID
 * Date:2016/4/13
 * Time:21:07
 * <p>
 * 加载皮肤时的回调接口
 */
public interface ILoaderListener {
    void onStart();

    void onSuccess();

    void onFailed();
}
