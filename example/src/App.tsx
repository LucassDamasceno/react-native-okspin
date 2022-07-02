import * as React from 'react';

import { StyleSheet, View, Button } from 'react-native';
import { show, initSDK } from 'react-native-okspin';

export default function App() {
  return (
    <View style={styles.container}>
      <Button
        title="teste"
        onPress={() => {
          initSDK({ appKey: 'asdf', userId: '' });
          show('placementId');
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
