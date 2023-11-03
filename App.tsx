import React from 'react';
import {
  SafeAreaView,
  StatusBar,
  Text,
  View,
} from 'react-native';
import { HomeScreen } from './app/modules';
import { ApplicationStyles, Colors } from './app/theme';

function App() {

  return (
    <SafeAreaView style={ApplicationStyles.screenContainer}>
      <StatusBar
        backgroundColor={Colors.white}
        barStyle={"dark-content"}
      />
      <HomeScreen />
    </SafeAreaView>
  );
}

export default App;
