# 📸 react-native-image-size-android

A simple React Native native module for retrieving **accurate image dimensions** (width & height) from `content://` URIs on **Android** devices using the `MediaStore` API.

> ✅ Android only  
> ❌ Not compatible with iOS

---

## 🚀 Features

- 🔍 Retrieve image size from Android `MediaStore`
- ⚡ Works with `content://` URIs (e.g. selected images from gallery)
- 📦 Lightweight and easy to use
- 🔧 Written in Kotlin + TypeScript
- 💬 Fully typed API

---

## 📦 Installation

Using npm:

```sh
npm install react-native-image-size-android
```
```sh
yarn add react-native-image-size-android
```
## Usage


```js
import { getImageSize } from 'react-native-image-size-android';

type ImageSize = {
  width: number;
  height: number;
};

const uri = 'content://media/external/images/media/123';

try {
  const size = await getImageSize(uri);
  console.log('Image size:', size.width, size.height);
} catch (error) {
  console.error('Failed to get image size:', error);
}
```

## License

MIT © Görkem Başaran

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
