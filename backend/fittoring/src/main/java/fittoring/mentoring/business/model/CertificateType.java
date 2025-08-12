package fittoring.mentoring.business.model;

import java.util.Arrays;

public enum CertificateType {

    LICENSE,
    EDUCATION,
    AWARD,
    ETC,
    ;

    public static boolean inValidCertificateType(String certificateTypeName) {
        return Arrays.stream(CertificateType.values())
                .anyMatch(certificateType -> certificateType.name().equalsIgnoreCase(certificateTypeName));
    }
}
