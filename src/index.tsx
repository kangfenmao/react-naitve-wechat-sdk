import { NativeModules, Platform } from 'react-native'

export interface WechatSdkResponseType {
  code: number
  value: string
}

export interface InitOptions {
  appId: string
}

export interface CustomerServiceChatOptions {
  url: string
  corpId: string
}

const LINKING_ERROR =
  `The package '@kangfenmao/react-native-wechat-sdk' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n'

const ReactNativeWechatSdk = NativeModules.ReactNativeWechatSdk
  ? NativeModules.ReactNativeWechatSdk
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR)
        }
      }
    )

export function init(options: InitOptions): Promise<WechatSdkResponseType> {
  return ReactNativeWechatSdk.init(options)
}

export function openCustomerServiceChat(
  options: CustomerServiceChatOptions
): Promise<WechatSdkResponseType> {
  return ReactNativeWechatSdk.openCustomerServiceChat(options)
}

export default {
  init,
  openCustomerServiceChat
}
