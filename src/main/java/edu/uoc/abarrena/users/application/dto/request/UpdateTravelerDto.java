package edu.uoc.abarrena.users.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTravelerDto {

    private Long id;
    private Long medicalCertificateId;
    private Long divingCertificationId;
    private Long divingInsuranceId;
}
