package solid.ren.skinlibrary.base;

import android.app.Application;

import java.io.File;
import java.io.IOException;

import solid.ren.skinlibrary.config.SkinConfig;
import solid.ren.skinlibrary.load.SkinManager;
import solid.ren.skinlibrary.utils.SkinFileUtils;
import solid.ren.skinlibrary.utils.L;


/**
 * Created by _SOLID
 * Date:2016/4/14
 * Time:10:54
 */
public class SkinBaseApplication extends Application {

    public void onCreate() {
        super.onCreate();

        initSkinLoader();
    }

    /**
     * Must call init first
     */
    private void initSkinLoader() {
        setUpSkinFile();
        SkinManager.getInstance().init(this);
        SkinManager.getInstance().loadSkin();
    }

    private void setUpSkinFile() {
        try {
            String[] skinFiles = getAssets().list(SkinConfig.SKIN_DIR_NAME);
            for (String fileName : skinFiles) {
                L.i("fileName", fileName);
                SkinFileUtils.copySkinAssertToDir(this, SkinConfig.SKIN_DIR_NAME + File.separator + fileName, SkinFileUtils.getCacheDir(this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
