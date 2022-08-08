package com.spring.student.model;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStudent;

    @Column(name = "name",length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_group")
    private groups studentGroup;

}
