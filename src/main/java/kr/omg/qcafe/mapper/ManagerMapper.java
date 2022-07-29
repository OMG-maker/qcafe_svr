package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.Manager;

import java.util.List;

public interface ManagerMapper {

    /**
     *
     * @param manager
     * @return
     */
    public List<Manager> getManagerList(Manager manager);

    public List<Manager> getManagerListForImage(Manager manager);

    public  void insertManager(Manager manager);

    public List<Manager> getStoreSource(Manager manager);

    public void updateStoreImage(Manager manager);

    public void setStoreImageInEditStoreActivity(Manager manager);

    public void setStampImageInEditStoreActivity(Manager manager);

    public void updateQRImage(Manager manager);

    public void updateStoreName(Manager manager);

    public void updateCouponCount(Manager manager);

    public List<Manager> getQrImageName(Manager manager);

    public List<Manager> getStampImageName(Manager manager);
    public List<Manager> getStoreImageName(Manager manager);
    public List<Manager> getStoreName(Manager manager);
    public List<Manager> getQrExist(Manager manager);





}
