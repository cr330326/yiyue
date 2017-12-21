package net.cryallen.androidlib.module;

/**
 * 组件模块信息描述类
 * Created by chenran3 on 2017/12/12.
 */

public class ModuleInfo {
    private String moduleName;
    private String packageName;

    public ModuleInfo() {}

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
