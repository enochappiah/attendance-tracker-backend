package com.att_tracker_backend.v1.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
//  private String email;
//  private String password; // encrypted
//  private String role;
  private String name;



}
