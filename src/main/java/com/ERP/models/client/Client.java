package com.ERP.models.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity(name="clients")
@Table(name="clients")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String telephone;
    private String email;
}
