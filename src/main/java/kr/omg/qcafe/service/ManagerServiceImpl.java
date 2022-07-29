package kr.omg.qcafe.service;

import kr.omg.qcafe.mapper.ManagerMapper;
import kr.omg.qcafe.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional // 얜 기능이 따로 있음
@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerMapper managerMapper;

    public List<Manager> getManagerList(Manager manager) {
        return managerMapper.getManagerList(manager);
    }
    public List<Manager> getManagerListForImage(Manager manager){
        return this.managerMapper.getManagerListForImage(manager);
    }

    public  void insertManager(Manager manager){
        managerMapper.insertManager(manager);
    }

    public List<Manager> getStoreSource(Manager manager){
        return managerMapper.getStoreSource(manager);
    }

    public void updateStoreImage(Manager manager){
        managerMapper.updateStoreImage(manager);
    }

    public void setStoreImageInEditStoreActivity(Manager manager){ managerMapper.setStoreImageInEditStoreActivity(manager); }

    public void setStampImageInEditStoreActivity(Manager manager){ managerMapper.setStampImageInEditStoreActivity(manager); }

    public void updateQRImage(Manager manager){
        managerMapper.updateQRImage(manager);
    }

    public void updateStoreName(Manager manager){managerMapper.updateStoreName(manager);}

    public void updateCouponCount(Manager manager){managerMapper.updateCouponCount(manager);}

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

