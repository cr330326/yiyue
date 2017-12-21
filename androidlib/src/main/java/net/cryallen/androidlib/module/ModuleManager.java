package net.cryallen.androidlib.module;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import net.cryallen.androidlib.base.BaseApplication;
import net.cryallen.androidlib.interfaces.IApplicationDelegate;
import net.cryallen.androidlib.utils.ModuleClassUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 模块管理工具类
 * Created by chenran3 on 2017/12/12.
 */
public class ModuleManager {

    private static final String TAG = "ModuleManager";
    public static final String MODULE_PREFIX = "B_Module_";

    private List<ModuleInfo> moduleInfoList;
    private List<String> packageNameList;
    private List<IApplicationDelegate> appDelegateList;

    private static class ModuleManagerHolder {  //内部静态类单例模式
        private static final ModuleManager sInstance  = new ModuleManager();
    }

    public static ModuleManager getInstance() {
        return ModuleManagerHolder.sInstance;
    }

    private ModuleManager() {
        this.moduleInfoList = new ArrayList();
    }

    public Context getApplicationContext() {
        return BaseApplication.getInstance().getApplicationContext();
    }

    public List<ModuleInfo> getModuleInfoList() {
        return moduleInfoList;
    }

    public List<String> getPackageNameList() {
        return packageNameList;
    }

    public List<IApplicationDelegate> getAppDelegateList() {
        return appDelegateList;
    }

    /**
     *
     * 加载模块信息
     */
    public void loadModule() {
        Context context = getApplicationContext();
        appDelegateList = new ArrayList();
        packageNameList = new ArrayList();
        packageNameList.add(context.getPackageName());

        try {
            AssetManager assetManager = context.getResources().getAssets();
            String[] fileList = assetManager.list("");
            Gson gson = new Gson();
            int fileLength = fileList.length;

            for(int i = 0; i < fileLength; ++i) {
                String fileName = fileList[i];
                if(fileName.startsWith(MODULE_PREFIX)) {
                    ModuleInfo moduleInfo = parseModuleByJson(gson, assetManager.open(fileName));
                    moduleInfoList.add(moduleInfo);
                    packageNameList.add(moduleInfo.getPackageName());
                    CLog.d(TAG, "load Module: " + moduleInfo.getModuleName());
                }
            }
            appDelegateList.addAll(ModuleClassUtils.getObjectsWithInterface(context, IApplicationDelegate.class, packageNameList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 解析json配置文件
     */
    private ModuleInfo parseModuleByJson(Gson gson, InputStream inputStream) {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        ModuleInfo moduleInfo = gson.fromJson(jsonReader, ModuleInfo.class);
        return moduleInfo;
    }
}
