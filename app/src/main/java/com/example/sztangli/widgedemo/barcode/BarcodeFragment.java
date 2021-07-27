package com.example.sztangli.widgedemo.barcode;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Size;
import android.view.View;

import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;

import com.example.mvvmlibrary.base.data.BaseViewModel;
import com.example.sztangli.widgedemo.barcode.camerra.PreferenceUtils;
import com.example.sztangli.widgedemo.databinding.FragmentBarcodeBinding;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.camera.CameraSourceConfig;
import com.google.mlkit.vision.camera.CameraXSource;
import com.google.mlkit.vision.camera.DetectionTaskCallback;
import com.guyuan.handlein.base.ui.fragment.BaseFragment;
import com.example.sztangli.widgedemo.R;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.RequestCallback;

import java.util.List;
import java.util.Objects;

public class BarcodeFragment extends BaseFragment<FragmentBarcodeBinding, BaseViewModel> {

    private DetectionTaskCallback<List<Barcode>> detectionTaskCallback;
    private CameraXSource cameraXSource;
    private BarcodeScanner barcodeScanner;
    private Size targetResolution;
    private BarcodeScannerOptions options;
    private int lensFacing = CameraSourceConfig.CAMERA_FACING_BACK;
    private CameraSourceConfig.Builder builder;
    public static final String TAG = "BarcodeFragment";

    public static BarcodeFragment newInstance() {

        Bundle args = new Bundle();

        BarcodeFragment fragment = new BarcodeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onResume() {
        super.onResume();
        if (cameraXSource != null) {
            binding.startBtn.setBackgroundColor(getResources().getColor(R.color.red));
            cameraXSource.start();
        } else {
            checkPermission();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (cameraXSource != null) {
            cameraXSource.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (cameraXSource != null) {
            cameraXSource.close();
        }
    }

    @Override
    protected void initialization() {
        //初始化二维码扫描配置
        options =
                new BarcodeScannerOptions.Builder()
                        .setBarcodeFormats(
                                Barcode.FORMAT_QR_CODE,
                                Barcode.FORMAT_AZTEC)
                        .build();
        barcodeScanner = BarcodeScanning.getClient(options);

        //设置扫描回调
        detectionTaskCallback =
                detectionTask ->
                        detectionTask
                                .addOnSuccessListener(this::onDetectionTaskSuccess)
                                .addOnFailureListener(this::onDetectionTaskFailure);

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                if (cameraXSource.getLifecycle().getCurrentState() == Lifecycle.State.CREATED) {//stop
                    binding.startBtn.setBackgroundColor(getResources().getColor(R.color.red));
                    cameraXSource.start();
                } else if (cameraXSource.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                    binding.startBtn.setBackgroundColor(getResources().getColor(R.color.white));
                    cameraXSource.stop();
                }
            }
        });
    }


    private void checkPermission() {
        if (!PermissionX.isGranted(getContext(), Manifest.permission.CAMERA)
                || !PermissionX.isGranted(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //动态权限申请
            PermissionX.init(this)
                    .permissions(Manifest.permission.READ_CONTACTS, Manifest.permission.CAMERA)
                    .request(new RequestCallback() {
                        @Override
                        public void onResult(boolean allGranted, List<String> grantedList, List<String> deniedList) {
                            if (allGranted) {
                                showToastTip("All permissions are granted");
                                createThenStartCameraXSource();
                            } else {
                                showToastTip("These permissions are denied: $deniedList");
                            }
                        }

                    });
        } else {
            createThenStartCameraXSource();
        }
    }


    //开启相机预览
    @SuppressLint("MissingPermission")
    private void createThenStartCameraXSource() {
        if (cameraXSource != null) {
            cameraXSource.close();
        }
        //相机捕获资源配置
        builder = new CameraSourceConfig.Builder(
                getContext(), barcodeScanner, detectionTaskCallback)
                .setFacing(lensFacing);
        //获取摄像头分辨率

        //设置预览分辨率
//        builder.setRequestedPreviewSize(cameraXSource.getPreviewSize().getWidth(),
//                cameraXSource.getPreviewSize().getHeight());

        cameraXSource = new CameraXSource(builder.build(), binding.previewView);
        cameraXSource.start();
    }


    private void onDetectionTaskSuccess(List<Barcode> results) {
        if (results.size() > 0) {
            showToastTip(results.get(0).getRawValue());
            cameraXSource.stop();
            binding.startBtn.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    private void onDetectionTaskFailure(Exception e) {
        showToastTip(e.getMessage());
    }


    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_barcode;
    }
}
