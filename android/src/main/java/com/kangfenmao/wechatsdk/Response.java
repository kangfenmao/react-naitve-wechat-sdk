package com.kangfenmao.wechatsdk;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class Response {
  public static final int SUCCESS = 200;
  public static final int ERROR = 500;
  public static final int ERROR_SDK_VERSION_NOT_SUPPORTED = 501;
  public static final int ERROR_CREATE_WX_API = 502;

  public static WritableMap success(String message) {
    WritableMap response = Arguments.createMap();
    response.putInt("code", Response.SUCCESS);
    response.putString("message", message);
    return response;
  }
}
