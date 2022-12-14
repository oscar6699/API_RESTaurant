package com.Restaurant.API.repository;

import com.Restaurant.API.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Transactional
    @Modifying
    @Query(value = "{call CLIENTE_BD.INSERTAR_CLI(:v_rutcliente,:v_nombre,:v_apellido,:v_telefono,:v_login)}",nativeQuery = true)
    void saveProcedure(
            @Param("v_rutcliente")String v_rutcliente,
            @Param("v_nombre")String v_nombre,
            @Param("v_apellido")String v_apellido,
            @Param("v_telefono")int v_telefono,
            @Param("v_login")int v_login
    );

    @Transactional
    @Modifying
    @Query(value = "{call CLIENTE_BD.ELIMINAR_CLI(:v_rutcliente)}",nativeQuery = true)
    void deleteCliente(@Param("v_rutcliente") String v_rutcliente );

}
