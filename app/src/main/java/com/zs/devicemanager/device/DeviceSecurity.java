package com.zs.devicemanager.device;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;

import com.zs.devicemanager.model.AppInfo;
import com.zs.devicemanager.device.receiver.MobileStatesReceiver;
import com.zs.devicemanager.device.receiver.WifiStateReceiver;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by S on 2015/8/14.
 */
public class DeviceSecurity{

    DeviceManager deviceManager = DeviceManager.getDeviceManagerInstance();
    WifiStateReceiver wifiStateReceiver = new WifiStateReceiver();
    MobileStatesReceiver mobileStatesReceiver = new MobileStatesReceiver();

    /**
     * 获取手机上的app
     */
    public List getApp(Context context) {
        List<PackageInfo> pakageinfos;
        List<AppInfo> pakages = new ArrayList<AppInfo>();
        PackageManager packageManager= context.getPackageManager();
        pakageinfos = packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (PackageInfo pi : pakageinfos) {
            if ((pi.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                //非系统应用
                AppInfo tmpInfo = new AppInfo();
                String pi_packageName = pi.packageName;
                int i = 0;
                tmpInfo.setAppName(pi.applicationInfo.loadLabel(context.getPackageManager()).toString());
                tmpInfo.setPackageName(pi.packageName);
                tmpInfo.setVersionCode(pi.versionCode + "");
                tmpInfo.setFirstInstallTime(pi.firstInstallTime + "");
                pakages.add(tmpInfo);
            } else {
        //系统应用　　　　　　　　
            }

        }
        return pakages;
    }

    /**
     * 静默卸载
     * 设备未root，暂不使用
     */
    public static boolean clientUninstall(String packageName) {
        PrintWriter PrintWriter = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            PrintWriter = new PrintWriter(process.getOutputStream());
            PrintWriter.println("LD_LIBRARY_PATH=/vendor/lib:/system/lib ");
            PrintWriter.println("pm uninstall " + packageName);
            PrintWriter.flush();
            PrintWriter.close();
            int value = process.waitFor();
            return returnResult(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
        return false;
    }

    /**
     * 销毁文件
     * @param context
     * @param file 要删除的文件目录
     */
    public void deleteFile(final Context context, final File file) {
        new Thread() {
            @Override
            public void run() {
                context.getApplicationContext().getContentResolver().delete(Media.EXTERNAL_CONTENT_URI, Media.DATA + "=?", new String[]{file.getAbsolutePath()});
                if (file.exists() == false) {
                    return;
                } else {
                    if (file.isFile()) {
                        file.delete();
                        return;
                    }
                    if (file.isDirectory()) {
                        File[] childFile = file.listFiles();
                        if (childFile == null || childFile.length == 0) {
                            file.delete();
                            return;
                        }
                        for (File f : childFile) {
                            deleteFile(context, f);
                        }
                        file.delete();
                    }
                }
            }
        }.start();
    }


    private static boolean returnResult(int value) {
        // 代表成功
        if (value == 0) {
            return true;
        } else if (value == 1) { // 失败
            return false;
        } else { // 未知情况
            return false;
        }
    }

    /**
     * 判断文件夹是否为空或者存在
     * @param file
     * @return
     */
    public boolean isEmptyOrExist(File file) {

    if(file.exists()&&file.isDirectory())
    {
        if (file.list().length > 0) {
        return false;
            //Not empty, do something here.
        }
        return true;
    }
        return true;
}


    /**
     * 判断app是否安装
     * @param pm
     * @param packageName 包名
     * @return
     */
    public boolean isInstall(PackageManager pm, String packageName) {
        boolean tag = false;
        List<PackageInfo> pakageinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (PackageInfo pi : pakageinfos) {
            String pi_packageName = pi.packageName;
            //如果这个包名在系统已经安装过的应用中存在
            if(packageName.endsWith(pi_packageName)){
                //Log.i("test","此应用安装过了");
                tag = true;
            }
        }
        return tag;
    }

    /**
     * 安装apk
     * @param apkName 安装apk的名称
     */
    public void installAPK(String apkFromPath ,String apkName){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + apkFromPath + "/" + apkName),
                "application/vnd.android.package-archive");
//        this.startActivity(intent);
    }

    /**
     * 查看网络信息列表
     */
    public Map getNetStates(Context context){
        String serviceName =Context.CONNECTIVITY_SERVICE ;
        Map map = new HashMap();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(serviceName);
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        for (int i =0;i<allNetworkInfo.length;i++){
            NetworkInfo networkInfo = allNetworkInfo[i];
            map.put("DetailedState",networkInfo.getDetailedState());
            map.put("ExtraInfo",networkInfo.getExtraInfo());
            map.put("Reason",networkInfo.getReason());
            map.put("State",networkInfo.getState());
            map.put("Subtype",networkInfo.getSubtype());
            map.put("SubtypeName",networkInfo.getSubtypeName());
            map.put("Type",networkInfo.getType());
            map.put("TypeName",networkInfo.getTypeName());
            Log.e("Tag",map.toString());
        }
     return map;
    }

    /**
     * 蓝牙控制
     * @param bluetoothEnable
     * @return
     */
    public boolean setBluetoothEnable(boolean bluetoothEnable){
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothEnable){
            return bluetoothAdapter.enable();
        }else {
            return bluetoothAdapter.disable();
        }
    }

    /**
     * 卸载应用
     * @param packageName
     */
    public void unInstallApk(String packageName,Context context){
        Uri uri = Uri.parse("package:" + packageName);//获取删除包名的URI
        Intent i = new Intent();
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setAction(Intent.ACTION_DELETE);//设置我们要执行的卸载动作
        i.setData(uri);//设置获取到的URI
        context.startActivity(i);
    }

    //开启wifi网络限制
    public void disableWifi(Context context){
        String[] action = {ConnectivityManager.CONNECTIVITY_ACTION};
        deviceManager.registReceivers(context, wifiStateReceiver, action);
    }
    //开启sim网络限制
    public void disableMobile(Context context){
        String[] action = {ConnectivityManager.CONNECTIVITY_ACTION};
        deviceManager.registReceivers(context,mobileStatesReceiver,action);
    }
    //关闭wifi网络
    public void openWifi(Context context){
        deviceManager.unRegistReceivers(context, wifiStateReceiver);
    }
    //关闭sim网络
    public void openMobile(Context context){
        deviceManager.unRegistReceivers(context, mobileStatesReceiver);
    }
}

