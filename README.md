# @kangfenmao/react-native-wechat-sdk

Wechat SDK for React Native

## 安装

```sh
npm install @kangfenmao/react-native-wechat-sdk
```

## 使用

```js
import WechatSDK from "@kangfenmao/react-native-wechat-sdk";
```

## 示例

[Example Code](example/src/App.tsx)

## API

#### 初始化

```js
WechatSDK.init({ appId: '' })
```

#### 微信客服

```js
WechatSDK.openCustomerServiceChat({
  corpId: '',
  url: ''
})
```

## 参与贡献

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## 协议

MIT
