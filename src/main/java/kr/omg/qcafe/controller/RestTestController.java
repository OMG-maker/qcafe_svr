package kr.omg.qcafe.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import kr.omg.qcafe.model.AdminUser;
import kr.omg.qcafe.model.Manager;
import kr.omg.qcafe.model.Menu;
import kr.omg.qcafe.model.User;
import kr.omg.qcafe.service.AdminUserService;
import kr.omg.qcafe.service.ManagerService;
import kr.omg.qcafe.service.MenuService;

// jpa 설정
//import kr.omg.qcafe.service.UserService;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class RestTestController {
    @Autowired
    private AdminUserService adminUserService;

//    @Autowired
//    private UserService userService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private MenuService menuService;





    //test
    @GetMapping("/getTest")
    public String sample2(Model model) {
        model.addAttribute("id", "idd");
        return "getTest";
    }

//            jpa 설정을 위해 임시로 주석
//    //로그인
//    @ResponseBody
//    @PostMapping("/userLoginTest")
//    public String loginTest(@RequestParam("param") String param) {
//        // System.out.println("param : " + param);
//        JSONObject json = new JSONObject(param);
//
//        // User 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
//        User user = new User();
//        user.setUserId(String.valueOf(json.get("userId")));
//        user.setUserPassword(String.valueOf(json.get("userPassword")));
//
//
//        // user 내부값에 부합하는 데이터를 DB에서 가져오기 위한 코드
//        // USer 리스트인 uList 내에 user 내부값에 부합하는 데이터들을 저장
//
//        List<User> uList = userService.getUserList(user);
//
//        //DB 내부에 존재하며 user 데이터값에 부합하는 컬럼의 수
//        System.out.println("userloginTest" + uList.size());
//
//        // User u 객체를 만들고 uList 의 길이만큼 u 내부에 uList 원소들을 대입하면서 반복문을 진행
//        for (User u : uList) {
//            System.out.println("user_id : " + u.getUserId());
//            System.out.println("password : " + u.getUserPassword());
//        }
//
//        JSONObject result = new JSONObject();
//
//        if (uList.size() == 0) {
//            result.put("code", "N");
//            result.put("msg", "사용자를 찾을 수 없습니다.");
//
//        } else if (uList.size() == 1) {
//            result.put("code", "Y");
//            result.put("msg", "로그인 성공");
//
//        } else {
//            result.put("code", "E");
//            result.put("msg", "알 수 없는 에러가 발생하였습니다.");
//        }
//        return result.toString();
//    }

    @ResponseBody
    @PostMapping("/managerLoginTest")
    public String managerLoginTest(@RequestParam("param") String param) {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        // User 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));
        manager.setManagerPassword(String.valueOf(json.get("managerPassword")));

        // user 내부값에 부합하는 데이터를 DB에서 가져오기 위한 코드
        // USer 리스트인 uList 내에 user 내부값에 부합하는 데이터들을 저장
        List<Manager> mList = managerService.getManagerList(manager);

        //DB 내부에 존재하며 user 데이터값에 부합하는 컬럼의 수
        System.out.println("" + mList.size());

        // User u 객체를 만들고 uList 의 길이만큼 u 내부에 uList 원소들을 대입하면서 반복문을 진행
        for (Manager m : mList) {
            System.out.println("managerId : " + m.getManagerId());
            System.out.println("Password : " + m.getManagerPassword());
        }

        JSONObject result = new JSONObject();

        if (mList.size() == 0) {
            result.put("code", "N");
            result.put("msg", "사용자를 찾을 수 없습니다.");

        } else if (mList.size() == 1) {
            result.put("code", "Y");
            result.put("msg", "로그인 성공");

        } else {
            result.put("code", "E");
            result.put("msg", "알 수 없는 에러가 발생하였습니다.");
        }
        return result.toString();
    }

//    //            jpa 설정을 위해 임시로 주석
//    //회원가입
//    @ResponseBody
//    @PostMapping("/userRegisterTest")
//    public String registerTest(@RequestParam("param") String param) {
//        // 전송받은 param 값을 JSONObject 인 json 에 저장
//        JSONObject json = new JSONObject(param);
//
//        // User 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
//        User user = new User();
//        user.setUserId(String.valueOf(json.get("userId")));
//        user.setUserPassword(String.valueOf(json.get("userPassword")));
//        user.setUserNickname(String.valueOf(json.get("userNickname")));
//
//        // user 내부값에 부합하는 데이터를 DB에서 가져오기 위한 코드
//        // USer 리스트인 uList 내에 user 내부값에 부합하는 데이터들을 저장
//        String code = "Y";
//        String msg = "회원가입에 성공하였습니다.";
//
//        try {
////            userService.insertUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//            code = "N";
//            msg = "회원가입에 실패하였습니다.";
//        }
//
//        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
//        // result 는 결과값 전송에 쓰일 JSONObject 변수
//        JSONObject result = new JSONObject();
//        result.put("code", code);
//        result.put("msg", msg);
//
//        return result.toString();
//    }

    //회원가입
    @ResponseBody
    @PostMapping("/mangerRegisterTest")
    public String managerRegisterTest(@RequestParam("param") String param) {
        // 전송받은 param 값을 JSONObject 인 json 에 저장
        JSONObject json = new JSONObject(param);

//        // User 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
//        User user = new User();
//        user.setUserId(String.valueOf(json.get("userId")));
//        user.setUserPassword(String.valueOf(json.get("userPassword")));
//        user.setUserNickname(String.valueOf(json.get("userNickname")));

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));
        manager.setManagerPassword(String.valueOf(json.get("managerPassword")));
        manager.setStoreName(String.valueOf(json.get("storeName")));



        // user 내부값에 부합하는 데이터를 DB에서 가져오기 위한 코드
        // USer 리스트인 uList 내에 user 내부값에 부합하는 데이터들을 저장
        String code = "Y";
        String msg = "회원가입에 성공하였습니다.";

        try {
            managerService.insertManager(manager);
        } catch (Exception e) {
            e.printStackTrace();
            code = "N";
            msg = "회원가입에 실패하였습니다.";
        }

        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);

        return result.toString();
    }

    //QR정보
    @ResponseBody
    @PostMapping("/qrScanTest")
    public String qrScanTest(@RequestParam("param") String param) {
        // 전송받은 param 값을 JSONObject 인 json 에 저장
        JSONObject json = new JSONObject(param);

        // Manager 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

        System.out.println("manager_id : " + manager.getManagerId());

        // manager 내부값에 부합하는 데이터를 DB에서 가져오기 위한 코드
        // Manager 리스트인 mList 내에 manager 내부값에 부합하는 데이터들을 저장
        String code = "Y";
        String msg = "데이터 로딩에 성공하였습니다.";


        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        List<Manager> mList = managerService.getStoreSource(manager);

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            result.put("managerId", m.getManagerId());
            result.put("managerPassword", m.getManagerPassword());
            result.put("storeName", m.getStoreName());
            result.put("stampImg", m.getStampImg());
            result.put("storeImageNewName", m.getStoreImageNewName());
            result.put("storeImageOriginalName", m.getStoreImageOriginalName());
            result.put("qrImageName", m.getQrImageName());
        }
        return result.toString();
    }

    //userQr정보
    @ResponseBody
    @PostMapping("/userQrScanPlusCountTest")
    public String userQrScanPlusCountTest(@RequestParam("param") String param) {
        // 전송받은 param 값을 JSONObject 인 json 에 저장
        JSONObject json = new JSONObject(param);

        // Manager 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
        AdminUser adminUser = new AdminUser();
        adminUser.setUserId(String.valueOf(json.get("userId")));
        adminUser.setManagerId(String.valueOf(json.get("managerId")));
        adminUser.setCount(Integer.parseInt(String.valueOf(json.get("couponCount"))));


        System.out.println("user_id : " + adminUser.getUserId());
        System.out.println("manager_id : " + adminUser.getManagerId());
        System.out.println("count : " + adminUser.getCount() + "\n");



        //우선 table에 기존에 해당 userId 와 managerID를 key값으로 잡고 count를 세어둔 컬럼이 있는지 확인해야함
        // 확인해서 없으면 우선 컬럼을 Insert 하기. (count는 받아온 만큼)
        // 확인해서 있으면 해당 컬럼에 count만 덧셈해주기.

        List<AdminUser> adList = adminUserService.getAdminUserList(adminUser);


//        List<AdminUser> adList = adminUserService.(adminUser);

        JSONObject result = new JSONObject();

        System.out.println("adList.size() = "+ adList.size());


        if (adList.size() == 0) {
            adminUserService.insertAdminUserList(adminUser);
        }
        else{
            int countInt = adList.get(0).getCount();
            int sumCount = countInt + adminUser.getCount();
            adminUser.setCount(sumCount);
            adminUserService.updateAdminUserList(adminUser);
        }

        if (adList.size() == 0) {
            result.put("code", "N");
            result.put("msg", "사용자를 찾을 수 없습니다.");

        } else if (adList.size() == 1) {
            result.put("code", "Y");
            result.put("msg", "로그인 성공");

        } else {
            result.put("code", "E");
            result.put("msg", "알 수 없는 에러가 발생하였습니다.");
        }

        return result.toString();
    }

    //userQr정보
    @ResponseBody
    @PostMapping("/getUserCouponCount")
    public String getUserCouponCount(@RequestParam("param") String param) {
        // 전송받은 param 값을 JSONObject 인 json 에 저장
        JSONObject json = new JSONObject(param);

        // Manager 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
        AdminUser adminUser = new AdminUser();
        adminUser.setUserId(String.valueOf(json.get("userId")));
        adminUser.setManagerId(String.valueOf(json.get("managerId")));
//        adminUser.setCount(Integer.parseInt(String.valueOf(json.get("couponCount"))));


        System.out.println("getUserCouponCount : user_id : " + adminUser.getUserId());
        System.out.println("getUserCouponCount : manager_id : " + adminUser.getManagerId());



        //우선 table에 기존에 해당 userId 와 managerID를 key값으로 잡고 count를 세어둔 컬럼이 있는지 확인해야함
        // 확인해서 없으면 우선 컬럼을 Insert 하기. (count는 받아온 만큼)
        // 확인해서 있으면 해당 컬럼에 count만 덧셈해주기.

        List<AdminUser> adList = adminUserService.getAdminUserList(adminUser);


//        List<AdminUser> adList = adminUserService.(adminUser);

        JSONObject result = new JSONObject();

        System.out.println("adList.size() = "+ adList.size());


        if (adList.size() == 0) {
            result.put("count", 0);
        }
        else{
            result.put("count", adList.get(0).getCount());
        }

        return result.toString();
    }

    //userQr정보
    @ResponseBody
    @PostMapping("/useUserCouponCount")
    public void useUserCouponCount(@RequestParam("param") String param) {
        // 전송받은 param 값을 JSONObject 인 json 에 저장
        JSONObject json = new JSONObject(param);

        // Manager 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
        AdminUser adminUser = new AdminUser();
        adminUser.setUserId(String.valueOf(json.get("userId")));
        adminUser.setManagerId(String.valueOf(json.get("managerId")));
//        adminUser.setCount(Integer.parseInt(String.valueOf(json.get("couponCount"))));


        System.out.println("getUserCouponCount : user_id : " + adminUser.getUserId());
        System.out.println("getUserCouponCount : manager_id : " + adminUser.getManagerId());


        //우선 table에 기존에 해당 userId 와 managerID를 key값으로 잡고 count를 세어둔 컬럼이 있는지 확인해야함
        // 확인해서 없으면 우선 컬럼을 Insert 하기. (count는 받아온 만큼)
        // 확인해서 있으면 해당 컬럼에 count만 덧셈해주기.

        List<AdminUser> adList = adminUserService.getAdminUserList(adminUser);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));


        List<Manager> mList = managerService.getManagerListForImage(manager);

        System.out.println("mList : getCouponMaxCount() : " + mList.get(0).getCouponMaxCount());


        int couponMaxCount = mList.get(0).getCouponMaxCount();

        adminUser.setCount(adList.get(0).getCount() - couponMaxCount);
        System.out.println("adminUser.getCount() : " + adminUser.getCount());

        adminUserService.updateAdminUserList(adminUser);

    }

    @ResponseBody
    @PostMapping("/setStoreImage")
    public void setStoreImage(@RequestParam("file") MultipartFile mFile, @RequestParam("param1") String param1) throws IOException {
        JSONObject json = new JSONObject(param1);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));
        manager.setManagerPassword(String.valueOf(json.get("managerPassword")));

        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
        UUID uuid = UUID.randomUUID();
//        System.out.println("managerId : "+ manager.getManagerId());
//        System.out.println("managerPassword : "+ manager.getManagerPassword());
//        System.out.println("mFile.getBytes() : "+mFile.getBytes());
//        System.out.println("mFile.getContentType() : "+mFile.getContentType());
//        System.out.println("mFile.getName() : "+mFile.getName());
//        System.out.println("mFile.getOriginalFilename() : "+mFile.getOriginalFilename());


        manager.setStoreImageNewName(uuid.toString());
        manager.setStoreImageOriginalName(mFile.getOriginalFilename());

//        System.out.println("manager.getStoreImageNewName() : "+manager.getStoreImageNewName());
//        System.out.println("manager.getStoreImageOriginalName() : "+manager.getStoreImageOriginalName());

        // 1. C드라이브 특정 위치에 파일을 저장 (UUID 를 이용하여 이름을 변환할것)
        // 2. 원본 파일 이름과 변환한 파일 이름을 DB에 저장

        // c://test//temp_2021_09_13_02_48_13.jpeg 형태로 path를 지정
        String name = uuid.toString();
        String path = "c://qcafe_image//StoreImage//" + name + ".jpg";

        // path 경로에 File 형태로 저장한다.
        mFile.transferTo(new File(path));

        try {
            managerService.updateStoreImage(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping("/setStoreImageInEditStoreActivity")
    public void setStoreImageInEditStoreActivity(@RequestParam("file") MultipartFile mFile, @RequestParam("param") String param1) throws IOException {
        JSONObject json = new JSONObject(param1);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
        UUID uuid = UUID.randomUUID();
//        System.out.println("managerId : "+ manager.getManagerId());
//        System.out.println("managerPassword : "+ manager.getManagerPassword());
//        System.out.println("mFile.getBytes() : "+mFile.getBytes());
//        System.out.println("mFile.getContentType() : "+mFile.getContentType());
//        System.out.println("mFile.getName() : "+mFile.getName());
//        System.out.println("mFile.getOriginalFilename() : "+mFile.getOriginalFilename());


        manager.setStoreImageNewName(uuid.toString());
        manager.setStoreImageOriginalName(mFile.getOriginalFilename());

//        System.out.println("manager.getStoreImageNewName() : "+manager.getStoreImageNewName());
//        System.out.println("manager.getStoreImageOriginalName() : "+manager.getStoreImageOriginalName());

        // 1. C드라이브 특정 위치에 파일을 저장 (UUID 를 이용하여 이름을 변환할것)
        // 2. 원본 파일 이름과 변환한 파일 이름을 DB에 저장

        // c://test//temp_2021_09_13_02_48_13.jpeg 형태로 path를 지정
        String name = uuid.toString();
        String path = "c://qcafe_image//StoreImage//" + name + ".jpg";

        // path 경로에 File 형태로 저장한다.
        mFile.transferTo(new File(path));

        try {
            managerService.setStoreImageInEditStoreActivity(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @PostMapping("/setStampImageInEditStoreActivity")
    public void setStampImageInEditStoreActivity(@RequestParam("file") MultipartFile mFile, @RequestParam("param") String param1) throws IOException {
        JSONObject json = new JSONObject(param1);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
        UUID uuid = UUID.randomUUID();
//        System.out.println("managerId : "+ manager.getManagerId());
//        System.out.println("managerPassword : "+ manager.getManagerPassword());
//        System.out.println("mFile.getBytes() : "+mFile.getBytes());
//        System.out.println("mFile.getContentType() : "+mFile.getContentType());
//        System.out.println("mFile.getName() : "+mFile.getName());
//        System.out.println("mFile.getOriginalFilename() : "+mFile.getOriginalFilename());


        manager.setStampImageNewName(uuid.toString());
        manager.setStampImageOriginalName(mFile.getOriginalFilename());

//        System.out.println("manager.getStoreImageNewName() : "+manager.getStoreImageNewName());
//        System.out.println("manager.getStoreImageOriginalName() : "+manager.getStoreImageOriginalName());

        // 1. C드라이브 특정 위치에 파일을 저장 (UUID 를 이용하여 이름을 변환할것)
        // 2. 원본 파일 이름과 변환한 파일 이름을 DB에 저장

        // c://test//temp_2021_09_13_02_48_13.jpeg 형태로 path를 지정
        String name = uuid.toString();
        String path = "c://qcafe_image//Stamp//" + name + ".jpg";

        // path 경로에 File 형태로 저장한다.
        mFile.transferTo(new File(path));

        try {
//                    System.out.println("manager.getStoreImageNewName() : "+manager.getStoreImageNewName());
//        System.out.println("manager.getStoreImageOriginalName() : "+manager.getStoreImageOriginalName());
            managerService.setStampImageInEditStoreActivity(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping("/insertMenu")
    public void insertMenu(@RequestParam("file") MultipartFile mFile, @RequestParam("param") String param) throws IOException {
        JSONObject json = new JSONObject(param);

        Menu menu = new Menu();

        UUID uuid = UUID.randomUUID();
        System.out.println("mFile.getBytes() : "+mFile.getBytes());
        System.out.println("mFile.getContentType() : "+mFile.getContentType());
        System.out.println("mFile.getName() : "+mFile.getName());
        System.out.println("mFile.getOriginalFilename() : "+mFile.getOriginalFilename());

        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
        menu.setMenuImageNewName(uuid.toString());
        menu.setMenuImageOriginalName(mFile.getOriginalFilename());

        menu.setManagerId(String.valueOf(json.get("managerId")));
        menu.setMenuName(String.valueOf(json.get("menuName")));
        menu.setMenuPrice(Integer.parseInt(String.valueOf(json.get("menuPrice"))));
        menu.setMenuExplain(String.valueOf(json.get("menuExplain")));

//
//        System.out.println("menu.getMenuImageNewName() : "+menu.getMenuImageNewName());
//        System.out.println("menu.getMenuImageOriginalName() : "+menu.getMenuImageOriginalName());

        // 1. C드라이브 특정 위치에 파일을 저장 (UUID 를 이용하여 이름을 변환할것)
        // 2. 원본 파일 이름과 변환한 파일 이름을 DB에 저장

        // c://test//temp_2021_09_13_02_48_13.jpeg 형태로 path를 지정
        String name = uuid.toString();
        String path = "c://qcafe_image//MenuImage//" + name + ".jpg";

        // path 경로에 File 형태로 저장한다.
        mFile.transferTo(new File(path));

        try {
            menuService.insertMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @PostMapping("/createQRTest")
    public String createQRTest(@RequestParam("param") String param) throws IOException
    {
        //param 정보를 저장한 json 객체 생성
        JSONObject json = new JSONObject(param);

        //json 객체에 저장한 param 정보를 담을 Manager 모델 생성
        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId"))); // managerId 저장

        System.out.println("managerId : "+manager.getManagerId());
        String name = "";

        // 이름을 대입해서 QR 코드를 만든다
        // 생성한 QR 코드를 서버에 저장한다
        // QR 코드의 이름을 UUID로 생성한다
        try {
            UUID uuid = UUID.randomUUID();
            File file = null;
            // 큐알이미지를 저장할 디렉토리 지정
            // c://test//... 형태로 path를 지정
            name = uuid.toString();
            String path = "c://qcafe_image//QR//" + name +".jpg";

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("managerId",manager.getManagerId());
            System.out.println("name : "+jsonObject.get("managerId"));
            String qrDataString = jsonObject.toString();

            String codeurl = new String(qrDataString.getBytes("UTF-8"), "ISO-8859-1");

            int qrcodeColor =   0xFF2e4e96; // 큐알코드 바코드 생상값
            int backgroundColor = 0xFFFFFFFF;  // 큐알코드 배경색상값

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO를 사용한 바코드 파일쓰기

            ImageIO.write(bufferedImage, "jpg", new File(path));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // qr 이미지명을 DB에 저장한다
        manager.setQrImageName(name);

        try {
            managerService.updateQRImage(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @ResponseBody
    @PostMapping("/createQrImageAndGetQrString")
    public String createQrImageAndGetQrString(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        //param 정보를 저장한 json 객체 생성
        JSONObject json = new JSONObject(param);

        //json 객체에 저장한 param 정보를 담을 Manager 모델 생성
        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId"))); // managerId 저장

        System.out.println("managerId : "+manager.getManagerId());
        String name = "";

        // 이름을 대입해서 QR 코드를 만든다
        // 생성한 QR 코드를 서버에 저장한다
        // QR 코드의 이름을 UUID로 생성한다
        try {
            UUID uuid = UUID.randomUUID();
            File file = null;
            // 큐알이미지를 저장할 디렉토리 지정
            // c://test//... 형태로 path를 지정
            name = uuid.toString();
            String path = "c://qcafe_image//QR//" + name +".jpg";

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("managerId",manager.getManagerId());
            System.out.println("name : "+jsonObject.get("managerId"));
            String qrDataString = jsonObject.toString();

            String codeurl = new String(qrDataString.getBytes("UTF-8"), "ISO-8859-1");

            int qrcodeColor =   0xFF2e4e96; // 큐알코드 바코드 생상값
            int backgroundColor = 0xFFFFFFFF;  // 큐알코드 배경색상값

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO를 사용한 바코드 파일쓰기

            ImageIO.write(bufferedImage, "jpg", new File(path));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // qr 이미지명을 DB에 저장한다
        manager.setQrImageName(name);

        try {
            managerService.updateQRImage(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject result = new JSONObject();

        result.put("qrImageName", return64baseQrImage(name));

        return result.toString();
    }
    @ResponseBody
    @PostMapping("/existQrTest")
    public String existQrTest(@RequestParam("param") String param) {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        // User 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId"))); // managerId 저장

        // user 내부값에 부합하는 데이터를 DB에서 가져오기 위한 코드
        // USer 리스트인 uList 내에 user 내부값에 부합하는 데이터들을 저장

        List<Manager> mList = managerService.getManagerListForImage(manager);



        JSONObject result = new JSONObject();
        result.put("code", "N");
        // User u 객체를 만들고 uList 의 길이만큼 u 내부에 uList 원소들을 대입하면서 반복문을 진행
        for (Manager m : mList) {
            if(m.getQrImageName()==null){
                result.put("code", "N");
            }
            else{
                System.out.println("if 속 : getQrImageName() = "+m.getQrImageName());
                result.put("code", "Y");
            }
        }

        return result.toString();
    }


    // qr이미지 이름 - 중간에 Base64로 이미지 변환하는 코드가 있으니 필기 + 참고할것
    @ResponseBody
    @PostMapping("/sendImageTest")
    public String sendImageTest (@RequestParam("param") String param) throws IOException {
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

        List<Manager> mList = managerService.getQrImageName(manager);

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            result.put("qrImageName", m.getQrImageName());
        }

        result.put("code",return64baseQrImage(String.valueOf(result.get("qrImageName"))));

        return result.toString();
    }

    //Manager 모델의 managerId, managerStoreName, qrImage 를 반환하는 컨트롤러
    @ResponseBody
    @PostMapping("/sendMultiDataTest")
    public String sendMultiDataTest(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

        System.out.println("In sendMultiDataTest _ manager_id : " + manager.getManagerId());

        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        List<Manager> mList = managerService.getStoreSource(manager);

        JSONArray jsonArray = new JSONArray();

        //여기서 result 선언하지마라 이 구데기야
        for (Manager m : mList) {
            JSONObject result = new JSONObject(); // 여기서 선언해라 구데기야

//            System.out.println("qr이미지네임 : "+m.getQrImageName());
            result.put("managerId", m.getManagerId());
            result.put("storeName", m.getStoreName());
//            if(m.getQrImageName()==null){
//
//            }
//            else{
//                result.put("qrImageName", return64baseQrImage(m.getQrImageName()));
//            }
            result.put("qrImageName", return64baseQrImage(m.getQrImageName()));
            jsonArray.put(result);
        }

        JSONObject sendData = new JSONObject();
        //JSONObject 에 jsonArray를 값으로 넣어준 것
        sendData.put("data", jsonArray);

        return sendData.toString();
    }

    //Manager 모델의 StampImage, admin_user의 count를 반환하는 컨트롤러
    @ResponseBody
    @PostMapping("/getQrImage")
    public String sendQrImage(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

//        System.out.println("manager_id : " + manager.getManagerId())
//        System.out.println("여기는 getStampImage");

        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        List<Manager> mList = managerService.getQrImageName(manager);

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            System.out.println("getQr어쩌구 : "+m.getQrImageName());
            result.put("qrImageName", return64baseQrImage(m.getQrImageName()));
        }

        return result.toString();
    }

    //Manager 모델의 StampImage, admin_user의 count를 반환하는 컨트롤러
    @ResponseBody
    @PostMapping("/getStampImage")
    public String sendStampImage(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

//        System.out.println("manager_id : " + manager.getManagerId())
//        System.out.println("여기는 getStampImage");

        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        List<Manager> mList = managerService.getStampImageName(manager);

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            System.out.println("getStamp어쩌구 : "+m.getStampImageNewName());
            result.put("stampImageNewName", return64baseStampImage(m.getStampImageNewName()));
        }

        return result.toString();
    }

    //Manager 모델의 StampImage, admin_user의 count를 반환하는 컨트롤러
    @ResponseBody
    @PostMapping("/getCouponMaxCount")
    public String getCouponMaxCount(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));


        List<Manager> mList = managerService.getManagerList(manager);

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            System.out.println("getCouponMax어쩌구 : "+m.getCouponMaxCount());
            result.put("couponMaxCount", m.getCouponMaxCount() );
        }

        return result.toString();
    }

    //Manager 모델의 StampImage, admin_user의 count를 반환하는 컨트롤러
    @ResponseBody
    @PostMapping("/getStoreSourceForUserAppFrag1")
    public String getStoreSourceForUserAppFrag1(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));


        List<Manager> mList = managerService.getManagerListForImage(manager);

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            System.out.println("스토어네임어쩌구 : "+m.getStoreName());
            if(m.getStoreName()!=null){
                result.put("storeName", m.getStoreName());
            }
            else{
                result.put("storeName", "");
            }

            System.out.println("getStore어쩌구 : "+m.getStoreImageNewName());
            if(m.getStoreImageNewName()!=null){
                result.put("storeImageNewName", return64baseStoreImage(m.getStoreImageNewName()));
            }
            else{
                result.put("storeImageNewName", "");
            }

            System.out.println("getStamp어쩌구 : "+m.getStampImageNewName());
            if(m.getStampImageNewName()!=null){
                result.put("stampImageNewName", return64baseStampImage(m.getStampImageNewName()));
            }
            else{
                result.put("stampImageNewName", "");
            }



            System.out.println("getCouponMax어쩌구 : "+m.getCouponMaxCount());
            result.put("couponMaxCount", m.getCouponMaxCount() );

        }

        return result.toString();
    }


    @ResponseBody
    @PostMapping("/getStoreImage")
    public String sendStoreImage(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

//        System.out.println("manager_id : " + manager.getManagerId())
//        System.out.println("여기는 getStampImage");

        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        List<Manager> mList = managerService.getStoreImageName(manager);

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            System.out.println("getStore어쩌구 : "+m.getStoreImageNewName());
            result.put("storeImageNewName", return64baseStoreImage(m.getStoreImageNewName()));
        }

        return result.toString();
    }

    //매장 이름 얻기
    @ResponseBody
    @PostMapping("/getStoreName")
    public String sendStoreName(@RequestParam("param") String param){
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

        // User 객체를 만들어서 param 값이 들어있는 json 내부 값들을 저장
        Manager manager = new Manager();
        System.out.println("getStoreName 내부 : ");
        manager.setManagerId(String.valueOf(json.get("managerId")));

        // user 내부값에 부합하는 데이터를 DB에서 가져오기 위한 코드
        // USer 리스트인 uList 내에 user 내부값에 부합하는 데이터들을 저장
        List<Manager> mList = managerService.getStoreName(manager);

        //DB 내부에 존재하며 user 데이터값에 부합하는 컬럼의 수
        System.out.println("" + mList.size());

        JSONObject result = new JSONObject();
        for (Manager m : mList) {
            System.out.println("스토어네임어쩌구 : "+m.getStoreName());
            result.put("storeName", m.getStoreName());
        }

        return result.toString();
    }

    @ResponseBody
    @PostMapping("/getMenuMultiDataTest")
    public String sendMenuMultiDataTest(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);
//        Manager manager = new Manager();
//        manager.setManagerId(String.valueOf(json.get("managerId")));
        Menu menu = new Menu();
        menu.setManagerId(String.valueOf(json.get("managerId")));
        List<Menu> mList = menuService.getMenuList(menu);

        JSONArray jsonArray = new JSONArray();
        for (Menu m : mList) {
            JSONObject result = new JSONObject();
            result.put("managerId", m.getManagerId());
            result.put("menuName", m.getMenuName());
            result.put("menuImageNewName", return64baseMenuImage(m.getMenuImageNewName()));
            result.put("menuPrice", m.getMenuPrice());
            result.put("menuExplain", m.getMenuExplain());
            jsonArray.put(result);
        }
        JSONObject sendData = new JSONObject();
        //JSONObject 에 jsonArray를 값으로 넣어준 것
        sendData.put("data", jsonArray);

        return sendData.toString();
    }

    @ResponseBody
    @PostMapping("/getMenuOne")
    public String sendMenuOne(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

//        Manager manager = new Manager();
//        manager.setManagerId(String.valueOf(json.get("managerId")));

        Menu menu = new Menu();
        menu.setManagerId(String.valueOf(json.get("managerId")));
        menu.setMenuName(String.valueOf(json.get("menuName")));

        System.out.println("In sendMenuOne _ manager_id : " + menu.getManagerId());
        System.out.println("In sendMenuOne _ menuName : " + menu.getMenuName());


//        System.out.println("manager_id : " + manager.getManagerId())
//        System.out.println("여기는 getStampImage");

        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        List<Menu> mList = menuService.getMenuOne(menu);

        JSONArray jsonArray = new JSONArray();
        //여기서 result 선언하지마라 이 구데기야
        for (Menu m : mList) {
            JSONObject result = new JSONObject(); // 여기서 선언해라 구데기야

//            System.out.println("qr이미지네임 : "+m.getQrImageName());
            result.put("managerId", m.getManagerId());
            result.put("menuName", m.getMenuName());
            result.put("menuImageNewName", return64baseMenuImage(m.getMenuImageNewName()));
            result.put("menuPrice", m.getMenuPrice());
            result.put("menuExplain", m.getMenuExplain());

            System.out.println("In sendMenuOne _ menuName : " + menu.getMenuName());
            System.out.println("In sendMenuOne _ menuPrice : " + menu.getMenuPrice());
            System.out.println("In sendMenuOne _ menuExplain : " + menu.getMenuExplain());

//            System.out.println("managerId : "+ m.getManagerId());
//            System.out.println("menuName" + m.getMenuName());
//            System.out.println("menuImageNewName"+ return64baseMenuImage(m.getMenuImageNewName()));
//            System.out.println("menuPrice"+ m.getMenuPrice());
//            System.out.println("menuExplain"+ m.getMenuExplain());

            jsonArray.put(result);
        }

        JSONObject sendData = new JSONObject();
        //JSONObject 에 jsonArray를 값으로 넣어준 것
        sendData.put("data", jsonArray);

        return sendData.toString();
    }

    @ResponseBody
    @PostMapping("/getPictureMultiDataTest")
    public String sendPictureMultiDataTest(@RequestParam("param") String param) throws IOException {
        // System.out.println("param : " + param);
        JSONObject json = new JSONObject(param);

//        Manager manager = new Manager();
//        manager.setManagerId(String.valueOf(json.get("managerId")));

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));

//        System.out.println("manager_id : " + manager.getManagerId())
//        System.out.println("여기는 getStampImage");

        // 전송받은 param에 부합하는 값을 Service 내부 기능에 맞게 DB에서 얻어냈으므로 그 결과를 다시 Client에 전송.
        // result 는 결과값 전송에 쓰일 JSONObject 변수
        List<Manager> mList = managerService.getManagerListForImage(manager);

        JSONArray jsonArray = new JSONArray();
        //여기서 result 선언하지마라 이 구데기야
        for (Manager m : mList) {
            JSONObject result = new JSONObject(); // 여기서 선언해라 구데기야

//            System.out.println("qr이미지네임 : "+m.getQrImageName());
            result.put("managerId", m.getManagerId());
            result.put("qrImageName", return64baseQrImage(m.getQrImageName()));

            jsonArray.put(result);
        }

        JSONObject sendData = new JSONObject();
        //JSONObject 에 jsonArray를 값으로 넣어준 것
        sendData.put("data", jsonArray);

        return sendData.toString();
    }


    @ResponseBody
    @PostMapping("/menuEditTest")
    public String setEditMenuData(@RequestParam("param") String param) throws IOException {
        JSONObject json = new JSONObject(param);

        Menu menu = new Menu();
        menu.setManagerId(String.valueOf(json.get("managerId")));
        menu.setMenuName(String.valueOf(json.get("menuName")));
        menu.setMenuPrice(Integer.parseInt(String.valueOf(json.get("menuPrice"))));
        menu.setMenuExplain(String.valueOf(json.get("menuExplain")));

        System.out.println("managerId : "+menu.getManagerId());
        System.out.println("menuName : "+menu.getMenuName());
        System.out.println("menuPrice : "+menu.getMenuPrice());
        System.out.println("menuExplain : "+menu.getMenuExplain());

//        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
//        UUID uuid = UUID.randomUUID();
//
//        // 1. C드라이브 특정 위치에 파일을 저장 (UUID 를 이용하여 이름을 변환할것)
//        // 2. 원본 파일 이름과 변환한 파일 이름을 DB에 저장
//        // c://test//temp_2021_09_13_02_48_13.jpeg 형태로 path를 지정
//        String name = uuid.toString();
//        String path = "c://qcafe_image//StoreImage//" + name + ".jpg";
//
//        // path 경로에 File 형태로 저장한다.
//        mFile.transferTo(new File(path));

        try {
            menuService.updateMenuData(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String code = "Y";
        String msg = "회원가입에 성공하였습니다.";
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);

        return result.toString();
    }

    @ResponseBody
    @PostMapping("/editStoreNameTest")
    public String editStoreNameTest(@RequestParam("param") String param) throws IOException {
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));
        manager.setStoreName(String.valueOf(json.get("storeName")));
        Menu menu = new Menu();

//        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
//        UUID uuid = UUID.randomUUID();
//
//        // 1. C드라이브 특정 위치에 파일을 저장 (UUID 를 이용하여 이름을 변환할것)
//        // 2. 원본 파일 이름과 변환한 파일 이름을 DB에 저장
//        // c://test//temp_2021_09_13_02_48_13.jpeg 형태로 path를 지정
//        String name = uuid.toString();
//        String path = "c://qcafe_image//StoreImage//" + name + ".jpg";
//
//        // path 경로에 File 형태로 저장한다.
//        mFile.transferTo(new File(path));
        try {
            managerService.updateStoreName(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String code = "Y";
        String msg = "회원가입에 성공하였습니다.";
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);

        return result.toString();
    }

    @ResponseBody
    @PostMapping("/editStoreMaxCount")
    public String editStoreMaxCount(@RequestParam("param") String param) throws IOException {
        JSONObject json = new JSONObject(param);

        Manager manager = new Manager();
        manager.setManagerId(String.valueOf(json.get("managerId")));
        manager.setCouponMaxCount(Integer.parseInt(String.valueOf(json.get("couponMaxCount"))));


        try {
            managerService.updateCouponCount(manager);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String code = "Y";
        String msg = "최대 쿠폰 카운트 변경에 성공하였습니다.";
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);

        return result.toString();
    }

    @ResponseBody
    @PostMapping("/menuInsetTest")
    public String setAddMenuData(@RequestParam("param") String param) throws IOException {
        JSONObject json = new JSONObject(param);

        Menu menu = new Menu();
        menu.setManagerId(String.valueOf(json.get("managerId")));
        menu.setMenuName(String.valueOf(json.get("menuName")));
        menu.setMenuPrice(Integer.parseInt(String.valueOf(json.get("menuPrice"))));
        menu.setMenuExplain(String.valueOf(json.get("menuExplain")));

        System.out.println("managerId : "+menu.getManagerId());
        System.out.println("menuName : "+menu.getMenuName());
        System.out.println("menuPrice : "+menu.getMenuPrice());
        System.out.println("menuExplain : "+menu.getMenuExplain());

        try {
            menuService.insertMenuSimple(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String code = "Y";
        String msg = "회원가입에 성공하였습니다.";
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);

        return result.toString();
    }

    @ResponseBody
    @PostMapping("/deleteMenu")
    public String deleteMenu(@RequestParam("param") String param) throws IOException {
        JSONObject json = new JSONObject(param);

        Menu menu = new Menu();
        menu.setManagerId(String.valueOf(json.get("managerId")));
        menu.setMenuName(String.valueOf(json.get("menuName")));

        System.out.println("managerId : "+menu.getManagerId());
        System.out.println("menuName : "+menu.getMenuName());

//        // uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
//        UUID uuid = UUID.randomUUID();
//
//        // 1. C드라이브 특정 위치에 파일을 저장 (UUID 를 이용하여 이름을 변환할것)
//        // 2. 원본 파일 이름과 변환한 파일 이름을 DB에 저장
//        // c://test//temp_2021_09_13_02_48_13.jpeg 형태로 path를 지정
//        String name = uuid.toString();
//        String path = "c://qcafe_image//StoreImage//" + name + ".jpg";
//
//        // path 경로에 File 형태로 저장한다.
//        mFile.transferTo(new File(path));

        try {
            menuService.deleteMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String code = "Y";
        String msg = "delete에 성공하였습니다.";
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);

        return result.toString();
    }


    // 폴더에 있는 이미지 파일을 64baseString 형태로 반환하는 함수들
    public String return64baseQrImage(String qrImageName) throws IOException {
        File f1 = new File("c://qcafe_image//QR//"+qrImageName+".jpg");

        //Image file to 64baseString
        FileInputStream fis = new FileInputStream(f1);
        byte byteArray[] = new byte[(int)f1.length()];
        fis.read(byteArray);
        String imageString = Base64.encodeBase64String(byteArray);

        fis.close();

        return imageString;
    }





    public String return64baseStoreImage(String storeImageName) throws IOException {
        File f1 = new File("c://qcafe_image//StoreImage//"+storeImageName+".jpg");

        //Image file to 64baseString
        FileInputStream fis = new FileInputStream(f1);
        byte byteArray[] = new byte[(int)f1.length()];
        fis.read(byteArray);
        String imageString = Base64.encodeBase64String(byteArray);

//        System.out.println("imageString : "+ imageString);

        fis.close();

        return imageString;
    }
    public String return64baseStampImage(String stampImageName) throws IOException {
        File f1 = new File("c://qcafe_image//Stamp//"+stampImageName+".jpg");

        //Image file to 64baseString
        FileInputStream fis = new FileInputStream(f1);
        byte byteArray[] = new byte[(int)f1.length()];
        fis.read(byteArray);
        String imageString = Base64.encodeBase64String(byteArray);

//        System.out.println("imageString : "+ imageString);

        fis.close();

        return imageString;
    }
    public String return64baseMenuImage(String menuImageName) throws IOException {
        File f1 = new File("c://qcafe_image//MenuImage//"+menuImageName+".jpg");

        //Image file to 64baseString
        FileInputStream fis = new FileInputStream(f1);
        byte byteArray[] = new byte[(int)f1.length()];
        fis.read(byteArray);
        String imageString = Base64.encodeBase64String(byteArray);

//        System.out.println("imageString : "+ imageString);

        fis.close();

        return imageString;
    }
}
