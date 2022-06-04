package com.example.banksystem.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Bank {

    @Id
    @NotNull(message = "Id is required !")
    private Integer id;

    @NotEmpty(message = "Name is required !")
    private String name;

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
    private Set<Customer> customer;
}
