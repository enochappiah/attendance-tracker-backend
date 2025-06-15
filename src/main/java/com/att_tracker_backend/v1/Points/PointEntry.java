package com.att_tracker_backend.v1.Points;

import com.att_tracker_backend.v1.Event.Event;
import com.att_tracker_backend.v1.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PointEntry {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private User user;

  @ManyToOne
  private Event event;

  private int pointsEarned;
  private LocalDateTime earnedAt;
}
