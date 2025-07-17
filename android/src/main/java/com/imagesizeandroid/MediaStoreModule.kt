package com.imagesize

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.facebook.react.bridge.*

class MediaStoreModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String = "MediaStoreModule"

  @ReactMethod
  fun getImageSize(uriString: String, promise: Promise) {
    try {
      val uri = Uri.parse(uriString)
      val resolver: ContentResolver = reactApplicationContext.contentResolver
      val projection = arrayOf(
        MediaStore.Images.Media.WIDTH,
        MediaStore.Images.Media.HEIGHT
      )
      val cursor: Cursor? = resolver.query(uri, projection, null, null, null)
      cursor?.use {
        if (it.moveToFirst()) {
          val width = it.getInt(it.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH))
          val height = it.getInt(it.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT))
          val map = Arguments.createMap()
          map.putInt("width", width)
          map.putInt("height", height)
          promise.resolve(map)
          return
        }
      }
      promise.reject("NO_DATA", "No image data found for given URI.")
    } catch (e: Exception) {
      promise.reject("ERROR", e.message)
    }
  }
}