/*
package com.wanny.workease.system.framework_net.rxjava;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import www.wanny.hifoyping.com.framework_basicutils.PreferenceUtil;
import www.wanny.hifoyping.com.framework_care.ContentData;
import www.wanny.hifoyping.com.framework_care.YiPingApplication;

*/
/**
 * 文件名： AddCookieInternal
 * 功能：
 * 作者： wanny
 * 时间： 10:54 2017/5/5
 *//*

public class AddCookieInternal implements Interceptor {
    private Object object;
    private String method;
    public AddCookieInternal(Object object,String method) {
        super();
        this.object = object;
        this.method = method;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        String token = PreferenceUtil.getInstance(YiPingApplication.getContext()).getString("token","");
        builder.addHeader("Token",token);
        if(method.equals("get")){
            builder.addHeader("YPSIGN", ContentData.setGetyiping((LinkedHashMap<String, String>) object));
        }else{
            builder.addHeader("YPSIGN", ContentData.setPostYiping(object));
        }
        return chain.proceed(builder.build());
    }
}
*/
