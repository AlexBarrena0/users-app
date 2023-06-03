package edu.uoc.abarrena.users.infrastructure.repository.mybatis.provider;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.TravelerEntity;

public class TravelerEntitySqlProvider {

    public String update(TravelerEntity travelerEntity) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE TRAVELER SET ");
        if (travelerEntity.getMedicalCertificateId() != null) {
            sql.append("MEDICAL_CERTIFICATE_ID = #{medicalCertificateId}, ");
        }
        if (travelerEntity.getDivingCertificationId() != null) {
            sql.append("DIVING_CERTIFICATION_ID = #{divingCertificationId}, ");
        }
        if (travelerEntity.getDivingInsuranceId() != null) {
            sql.append("DIVING_INSURANCE_ID = #{divingInsuranceId}, ");
        }
        sql.delete(sql.length() - 2, sql.length());
        sql.append(" WHERE ID = #{id}");
        return sql.toString();
    }
}
