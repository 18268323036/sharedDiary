package com.heartBar.sharedDiary.repository;


import com.heartBar.sharedDiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangxy 2017/12/5 10:19
 */
public interface UserRepository extends JpaRepository<User,Long>{

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);


}
