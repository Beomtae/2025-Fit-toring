package fittoring.mentoring.business.service.dto;

public record ReviewStats(
        Long mentoringId,
        Double reviewAverage,
        long reviewCount
) {

    private static final double DEFAULT_REVIEW_AVERAGE = 0.0;
    private static final int DEFALUT_REVIEW_COUNT = 0;

    public static ReviewStats defaultOf(Long mentoringId) {
        return new ReviewStats(mentoringId, DEFAULT_REVIEW_AVERAGE, DEFALUT_REVIEW_COUNT);
    }
}
