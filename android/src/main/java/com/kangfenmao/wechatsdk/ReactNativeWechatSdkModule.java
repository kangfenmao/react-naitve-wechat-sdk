package com.kangfenmao.wechatsdk;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbiz.WXOpenCustomerServiceChat;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

@ReactModule(name = ReactNativeWechatSdkModule.NAME)
public class ReactNativeWechatSdkModule extends ReactContextBaseJavaModule {
  public static final String NAME = "ReactNativeWechatSdk";
  private ReactApplicationContext reactContext;
  private String appId;
  private IWXAPI api;

  public ReactNativeWechatSdkModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void init(ReadableMap config, Promise promise) {
    this.appId = config.getString("appId");
    api = WXAPIFactory.createWXAPI(this.reactContext, appId, true);
    if (api.registerApp(appId)) {
      promise.resolve(Response.success("Init success"));
    } else {
      promise.reject(String.valueOf(Response.ERROR_CREATE_WX_API), "Init failure");
    }
  }

  @ReactMethod
  public void openCustomerServiceChat(ReadableMap config, Promise promise) {
    IWXAPI api = WXAPIFactory.createWXAPI(this.reactContext, this.appId);
    String corpId = config.getString("corpId");
    String url = config.getString("url");

    // 判断当前版本是否支持拉起客服会话
    if (api.getWXAppSupportAPI() >= Build.SUPPORT_OPEN_CUSTOMER_SERVICE_CHAT) {
      WXOpenCustomerServiceChat.Req req = new WXOpenCustomerServiceChat.Req();
      req.corpId = corpId;  // 企业ID
      req.url = url;	// 客服URL
      api.sendReq(req);
      promise.resolve(Response.success("Open customer service success"));
      return;
    }

    Log.d("sdk", String.valueOf(api.getWXAppSupportAPI()) + "-" + String.valueOf(Build.SUPPORT_OPEN_CUSTOMER_SERVICE_CHAT));

    promise.reject(String.valueOf(Response.ERROR_SDK_VERSION_NOT_SUPPORTED), "当前版本不支持拉起客服会话");
  }

  public static native int nativeMultiply(int a, int b);
}
