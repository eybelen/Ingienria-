package com.xavia.ris.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;

@Entity
@Table(
  name = "Usuario",
  uniqueConstraints = @UniqueConstraint(columnNames = "correo")
)
public class Usuario implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  private String foto;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String correo;

  @Column(nullable = false)
  private String rol;

  @Column(nullable = false)
  private String password;

  public Usuario() {}

  public Usuario(
    Long id,
    String foto,
    String username,
    String correo,
    String rol,
    String password
  ) {
    this.id = id;
    this.foto = foto;
    this.username = username;
    this.correo = correo;
    this.rol = rol;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFoto() {
    return foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
