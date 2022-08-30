package com.sprint.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contest")
public class Contest {
    @Id
    Long id;
    String name;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
