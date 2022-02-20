
package com.ye.office.netWork;

import com.ye.office.netWork.okhttp.OkHttpRequestBuilder;

import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * author : zhangye date : 2022-2022-20 desc : OkHttp集成类
 */
public class OkHttpHelper implements HttpHelper {
    private static OkHttpHelper mOkHttpHelper = null;
    private static final Object LOCK = new Object();

    /**
     * 饿汉式——双重锁单例
     *
     * @return OkHttpHelper对象
     */
    public static OkHttpHelper getInstance() {
        if (mOkHttpHelper == null) {
            synchronized (LOCK) {
                if (mOkHttpHelper == null) {
                    mOkHttpHelper = new OkHttpHelper();
                }
            }
        }
        return mOkHttpHelper;
    }

    private OkHttpHelper() {
    }

    @Override
    public void downloadFile(String url, Map<String, String> params, String method) {
        OkHttpClient client = new OkHttpClient();
    }
}
