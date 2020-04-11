package com.lm.springsecurity.repository;

import com.lm.springsecurity.model.LmUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author lm
 * @description TODO
 * @date 2020/4/6 10:13
 */
public interface UserInfoRepository extends JpaRepository<LmUserDetails,Long> {

    @Query(value = "select id,user_name,password,insert_time,update_time from user_info where user_name=?1",nativeQuery = true)
    LmUserDetails findByUserName(String username);

}
