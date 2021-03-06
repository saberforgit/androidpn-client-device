/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zs.devicemanager.model;

import org.jivesoftware.smack.packet.IQ;

import java.util.List;

/** 
 * This class represents a notifcatin IQ packet.

 */
public class DeviceInfoIQ extends IQ {

    /*
    设备硬件检测
     */
    private String hardwareSecurity;
    /**
     * 设备上报命令
     */
    private String deviceCollection;
    /**
     * 设备限制命令
     */
    private String deviceLimition;
    /**
     * 摄像头信息
     */
    private String  camera;
    /**
     * 应用包名
     */
    private String packageName;
    /**
     * 总流量
     */
    private String totalFlow;
    /*
    经度
     */
    private String longitude;
    /*
    纬度
     */
    private String latitude;
    /*
    详细地址
     */
    private String address;
    /*
    命令标示
     */
    private String reqFlag;
    /*
    锁屏密码
     */
    private String password;

    /**擦除成功标志*/
    private String isWiped;
    /**锁定成功标志*/
    private String isLocked;

    /**设备厂商*/
    private String manufacturer;

    /**规格型号*/
    private String phoneModel;

    /**处理器*/
    private String processor;

    /**ram大小*/
    private String ramSize;

    /**rom大小*/
    private String romSize;

    /**rom可用大小*/
    private String romAvailableSize;

    /**分表率*/
    private String displaySize;

    /**是否有摄像头*/
    private String isHasCamera;

    /**蓝牙地址*/
    private String blueToothMac;

    /**WIFI mac地址*/
    private String wifiMac;

    /**sd卡大小*/
    private String sdSize;

    /**sd可用大小*/
    private String sdAvailableSize;

    /**sd卡序列号*/
    private String sdSerialNo;

    /**电源状态*/
    private String batteryStatus;

    /**开机时长*/
    private String batteryLife;

    /**iemi*/
    private String imei;

    /**udid 设备的唯一设备识别符*/
    private String udid;

    /**是否root*/
    private String isRoot;

    /**是否lock*/
    private String isLock;

    /**设备运营商*/
    private String mobileOperator;

    /**移动号码*/
    private String deviceMobileNo;

    /**国际移动用户识别码*/
    private String imsiNo;

    /**是否漫游*/
    private String isRoaming;

    /**sim卡流量*/
    private String simFlow;

    /**wifi流量*/
    private String wifiFlow;

    /**sim卡变更信息*/
    private String simChangeHistory;

    /**设备OS*/
    private String deviceOS;

    /**设备app信息*/
    private List<AppInfo> appInfos;

    /**密码期限*/
    private String passwordExpiration;

    public DeviceInfoIQ() {
    }

    /**
     * 把IQ转化成xml
     * @return
     */
    @Override
    public String getChildElementXML() {
        StringBuilder buf = new StringBuilder();
        buf.append("<").append("deviceinfo").append(" xmlns=\"").append(
                "androidpn:iq:deviceinfo").append("\">");
        if (passwordExpiration != null) {
            buf.append("<passwordExpiration>").append(passwordExpiration).append("</passwordExpiration>");
        }
        if (hardwareSecurity != null) {
            buf.append("<hardwareSecurity>").append(hardwareSecurity).append("</hardwareSecurity>");
        }
        if (packageName != null) {
            buf.append("<packageName>").append(packageName).append("</packageName>");
        }
        if (wifiMac != null) {
            buf.append("<wifiMac>").append(wifiMac).append("</wifiMac>");
        }
        if (password != null) {
            buf.append("<password>").append(password).append("</password>");
        }
        if (totalFlow != null) {
            buf.append("<totalFlow>").append(totalFlow).append("</totalFlow>");
        }
        if (deviceCollection != null) {
            buf.append("<deviceCollection>").append(deviceCollection).append("</deviceCollection>");
        }if (deviceLimition != null) {
            buf.append("<deviceLimition>").append(deviceLimition).append("</deviceLimition>");
        }

        if (longitude != null) {
            buf.append("<longitude>").append(longitude).append("</longitude>");
        }
        if (latitude != null) {
            buf.append("<latitude>").append(latitude).append("</latitude>");
        }
        if (address != null) {
            buf.append("<address>").append(address).append("</address>");
        }
        if (reqFlag != null) {
            buf.append("<reqFlag>").append(reqFlag).append("</reqFlag>");
        }

        if (manufacturer != null) {
            buf.append("<manufacturer>").append(manufacturer).append("</manufacturer>");
        }

        if (phoneModel != null) {
            buf.append("<phoneModel>").append(phoneModel).append("</phoneModel>");
        }

        if (processor != null) {
            buf.append("<processor>").append(processor).append("</processor>");
        }

        if (ramSize != null) {
            buf.append("<ramSize>").append(ramSize).append("</ramSize>");
        }

        if (romSize != null) {
            buf.append("<romSize>").append(romSize).append("</romSize>");
        }

        if (romAvailableSize != null) {
            buf.append("<romAvailableSize>").append(romAvailableSize).append("</romAvailableSize>");
        }

        if (displaySize != null) {
            buf.append("<displaySize>").append(displaySize).append("</displaySize>");
        }
        if (camera != null) {
            buf.append("<camera>").append(camera).append("</camera>");
        }
        if (blueToothMac != null) {
            buf.append("<blueToothMac>").append(blueToothMac).append("</blueToothMac>");
        }

        if (sdSize != null) {
            buf.append("<sdSize>").append(sdSize).append("</sdSize>");
        }

        if (sdAvailableSize != null) {
            buf.append("<sdAvailableSize>").append(sdAvailableSize).append("</sdAvailableSize>");
        }

        if (sdSerialNo != null) {
            buf.append("<sdSerialNo>").append(sdSerialNo).append("</sdSerialNo>");
        }

        if (batteryStatus != null) {
            buf.append("<batteryStatus>").append(batteryStatus).append("</batteryStatus>");
        }

        if (batteryLife != null) {
            buf.append("<batteryLife>").append(batteryLife).append("</batteryLife>");
        }

        if (imei != null) {
            buf.append("<imei>").append(imei).append("</imei>");
        }

        if (udid != null) {
            buf.append("<udid>").append(udid).append("</udid>");
        }

        if (isRoot != null) {
            buf.append("<isRoot>").append(isRoot).append("</isRoot>");
        }

        if (isLock != null) {
            buf.append("<isLock>").append(isLock).append("</isLock>");
        }

        if (mobileOperator != null) {
            buf.append("<mobileOperator>").append(mobileOperator).append("</mobileOperator>");
        }

        if (deviceMobileNo != null) {
            buf.append("<deviceMobileNo>").append(deviceMobileNo).append("</deviceMobileNo>");
        }

        if (imsiNo != null) {
            buf.append("<imsiNo>").append(imsiNo).append("</imsiNo>");
        }

        if (isRoaming != null) {
            buf.append("<isRoaming>").append(isRoaming).append("</isRoaming>");
        }

        if (mobileOperator != null) {
            buf.append("<mobileOperator>").append(mobileOperator).append("</mobileOperator>");
        }

        if (simFlow != null) {
            buf.append("<simFlow>").append(simFlow).append("</simFlow>");
        }

        if (wifiFlow != null) {
            buf.append("<wifiFlow>").append(wifiFlow).append("</wifiFlow>");
        }

        if (simChangeHistory != null) {
            buf.append("<simChangeHistory>").append(simChangeHistory).append("</simChangeHistory>");
        }

        if (deviceOS != null) {
            buf.append("<deviceOS>").append(deviceOS).append("</deviceOS>");
        }

        if (isLocked != null) {
            buf.append("<isLocked>").append(isLocked).append("</isLocked>");
        }

        if (isWiped != null) {
            buf.append("<isWiped>").append(isWiped).append("</isWiped>");
        }

        if(appInfos != null && !appInfos.isEmpty()){
            buf.append(covertAppInfos2Xml());
        }

        buf.append("</").append("deviceinfo").append("> ");
        return buf.toString();
    }

    public String getPasswordExpiration() {
        return passwordExpiration;
    }

    public void setPasswordExpiration(String passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }

    public String getTotalFlow() {
        return totalFlow;
    }

    public void setTotalFlow(String totalFlow) {
        this.totalFlow = totalFlow;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getHardwareSecurity() {
        return hardwareSecurity;
    }

    public void setHardwareSecurity(String hardwareSecurity) {
        this.hardwareSecurity = hardwareSecurity;
    }

    public String getDeviceCollection() {
        return deviceCollection;
    }

    public void setDeviceCollection(String deviceCollection) {
        this.deviceCollection = deviceCollection;
    }

    public String getDeviceLimition() {
        return deviceLimition;
    }

    public void setDeviceLimition(String deviceLimition) {
        this.deviceLimition = deviceLimition;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getIsWiped() {
        return isWiped;
    }

    public void setIsWiped(String isWiped) {
        this.isWiped = isWiped;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public List<AppInfo> getAppInfos() {
        return appInfos;
    }

    public void setAppInfos(List<AppInfo> appInfos) {
        this.appInfos = appInfos;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWifiMac() {
        return wifiMac;
    }

    public void setWifiMac(String wifiMac) {
        this.wifiMac = wifiMac;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getReqFlag() {
        return reqFlag;
    }

    public void setReqFlag(String reqFlag) {
        this.reqFlag = reqFlag;
    }

    public String getManufacturer(){
        return manufacturer;
    }


    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }


    public String getphoneModel(){
        return phoneModel;
    }


    public void setphoneModel(String phoneModel){
        this.phoneModel = phoneModel;
    }


    public String getProcessor(){
        return processor;
    }


    public void setProcessor(String processor){
        this.processor = processor;
    }


    public String getRamSize(){
        return ramSize;
    }


    public void setRamSize(String ramSize){
        this.ramSize = ramSize;
    }


    public String getRomSize(){
        return romSize;
    }


    public void setRomSize(String romSize){
        this.romSize = romSize;
    }


    public String getRomAvailableSize(){
        return romAvailableSize;
    }


    public void setRomAvailableSize(String romAvailableSize){
        this.romAvailableSize = romAvailableSize;
    }

    public String getDisplaySize(){
        return displaySize;
    }


    public void setDisplaySize(String displaySize){
        this.displaySize = displaySize;
    }


    public String getIsHasCamera(){
        return isHasCamera;
    }


    public void setIsHasCamera(String isHasCamera){
        this.isHasCamera = isHasCamera;
    }


    public String getBlueToothMac(){
        return blueToothMac;
    }


    public void setBlueToothMac(String blueToothMac){
        this.blueToothMac = blueToothMac;
    }


    public String getSdSize(){
        return sdSize;
    }


    public void setSdSize(String sdSize){
        this.sdSize = sdSize;
    }


    public String getSdAvailableSize(){
        return sdAvailableSize;
    }


    public void setSdAvailableSize(String sdAvailableSize){
        this.sdAvailableSize = sdAvailableSize;
    }


    public String getSdSerialNo(){
        return sdSerialNo;
    }


    public void setSdSerialNo(String sdSerialNo){
        this.sdSerialNo = sdSerialNo;
    }


    public String getBatteryStatus(){
        return batteryStatus;
    }


    public void setBatteryStatus(String batteryStatus){
        this.batteryStatus = batteryStatus;
    }


    public String getBatteryLife(){
        return batteryLife;
    }


    public void setBatteryLife(String batteryLife){
        this.batteryLife = batteryLife;
    }


    public String getImei(){
        return imei;
    }


    public void setImei(String imei){
        this.imei = imei;
    }


    public String getUdid(){
        return udid;
    }


    public void setUdid(String udid){
        this.udid = udid;
    }


    public String getIsRoot(){
        return isRoot;
    }


    public void setIsRoot(String isRoot){
        this.isRoot = isRoot;
    }


    public String getIsLock(){
        return isLock;
    }


    public void setIsLock(String isLock){
        this.isLock = isLock;
    }

    public String getDeviceMobileNo() {
        return deviceMobileNo;
    }

    public void setDeviceMobileNo(String deviceMobileNo) {
        this.deviceMobileNo = deviceMobileNo;
    }

    public String getDeviceOS() {
        return deviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public String getImsiNo() {
        return imsiNo;
    }

    public void setImsiNo(String imsiNo) {
        this.imsiNo = imsiNo;
    }

    public String getIsRoaming() {
        return isRoaming;
    }

    public void setIsRoaming(String isRoaming) {
        this.isRoaming = isRoaming;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getSimChangeHistory() {
        return simChangeHistory;
    }

    public void setSimChangeHistory(String simChangeHistory) {
        this.simChangeHistory = simChangeHistory;
    }

    public String getSimFlow() {
        return simFlow;
    }

    public void setSimFlow(String simFlow) {
        this.simFlow = simFlow;
    }

    public String getWifiFlow() {
        return wifiFlow;
    }

    public void setWifiFlow(String wifiFlow) {
        this.wifiFlow = wifiFlow;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DeviceInfoIQ{" +
                "longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", address='" + address + '\'' +
                ", reqFlag='" + reqFlag + '\'' +
                ", camera='" + camera + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", phoneModel='" + phoneModel + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", romSize='" + romSize + '\'' +
                ", romAvailableSize='" + romAvailableSize + '\'' +
                ", displaySize='" + displaySize + '\'' +
                ", isHasCamera='" + isHasCamera + '\'' +
                ", blueToothMac='" + blueToothMac + '\'' +
                ", wifiMac='" + wifiMac + '\'' +
                ", sdSize='" + sdSize + '\'' +
                ", sdAvailableSize='" + sdAvailableSize + '\'' +
                ", sdSerialNo='" + sdSerialNo + '\'' +
                ", batteryStatus='" + batteryStatus + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                ", imei='" + imei + '\'' +
                ", udid='" + udid + '\'' +
                ", isRoot='" + isRoot + '\'' +
                ", isLock='" + isLock + '\'' +
                ", mobileOperator='" + mobileOperator + '\'' +
                ", deviceMobileNo='" + deviceMobileNo + '\'' +
                ", imsiNo='" + imsiNo + '\'' +
                ", isRoaming='" + isRoaming + '\'' +
                ", simFlow='" + simFlow + '\'' +
                ", wifiFlow='" + wifiFlow + '\'' +
                ", simChangeHistory='" + simChangeHistory + '\'' +
                ", deviceOS='" + deviceOS + '\'' +
                ", password='" + password + '\'' +
                ", passwordExpiration='" + appInfos + '\'' +
                ", passwordExpiration='" + passwordExpiration + '\'' +
                '}';
    }



    private String covertAppInfos2Xml(){
        if(appInfos == null || appInfos.isEmpty())
            return null;

        StringBuilder builder = new StringBuilder();
        builder.append("<appInfos>");

        for(AppInfo ai : appInfos){
            builder.append("<AppInfo>");
            builder.append("<appName>");
            builder.append(ai.getAppName());
            builder.append("</appName>");
            builder.append("<packageName>");
            builder.append(ai.getPackageName());
            builder.append("</packageName>");
            builder.append("<versionCode>");
            builder.append(ai.getVersionCode());
            builder.append("</versionCode>");
            builder.append("<firstInstallTime>");
            builder.append(ai.getFirstInstallTime());
            builder.append("</firstInstallTime>");
            builder.append("</AppInfo>");
        }

        builder.append("</appInfos>");

        return builder.toString();
    }
}
