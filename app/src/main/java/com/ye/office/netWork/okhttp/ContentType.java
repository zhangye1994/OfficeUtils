package com.ye.office.netWork.okhttp;

import okhttp3.MediaType;

/**
 * author : zhangye
 * date   : 2022-2022-19
 * desc   : Http请求超类
 */
public enum ContentType {

    MEDIA_TYPE_JSON_UTF8(MediaType.parse("application/json; charset=utf-8"));

    private MediaType mediaType;

    ContentType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    MediaType getValue() {
        return mediaType;
    }
}