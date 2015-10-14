package org.androidpn.mydevice.cmd;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import org.androidpn.client.DeviceInfoIQ;
import org.androidpn.client.DeviceInfoPacketListener;
import org.androidpn.client.XmppManager;
import org.androidpn.demoapp.ScreenLockActivity;
import org.androidpn.mydevice.AppInfo;
import org.androidpn.mydevice.BaseDeviceFunction;
import org.androidpn.mydevice.DeviceGetter;
import org.androidpn.mydevice.DeviceManager;
import org.androidpn.mydevice.DeviceSecurity;
import org.androidpn.mydevice.receiver.MyAdminReceiver;
import org.jivesoftware.smack.packet.IQ;

import java.util.List;

import mylocation.GetLocation;

/**
 * Created by Saber on 2015/10/9.
 */
public class CmdLines extends BaseDeviceFunction {

    DeviceManager deviceManager = getDeviceManagerInstance();
    DeviceSecurity deviceSecurity = deviceManager.getDeviceSecurityInstance();
    DeviceGetter deviceGetter = deviceManager.getDeviceGetterInstance();
    /**
     * 执行单个指令
     * @param context
     * @param deviceInfoIQ
     * @param infoIQ
     * @param cmd
     */
    public void doMethod(Context context, DeviceInfoIQ deviceInfoIQ,
                          DeviceInfoIQ infoIQ, int cmd) {

//        PackageManager packageManager = getPackageManager();

//        XmppManager xmppManager = DeviceInfoPacketListener.getXmppManager();
        switch (cmd){
            case CmdType.IMEI:
                infoIQ.setImei(deviceGetter.getIMEI(context));
                break;
            case CmdType.BLUETOOTHMAC:
                infoIQ.setBlueToothMac(deviceGetter.getBluetoothMac());
                break;
            case CmdType.BATTERYSTATUS:
                deviceGetter.getBatteryInfo(context);
                break;
            case CmdType.PROCESSOR:
                infoIQ.setProcessor(deviceGetter.getCpuName());
                break;
            case CmdType.DEVICEMOBILENO:
                infoIQ.setDeviceMobileNo(deviceGetter.getPhoneModel());
                break;
            case CmdType.DEVICEOS:
                infoIQ.setDeviceOS(deviceGetter.getVersion()[3] + " " + deviceGetter.getVersion()[1]);
                break;
            case CmdType.DEVICEWIPE:
                CmdOperate.doWipe(deviceInfoIQ, context);
                break;
            case CmdType.DISPLAYSIZE:
                infoIQ.setDisplaySize(deviceGetter.getDisplayMetrics(context)[1] + " * " + deviceGetter.getDisplayMetrics(context)[0]);
                break;
            case CmdType.IMSINO:
                infoIQ.setImsiNo(deviceGetter.getImsi(context));
                break;
            case CmdType.ISLOCK:
                infoIQ.setIsLock(deviceGetter.getScreenLock(context) + "");
                break;
            case CmdType.ISROAMING:
                infoIQ.setIsRoaming(deviceGetter.getPhoneRoamState(context) + "");
                break;
            case CmdType.ISROOT:
                infoIQ.setIsRoot(deviceGetter.isRoot()+"");
                break;
            case CmdType.LOCATION:
                new GetLocation(context);
                break;
            case CmdType.MANUFACTURER:
                infoIQ.setManufacturer(deviceGetter.getManufacturer());
                break;
            case CmdType.MOBILEOPERATOR:
                infoIQ.setMobileOperator(deviceGetter.getProvidersName(context));
                break;
            case CmdType.RAMSIZE:
                deviceGetter.getAvailRamMemory(context);
                break;
            case CmdType.ROMSIZE:
                infoIQ.setRomSize(deviceGetter.getRomSize()+"");
                break;
            case CmdType.ROMAVAILABLESIZE:
                break;
            case CmdType.SCREENLOCK:
              CmdOperate.doScreenLock(deviceInfoIQ, context);
                break;
            case CmdType.SIMFLOW:
                infoIQ.setSimFlow(deviceGetter.getTotalBytes() + "");
                break;
            case CmdType.WIFIFLOW:
                break;
            case CmdType.WIFIMAC:
                infoIQ.setWifiMac(deviceGetter.getLocalMacAddress(context));
                break;
            case CmdType.UNSTALLAPK:
                deviceSecurity.unInstallApk(deviceInfoIQ.getPackageName(), context);
            default:
                infoIQ.setType(IQ.Type.SET);
        }
//        if("batteryStatus".equals(cmd)){
//            infoIQ.setBatteryStatus("99%");
//        }
//        if("camera".equals(cmd)){
//            infoIQ.setCamera("索尼生产，1800w像素");
//        }
//        if("deviceOS".equals(cmd)){
//            infoIQ.setDeviceOS("android 4.4.4");
//        }
//        if ("location".equals(cmd)) {
//            //获取地理位置
//            new GetLocation(context);
////                    String[] action = {ConnectivityManager.CONNECTIVITY_ACTION};
////                     deviceManager.registReceivers(context,wifiStateReceiver,action);
////                        deviceManager.registReceivers(context, mobileStatesReceiver, action);
//        } else if ("validate".equals(cmd)) {
//            infoIQ.setType(IQ.Type.SET);
//            infoIQ.setReqFlag("validate");
//            infoIQ.setDeviceOS(deviceGetter.getVersion()[3] + " " + deviceGetter.getVersion()[1]);
//            infoIQ.setIsRoot(deviceGetter.isRoot()+"" );
//            infoIQ.setImsiNo(deviceGetter.getImsi(context));
//            xmppManager.getConnection().sendPacket(infoIQ);
//        } else if ("screenLock".equals(cmd)) {
//            //当password的值是null时，表示解锁
//            if ("null".equals(deviceInfoIQ.getPassword())) {
//                deviceInfoIQ.setPassword("");
//            }
//            infoIQ.setType(IQ.Type.SET);
//            infoIQ.setReqFlag("screenLock");
//
//            //锁屏及修改密码
////            deviceLockOrWipe(DeviceManager.SCREEN_LOCK, deviceInfoIQ.getPassword());
//
//            if ("null".equals(deviceInfoIQ.getPassword())) {
//                infoIQ.setIsLocked("0");
//            } else {
//                infoIQ.setIsLocked("1");
//            }
//
//            xmppManager.getConnection().sendPacket(infoIQ);
//        } else if ("deleteApp".equals(cmd)) {
            //删除数据
//                        deviceSecurity.deleteFile(context, Environment.getExternalStorageDirectory().getAbsoluteFile());

            //卸载应用
//                        String[] action = {Intent.ACTION_PACKAGE_ADDED,Intent.ACTION_PACKAGE_REMOVED};
//                        deviceManager.registReceivers(context,bootReceiver,action);

//                        if(!deviceSecurity.isInstall(packageManager,deviceInfoIQ.getAppPackage())) {
//                            infoIQ.setType(IQ.Type.SET);
//                            infoIQ.setIsWiped("0");
//                            infoIQ.setReqFlag("deleteApp");
//                            xmppManager.getConnection().sendPacket(infoIQ);
//                        }else{
//                            boolean flag = deviceSecurity.clientUninstall(deviceInfoIQ.getAppPackage());
//                        }

//        } else if ("deviceWipe".equals(cmd)) {
//            //删除数据
//            deviceSecurity.deleteFile(context, Environment.getExternalStorageDirectory().getAbsoluteFile());
//
//            //卸载应用
////                        String[] action = {Intent.ACTION_PACKAGE_ADDED,Intent.ACTION_PACKAGE_REMOVED};
////                        deviceManager.registReceivers(context,bootReceiver,action);
//
//            if (!deviceSecurity.isInstall(packageManager, "移动展业包名")) {
//                infoIQ.setType(IQ.Type.SET);
//                infoIQ.setReqFlag("deviceWipe");
//                infoIQ.setIsWiped("0");
//                xmppManager.getConnection().sendPacket(infoIQ);
//            } else {
//                boolean flag = deviceSecurity.clientUninstall("移动展业包名");
//            }
//
//        } else if ("app".equals(cmd)) {
//            List<AppInfo> appInfos = deviceSecurity.getApp(context);
//            infoIQ.setType(IQ.Type.SET);
//            infoIQ.setReqFlag("appInfo");
//            infoIQ.setAppInfos(appInfos);
//            xmppManager.getConnection().sendPacket(infoIQ);
//        } else if ("imei".equals(cmd)) {
//            infoIQ.setImei(deviceGetter.getIMEI(context));
//        } else if ("battery".equals(cmd)) {
//            deviceGetter.getBatteryInfo(context);
//        } else if ("romsize".equals(cmd)) {
//            long[] romsize = deviceGetter.getRomSize();
//            infoIQ.setRomSize(romsize[0] + "," + romsize[1]);
//        }
    }
}
