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

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION_CODES;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.camera.core.CameraSelector;

import com.example.sztangli.widgedemo.barcode.camerra.CameraSource.*;
import com.google.android.gms.common.images.Size;
import com.google.common.base.Preconditions;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.vision.objects.ObjectDetectorOptionsBase.DetectorMode;
import com.google.mlkit.vision.objects.custom.CustomObjectDetectorOptions;
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions;


/**
 * Utility class to retrieve shared preferences.
 */
public class PreferenceUtils {

    private static final int POSE_DETECTOR_PERFORMANCE_MODE_FAST = 1;

    static void saveString(Context context, @StringRes int prefKeyId, @Nullable String value) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(context.getString(prefKeyId), value)
                .apply();
    }


    @RequiresApi(VERSION_CODES.LOLLIPOP)
    @Nullable
    public static android.util.Size getCameraXTargetResolution(Context context, int lensfacing) {
        Preconditions.checkArgument(
                lensfacing == CameraSelector.LENS_FACING_BACK
                        || lensfacing == CameraSelector.LENS_FACING_FRONT);
        String prefKey =
                lensfacing == CameraSelector.LENS_FACING_BACK
                        ? "crctas"
                        : "cfctas";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return android.util.Size.parseSize(sharedPreferences.getString(prefKey, null));
        } catch (Exception e) {
            return null;
        }
    }


    public static CustomObjectDetectorOptions getCustomObjectDetectorOptionsForLivePreview(
            Context context, LocalModel localModel) {
        return getCustomObjectDetectorOptions(
                context,
                localModel,
                "lpodemo",
                "lpodec",
                CustomObjectDetectorOptions.STREAM_MODE);
    }


    private static CustomObjectDetectorOptions getCustomObjectDetectorOptions(
            Context context,
            LocalModel localModel,
            String prefKeyForMultipleObjects,
            String prefKeyForClassification,
            @DetectorMode int mode) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        boolean enableMultipleObjects =
                sharedPreferences.getBoolean(prefKeyForMultipleObjects, false);
        boolean enableClassification =
                sharedPreferences.getBoolean(prefKeyForClassification, true);

        CustomObjectDetectorOptions.Builder builder =
                new CustomObjectDetectorOptions.Builder(localModel).setDetectorMode(mode);
        if (enableMultipleObjects) {
            builder.enableMultipleObjects();
        }
        if (enableClassification) {
            builder.enableClassification().setMaxPerObjectLabelCount(1);
        }
        return builder.build();
    }

    private PreferenceUtils() {
    }
}
