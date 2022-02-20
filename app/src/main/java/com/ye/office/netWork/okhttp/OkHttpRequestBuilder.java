
package com.ye.office.netWork.okhttp;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * author : zhangye date : 2022-2022-20 desc : OkHttp请求类
 */
public class OkHttpRequestBuilder {
    private final Map<String, String> mHeader = new HashMap<>(0);
    private final Map<String, String> mParameters = new HashMap<>(0);
    private ContentType mContentType = ContentType.MEDIA_TYPE_JSON_UTF8;

    /**
     * 添加请求头
     *
     * @param key 请求头的键
     * @param value 请求头的值
     * @return 请求构建者
     */
    public OkHttpRequestBuilder addHeader(String key, String value) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            mHeader.put(key, value);
        }
        return this;
    }

    /**
     * 添加请求头
     *
     * @param headers 请求头集合
     * @return 请求构建者
     */
    public OkHttpRequestBuilder addHeader(Map<String, String> headers) {
        if (headers == null || headers.containsKey(null) || headers.containsValue(null)) {
            return this;
        }
        mHeader.putAll(headers);
        return this;
    }

    public OkHttpRequestBuilder setContentType(ContentType contentType) {
        mContentType = contentType;
        return this;
    }

    public OkHttpRequestBuilder addParams(ContentType contentType) {
        mContentType = contentType;
        return this;
    }

    public Request build() {
        return new Request.Builder().headers(Headers.of(mHeader))
                .post(RequestBody.create(mContentType.getValue(), JSON.toJSONString(mParameters)))
                .build();
    }
}
