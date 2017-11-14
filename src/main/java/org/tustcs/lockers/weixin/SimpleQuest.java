package org.tustcs.lockers.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Airmacx on 2017/11/13.
 */
public class SimpleQuest {
    private static final String APPID="wx7ef05b3ed524ef90";
    private static final String APPSECRET="fc8a4f2c0e35b49422a71f2cb1c8043d";
    private static final String CODE="061uekcy17H7Gg07Drdy1RHYby1uekcr";
    private String openid="o8Sv10NiGBIqk5AN48rcL3CwDERM";

    public static void main(String[] args) throws IOException {
        JSONObject jsonObject= getJson("https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" +APPID+
                "&secret=" +APPSECRET+
                "&js_code=" +CODE+
                "&grant_type=authorization_code");
        System.out.println(jsonObject.getString("openid"));
        System.out.println(jsonObject.getString("session_key"));
    }


    public static JSONObject getJson(String url) throws IOException {
        JSONObject jsonObject=null;
        CloseableHttpClient client= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);
        HttpResponse response=client.execute(httpPost);
        HttpEntity entity=response.getEntity();
        if(entity!=null){
            String result= EntityUtils.toString(entity,"UTF-8");
            jsonObject= JSON.parseObject(result);
        }
        httpPost.releaseConnection();
        return jsonObject;
    }
}
