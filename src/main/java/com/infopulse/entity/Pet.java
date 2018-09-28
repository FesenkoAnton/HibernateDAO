package com.infopulse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="pets")
@Inheritance(strategy = SINGLE_TABLE)
//@DiscriminatorColumn(name="Typecli", discriminatorType=STRING, length=20)
//@DiscriminatorValue("PET")
public class Pet {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(name="name", unique=false,nullable = false, length = 100)
    @Basic
    private String name;

    @Column(name = "animal",unique = false,nullable = false,length = 100)
    @Basic
    private String animal;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    Owner owner;


}
