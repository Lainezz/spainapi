package com.es.spainapi.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "provincias")
public class Provincia extends BaseEntity<String> {


    @Id
    @Column(length = 2, nullable = false)
    private String cprov;
    @Column(length = 100, nullable = false)
    private String nprov;


    @Override
    public String getID() {
        return cprov;
    }

}
