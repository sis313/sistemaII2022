package com.example.mslogin.jwt;

public class JwtResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String refreshToken;
    private Integer idUsuario;
    private String nombre;
    private String correo;


    public JwtResponse(String accessToken, String refreshToken, Integer idUsuario, String nombre, String correo) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public JwtResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public JwtResponse setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
