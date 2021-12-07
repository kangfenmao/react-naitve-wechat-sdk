import * as React from 'react'
import { Button, StyleSheet, View } from 'react-native'
import WechatSDK from '@kangfenmao/react-native-wechat-sdk'
import ENV from '../app.json'

export default function App() {
  const init = async () => {
    try {
      const response = await WechatSDK.init({ appId: ENV.wx_app_id })
      console.log(response)
    } catch (error: any) {
      console.log(error?.code, error?.message)
    }
  }

  const customerService = async () => {
    try {
      const response = await WechatSDK.openCustomerServiceChat({
        corpId: ENV.wx_corp_id,
        url: ENV.wx_kf_url
      })
      console.log(response)
    } catch (error: any) {
      console.log(error?.code, error?.message)
    }
  }

  return (
    <View style={styles.container}>
      <Button title="初始化" onPress={init} />
      <Button title="打开客服会话" onPress={customerService} />
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20
  }
})
