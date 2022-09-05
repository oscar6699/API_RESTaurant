package com.Restaurant.API.repository;

import com.Restaurant.API.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    @Transactional
    @Modifying
    @Query(value = "{CALL LOGIN_BD.INSER_LOGIN(:v_nombre,:v_pass)}",nativeQuery = true)
    void saveProcedure(
            @Param("v_nombre")String v_nombre,
            @Param("v_pass")String v_pass
    );

    @Transactional
    @Modifying
    @Query(value = "{call LOGIN_BD.ELIMINAR_LOGIN(:id)}",nativeQuery = true)
    void deleteLogin(@Param("id") int id );
}
