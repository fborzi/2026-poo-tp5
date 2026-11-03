package com.francoborzi.modulos.ejercicio2508;

package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;

public class ConnectionFactory implements Supplier<Connection> {

    private final String url;
    private final String usuario;
    private final String password;

    public ConnectionFactory(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public Connection get() {
        try {
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            throw new IllegalStateException(
                    "no se pudo establecer la conexion", e);
        }
    }
}
