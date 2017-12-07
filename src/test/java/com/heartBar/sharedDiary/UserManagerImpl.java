package com.heartBar.sharedDiary;

/**
 * @author zhangxy 2017/12/6 14:32
 */
public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String id, String name) {
        System.out.println(".: 掉用了UserManagerImpl.addUser()方法！");
    }

    @Override
    public void delUser(String id) {
        System.out.println(".: 掉用了UserManagerImpl.delUser()方法！");
    }


}
