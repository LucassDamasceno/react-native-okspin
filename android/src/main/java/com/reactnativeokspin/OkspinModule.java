package com.reactnativeokspin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.spin.ok.gp.OkSpin;
import com.spin.ok.gp.utils.Error;

@ReactModule(name = OkspinModule.NAME)
public class OkspinModule extends ReactContextBaseJavaModule {

    public static final String NAME = "Okspin";

    public OkspinModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }


  private void sendEvent(ReactContext reactContext,
                         String eventName,
                         @Nullable WritableMap params) {
    reactContext
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(eventName, params);
  }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    // Example method
    // See https://reactnative.dev/docs/native-modules-android

    @ReactMethod
    public void initSDK(String appKey, String userId) {
      OkSpin.setListener(new OkSpin.SpinListener() {
        @Override
        public void onInitSuccess() {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onInitSuccess", params);
        }

        @Override
        public void onInitFailed(Error error) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onInitFailed", params);
        }

        @Override
        public void onIconReady(String s) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onIconReady", params);
        }

        @Override
        public void onIconLoadFailed(String s, Error error) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onIconLoadFailed", params);
        }

        @Override
        public void onIconShowFailed(String s, Error error) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onIconShowFailed", params);
        }

        @Override
        public void onIconClick(String s) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onIconClick", params);
        }

        @Override
        public void onInteractiveOpen(String s) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onInteractiveOpen", params);
        }

        @Override
        public void onInteractiveOpenFailed(String s, Error error) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onInteractiveOpenFailed", params);
        }

        @Override
        public void onInteractiveClose(String s) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onInteractiveClose", params);
        }

        @Override
        public void onOfferWallOpen(String placementId) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onOfferWallOpen", params);
          //
        }

        @Override
        public void onOfferWallOpenFailed(String s, Error error) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onOfferWallOpenFailed", params);
        }

        @Override
        public void onOfferWallClose(String s) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onOfferWallClose", params);
        }

        @Override
        public void onUserCenterOpen(String s) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onUserCenterOpen", params);
        }

        @Override
        public void onUserCenterOpenFailed(String s, Error error) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onUserCenterOpenFailed", params);
        }

        @Override
        public void onUserCenterClose(String s) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onUserCenterClose", params);
        }

        @Override
        public void onUserInteraction(String s, String s1) {
          WritableMap params = Arguments.createMap();
          params.putBoolean("value", true);
          sendEvent(getReactApplicationContext(), "onUserInteraction", params);
        }
      });
      if (userId != null) OkSpin.setUserId(userId);
      OkSpin.initSDK(appKey);

    }


  @ReactMethod
    public void show(String placementId) {
        OkSpin.openOfferWall(placementId);
        OkSpin.setForegroundEnable(true);
    };
}
