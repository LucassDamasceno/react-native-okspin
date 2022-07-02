import { NativeEventEmitter, NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-okspin' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const Okspin = NativeModules.Okspin
  ? NativeModules.Okspin
  : new Proxy(
    {},
    {
      get() {
        throw new Error(LINKING_ERROR);
      },
    }
  );

const eventEmitter = new NativeEventEmitter(Okspin);

type EventType = 'onInitSuccess' | 'onInitFailed' | 'onIconReady' | 'onIconLoadFailed' | 'onIconShowFailed' | 'onIconClick' | 'onInteractiveOpen' | 'onInteractiveOpenFailed' | 'onInteractiveClose' | 'onOfferWallOpen' | 'onOfferWallOpenFailed' | 'onOfferWallClose' | 'onUserCenterOpen' | 'onUserCenterOpenFailed' | 'onUserCenterClose' | 'onUserInteraction';

export const addListener = (type: EventType, handler: (value: any) => void) => {
  eventEmitter.addListener(type, handler);
};

export function show(placementId: string): Promise<number> {
  return Okspin.show(placementId);
}

export function initSDK({appKey, userId}: { appKey: string, userId?:string }): void {
  return Okspin.initSDK(appKey, userId);
}
