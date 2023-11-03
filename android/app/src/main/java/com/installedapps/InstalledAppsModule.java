package com.installedapps;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.List;
import java.util.ArrayList;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import java.util.Map;
import java.util.HashMap;
import com.facebook.react.bridge.Promise;
import android.os.Handler;
import android.os.Looper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;


public class InstalledAppsModule extends ReactContextBaseJavaModule {
    public InstalledAppsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "InstalledAppsModule";
    }

    @ReactMethod
    public void getInstalledApps(Promise promise) {
        // return "This is the string returned by native module";
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {

                    PackageManager packageManager = getReactApplicationContext().getPackageManager();
                    List<ApplicationInfo> apps = packageManager.getInstalledApplications(0);

                    WritableArray appList = new WritableNativeArray();

                    for (ApplicationInfo app : apps) {
                        WritableMap appInfo = new WritableNativeMap();
                        appInfo.putString("name", app.loadLabel(packageManager).toString());
                        appInfo.putString("packageName", app.packageName);
                        Drawable icon = app.loadIcon(packageManager);
                        String iconBase64 = convertIconToBase64(icon);
                        appInfo.putString("icon", iconBase64);
                        appInfo.putString("installDate", getInstallDate(app.packageName)); // Install date
                        appList.pushMap(appInfo);
                    }

                    promise.resolve(appList);
                } catch (Exception e) {
                    promise.reject("ERROR_CODE", e.toString());
                }
            }
        }, 2000);
    }

    public static String convertIconToBase64(Drawable icon) {
        if (icon instanceof BitmapDrawable) {
            return convertBitmapDrawableToBase64((BitmapDrawable) icon);
        } else if (icon instanceof AdaptiveIconDrawable) {
            return convertAdaptiveIconDrawableToBase64((AdaptiveIconDrawable) icon);
        }
        return null;
    }

    private static String convertBitmapDrawableToBase64(BitmapDrawable bitmapDrawable) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private static String convertAdaptiveIconDrawableToBase64(AdaptiveIconDrawable adaptiveIconDrawable) {
        int width = adaptiveIconDrawable.getIntrinsicWidth();
        int height = adaptiveIconDrawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        adaptiveIconDrawable.setBounds(0, 0, width, height);
        adaptiveIconDrawable.draw(canvas);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private String getInstallDate(String packageName) {
        try {
            long installTime = getReactApplicationContext().getPackageManager().getPackageInfo(packageName, 0).firstInstallTime;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // yyyy-MM-dd HH:mm:ss
            return dateFormat.format(installTime);
        } catch (Exception e) {
            e.printStackTrace();
            return "N/A";
        }
    }

}
