package com.ERP.models.supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity(name="suppliers")
@Table(name="suppliers")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Supplier implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String address;
    private String telephone;
    private String email;
}
