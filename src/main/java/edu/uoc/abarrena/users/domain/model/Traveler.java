package edu.uoc.abarrena.users.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Traveler extends User {

    private Long medicalCertificateId;
    private Long divingCertificationId;
    private Long divingInsuranceId;
}
