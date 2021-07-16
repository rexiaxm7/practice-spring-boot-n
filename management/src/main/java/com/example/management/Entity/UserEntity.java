package com.example.management.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_info")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "email", "password" })
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;
  @Column(name = "login_id", length = 120, nullable = false, unique = true)
  public String email;
  @Column(name = "name", length = 60, nullable = false)
  public String name;
  @Column(name = "password", length = 120, nullable = false)
  public String password;
  @Column(name = "role", length = 120)
  public String roles;
  @Column(name = "delete_flg", nullable = false)
  public int enable;
}
