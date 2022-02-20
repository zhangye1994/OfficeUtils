package com.ye.office.netWork;

import java.util.Map;

/**
 * author : zhangye
 * date   : 2022-2022-19
 * desc   : Http请求超类
 */
public interface HttpHelper {
    void downloadFile(String url, Map<String,String> params,String method);
}
