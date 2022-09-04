package com.Restaurant.API.entity;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(name = "CliInfo", classes = @ConstructorResult(targetClass = Cliente.class, columns = {
        @ColumnResult(name = "RUTCLIENTE", type = String.class),
        @ColumnResult(name = "NOMBRE", type = String.class),
        @ColumnResult(name = "TELEFONO", type = Integer.class),
        @ColumnResult(name = "ESTADO", type = String.class)
}))
public class Cliente {
    public static final String NameQuery_LIST_CLIENTES = "listclientes";
    @Id
    private String RUTCLIENTE;
    private String NOMBRE;
    private int TELEFONO;
    private String ESTADO;

    public Cliente() {
    }

    public Cliente(String RUTCLIENTE, String NOMBRE, int TELEFONO, String ESTADO) {
        this.RUTCLIENTE = RUTCLIENTE;
        this.NOMBRE = NOMBRE;
        this.TELEFONO = TELEFONO;
        this.ESTADO = ESTADO;
    }

    public String getRUTCLIENTE() {
        return RUTCLIENTE;
    }

    public void setRUTCLIENTE(String RUTCLIENTE) {
        this.RUTCLIENTE = RUTCLIENTE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }
}
