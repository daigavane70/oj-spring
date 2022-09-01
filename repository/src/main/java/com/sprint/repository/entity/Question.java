package com.sprint.repository.entity;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long contestId;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    List<String> problemStatement;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    List<String> constraints;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    List<String> testCases;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    List<String> sampleTests;
    int maxScore;
}
