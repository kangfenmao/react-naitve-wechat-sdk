# @kangfenmao/react-native-wechat-sdk

Wechat SDK for React Native

## 开发路线

本项目正在开发过程中，暂不可使用

- [ ] 初始化
- [ ] 微信登陆
- [ ] 微信支付
- [ ] 微信分享
- [ ] 微信收藏
- [ ] APP拉起微信客服功能
- [ ] APP拉起微信客服功能

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
