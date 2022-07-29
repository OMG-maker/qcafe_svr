package kr.omg.qcafe.model;

public class Menu {
    private String managerId;
    private String menuName;
    private String menuExplain;
    private String menuImageNewName;
    private String menuImageOriginalName;
    private int menuPrice;


    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuImageNewName() {
        return menuImageNewName;
    }

    public void setMenuImageNewName(String menuImageNewName) {
        this.menuImageNewName = menuImageNewName;
    }

    public String getMenuImageOriginalName() {
        return menuImageOriginalName;
    }

    public void setMenuImageOriginalName(String menuImageOriginalName) {
        this.menuImageOriginalName = menuImageOriginalName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuExplain() {
        return menuExplain;
    }

    public void setMenuExplain(String menuExplain) {
        this.menuExplain = menuExplain;
    }

}
