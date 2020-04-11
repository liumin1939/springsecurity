package com.lm.springsecurity.repository;

import com.lm.springsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description TODO
 * @Author lm
 * @Date 2020/4/7 9:36
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "select r.id,r.role_name from user_role_relation ur inner join role_info r on ur.role_id=r.id where ur.user_id=?1 ",nativeQuery = true)
    List<Role> findByUserId(Long userId);

    @Query(value = "select r.id,r.role_name from sys_role_menu rm inner join role_info r on rm.role_id=r.id " +
            "inner join sys_menu m  on rm.menu_id=m.id where m.menu_url=?1 ",nativeQuery = true)
    List<Role> findByUrl(String url);

}
