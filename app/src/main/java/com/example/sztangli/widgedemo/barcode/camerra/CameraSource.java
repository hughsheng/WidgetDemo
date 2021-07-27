/*
 * Copyright 2020 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sztangli.widgedemo.barcode.camerra;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;

import com.google.android.gms.common.images.Size;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * Manages the camera and allows UI updates on top of it (e.g. overlaying extra Graphics or
 * displaying extra information). This receives preview frames from the camera at a specified rate,
 * sending those frames to child classes' detectors / classifiers as fast as it is able to process.
 */
public class CameraSource {
  @SuppressLint("InlinedApi")
  public static final int CAMERA_FACING_BACK = CameraInfo.CAMERA_FACING_BACK;

  @SuppressLint("InlinedApi")
  public static final int CAMERA_FACING_FRONT = CameraInfo.CAMERA_FACING_FRONT;

  public static final int IMAGE_FORMAT = ImageFormat.NV21;
  public static final int DEFAULT_REQUESTED_CAMERA_PREVIEW_WIDTH = 480;
  public static final int DEFAULT_REQUESTED_CAMERA_PREVIEW_HEIGHT = 360;

  private static final String TAG = "MIDemoApp:CameraSource";

}
