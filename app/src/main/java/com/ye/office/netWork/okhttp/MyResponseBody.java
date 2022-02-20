package com.ye.office.netWork.okhttp;

import androidx.annotation.Nullable;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/**
 * author : zhangye
 * date   : 2022-2022-19
 * desc   : Http请求超类
 */
public class MyResponseBody extends ResponseBody {

    private Response mResponse;

    public MyResponseBody(Response response) {
        mResponse = response;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return mResponse.body().contentType();
    }

    @Override
    public long contentLength() {
        return mResponse.body().contentLength();
    }

    @Override
    public BufferedSource source() {
        return Okio.buffer(new ForwardingSource(mResponse.body().source()) {
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                return sink.size();
            }
        });
    }

}