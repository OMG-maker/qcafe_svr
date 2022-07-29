package kr.omg.qcafe.mapper;

import kr.omg.qcafe.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerMapperImpl implements ManagerMapper{

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * @param manager
     * @return
     */
    public List<Manager> getManagerList(Manager manager){
        return this.managerMapper.getManagerList(manager);
    }
    public List<Manager> getManagerListForImage(Manager manager){
        return this.managerMapper.getManagerListForImage(manager);
    }

    public  void insertManager(Manager manager){
        this.managerMapper.insertManager(manager);
    }

    public List<Manager> getStoreSource(Manager manager){
        return this.managerMapper.getStoreSource(manager);
    }

    public void updateStoreImage(Manager manager){
        this.managerMapper.updateStoreImage(manager);
    }

    public void setStoreImageInEditStoreActivity(Manager manager){ this.managerMapper.setStoreImageInEditStoreActivity(manager); }

    public void setStampImageInEditStoreActivity(Manager manager){this.managerMapper.setStampImageInEditStoreActivity(manager); }

    public void updateQRImage(Manager manager){this.managerMapper.updateQRImage(manager);}

    public void updateStoreName(Manager manager){this.managerMapper.updateStoreName(manager);}

    public void updateCouponCount(Manager manager){this.managerMapper.updateCouponCount(manager);}

    public List<Manager> getQrImageName(Manager manager){
        return managerMapper.getQrImageName(manager);
    }

    public List<Manager> getStampImageName(Manager manager){
        return managerMapper.getStampImageName(manager);
    }
    public List<Manager> getStoreImageName(Manager manager){
        return managerMapper.getStoreImageName(manager);
    }
    public List<Manager> getStoreName(Manager manager){return managerMapper.getStoreName(manager);}
    public List<Manager> getQrExist(Manager manager){return managerMapper.getQrExist(manager);}
}