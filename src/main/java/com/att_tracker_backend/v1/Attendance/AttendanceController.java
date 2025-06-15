package com.att_tracker_backend.v1.Attendance;



import com.att_tracker_backend.v1.Points.PointEntryRepository;
import com.att_tracker_backend.v1.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class AttendanceController {
  private final UserRepository userRepository;
  private final PointEntryRepository pointEntryRepository;


  @GetMapping("/summary/{userId}")
  public ResponseEntity<Map<String, Object>> getSummary(@PathVariable Long userId) {
    return userRepository.findById(userId)
        .map(user -> {
          int total = pointEntryRepository.sumPointsByUserId(userId);
          int required = pointEntryRepository.sumRequiredPointsByUserId(userId);

          Map<String, Object> summary = Map.of(
              "userName", user.getName(),
              "totalPoints", total,
              "requiredPoints", required
          );

          return ResponseEntity.ok(summary);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
