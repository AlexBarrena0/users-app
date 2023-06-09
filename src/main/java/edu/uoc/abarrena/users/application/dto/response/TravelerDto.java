package edu.uoc.abarrena.users.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TravelerDto {

    private Long id;
    private Long medicalCertificateId;
    private Long divingCertificationId;
    private Long divingInsuranceId;
}
