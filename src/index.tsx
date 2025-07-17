import { NativeModules } from 'react-native';

type ImageSize = {
  width: number;
  height: number;
};

const { MediaStoreModule } = NativeModules;

export const getImageSize = (uri: string): Promise<ImageSize> => {
  return MediaStoreModule.getImageSize(uri);
};