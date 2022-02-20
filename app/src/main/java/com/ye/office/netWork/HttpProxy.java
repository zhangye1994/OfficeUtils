package com.ye.office.netWork;

import java.util.Map;

/**
 * author : zhangye
 * date   : 2022-2022-20
 * desc   : Http请求代理类
 */
public class HttpProxy implements HttpHelper {
    HttpHelper mHttpHelper;

    public HttpProxy(HttpHelper httpHelper) {
        mHttpHelper = httpHelper;
    }

    @Override
    public void downloadFile(String url, Map<String, String> params, String method) {
        if(mHttpHelper == null){
            throw new NullPointerException("You must ensure that mHttpHelper is not empty");
        }
        mHttpHelper.downloadFile(url, params, method);
    }
}
