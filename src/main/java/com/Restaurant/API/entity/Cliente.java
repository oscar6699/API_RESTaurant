package com.Restaurant.API.entity;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(name = "CliInfo", classes = @ConstructorResult(targetClass = Cliente.class, columns = {
        @ColumnResult(name = "RUT_CLIENTE", type = String.class),
        @ColumnResult(name = "NOMBRE_CLI", type = String.class),
        @ColumnResult(name = "NOMBRE_CLI", type = String.class),
        @ColumnResult(name = "TELEFONO_CLI", type = int.class),
        @ColumnResult(name = "LOGIN_USER_ID", type = int.class)
}))
public class Cliente {
    public static final String NameQuery_LIST_CLIENTES = "listclientes";
    @Id
    private String RUT_CLIENTE;
    private String NOMBRE_CLI;
    private String APELLIDO_CLI;
    private int TELEFONO_CLI;
    private int LOGIN_USER_ID;

    public Cliente() {
    }

    public Cliente(String RUT_CLIENTE, String NOMBRE_CLI, String APELLIDO_CLI, int TELEFONO_CLI, int LOGIN_USER_ID) {
        this.RUT_CLIENTE = RUT_CLIENTE;
        this.NOMBRE_CLI = NOMBRE_CLI;
        this.APELLIDO_CLI = APELLIDO_CLI;
        this.TELEFONO_CLI = TELEFONO_CLI;
        this.LOGIN_USER_ID = LOGIN_USER_ID;
    }

    public String getRUT_CLIENTE() {
        return RUT_CLIENTE;
    }

    public void setRUT_CLIENTE(String RUT_CLIENTE) {
        this.RUT_CLIENTE = RUT_CLIENTE;
    }

    public String getNOMBRE_CLI() {
        return NOMBRE_CLI;
    }

    public void setNOMBRE_CLI(String NOMBRE_CLI) {
        this.NOMBRE_CLI = NOMBRE_CLI;
    }

    public String getAPELLIDO_CLI() {
        return APELLIDO_CLI;
    }

    public void setAPELLIDO_CLI(String APELLIDO_CLI) {
        this.APELLIDO_CLI = APELLIDO_CLI;
    }

    public int getTELEFONO_CLI() {
        return TELEFONO_CLI;
    }

    public void setTELEFONO_CLI(int TELEFONO_CLI) {
        this.TELEFONO_CLI = TELEFONO_CLI;
    }

    public int getLOGIN_USER_ID() {
        return LOGIN_USER_ID;
    }

    public void setLOGIN_USER_ID(int LOGIN_USER_ID) {
        this.LOGIN_USER_ID = LOGIN_USER_ID;
    }
}
