package com.francoborzi.modulos.ejercicio2509.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String url;
    private final String usuario;
    private final String password;

    public ConnectionFactory(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, password);
    }
}
