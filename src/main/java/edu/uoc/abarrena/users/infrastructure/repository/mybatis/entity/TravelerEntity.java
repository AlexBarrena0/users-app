package edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TravelerEntity extends UserEntity {

    private Long medicalCertificateId;
    private Long divingCertificationId;
    private Long divingInsuranceId;
}
