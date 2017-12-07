package com.heartBar.sharedDiary;

/**
 * @author zhangxy 2017/12/6 15:48
 */
public class Test {

    public static void main(String[] args) {
        UserManager userManager = (UserManager) new CGLibProxy().createProxyObject(new UserManagerImpl());
        System.out.println("CGLibProxy");
        userManager.addUser("12","2323");
        System.out.println("JDKProxy");
        JdkProxy jdkPrpxy = new JdkProxy();
        UserManager userManagerJDK = (UserManager) jdkPrpxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("tom", "root");
    }
}
