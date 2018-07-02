package net.cryallen.androidlib.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO流工具类
 * Created by chenran on 2017/8/31.
 *
 */
public class IOUtils {
    /**
     * 关闭流
     */
    public static boolean close(Closeable io) {
        if (io != null) {
            try {
                io.close();
            } catch (IOException e) {
                LogUtils.e(e);
            }
        }
        return true;
    }
}
