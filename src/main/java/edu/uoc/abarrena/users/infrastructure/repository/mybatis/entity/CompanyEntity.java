package edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CompanyEntity extends UserEntity {

    private String CIF;
    private String name;
    private String address;
    private String description;
    private String phone;
    private String email;
}
