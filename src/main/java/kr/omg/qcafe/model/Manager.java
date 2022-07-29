package kr.omg.qcafe.model;

public class Manager {
    private String managerId;
    private String managerPassword;
    private String storeName;
    private String stampImg;
    private String storeImageNewName;
    private String storeImageOriginalName;
    private String qrImageName;
    private String stampImageNewName;
    private String stampImageOriginalName;
    private String couponImageNewName;
    private String couponImageOriginalName;
    private int couponMaxCount;



    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStampImg() {
        return stampImg;
    }

    public void setStampImg(String stampImg) {
        this.stampImg = stampImg;
    }

    public String getStoreImageNewName() {
        return storeImageNewName;
    }

    public void setStoreImageNewName(String storeImageNewName) {
        this.storeImageNewName = storeImageNewName;
    }

    public String getStoreImageOriginalName() {
        return storeImageOriginalName;
    }

    public void setStoreImageOriginalName(String storeImageOriginalName) { this.storeImageOriginalName = storeImageOriginalName; }

    public String getQrImageName() {
        return qrImageName;
    }

    public void setQrImageName(String qrImageName) {
        this.qrImageName = qrImageName;
    }

    public String getStampImageNewName() {
        return stampImageNewName;
    }

    public void setStampImageNewName(String stampImageNewName) {
        this.stampImageNewName = stampImageNewName;
    }

    public String getStampImageOriginalName() {
        return stampImageOriginalName;
    }

    public void setStampImageOriginalName(String stampImageOriginalName) {
        this.stampImageOriginalName = stampImageOriginalName;
    }

    public String getCouponImageNewName() {
        return couponImageNewName;
    }

    public void setCouponImageNewName(String couponImageNewName) {
        this.couponImageNewName = couponImageNewName;
    }

    public String getCouponImageOriginalName() {
        return couponImageOriginalName;
    }

    public void setCouponImageOriginalName(String couponImageOriginalName) {
        this.couponImageOriginalName = couponImageOriginalName;
    }

    public int getCouponMaxCount() {
        return couponMaxCount;
    }

    public void setCouponMaxCount(int couponMaxCount) {
        this.couponMaxCount = couponMaxCount;
    }
}
