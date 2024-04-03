package com.ERP.models.supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="suppliers")
@Table(name="suppliers")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Supplier {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String address;
    private String telephone;
    private String email;
}
