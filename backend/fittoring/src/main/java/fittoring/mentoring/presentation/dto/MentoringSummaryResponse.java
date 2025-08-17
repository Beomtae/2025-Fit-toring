package fittoring.mentoring.presentation.dto;

import fittoring.mentoring.business.model.Image;
import fittoring.mentoring.business.model.Mentoring;
import fittoring.mentoring.business.service.dto.ReviewStatus;
import java.util.List;

public record MentoringSummaryResponse(
        long id,
        String mentorName,
        List<String> categories,
        int price,
        int career,
        String profileImageUrl,
        String introduction,
        double reviewAverage,
        long reviewCount
) {

    public static MentoringSummaryResponse of(Mentoring mentoring, List<String> categories, Image image,
                                              ReviewStatus reviewStatus) {
        if (image == null) {
            return MentoringSummaryResponse.of(mentoring, categories, reviewStatus);
        }
        return new MentoringSummaryResponse(
                mentoring.getId(),
                mentoring.getMentorName(),
                categories,
                mentoring.getPrice(),
                mentoring.getCareer(),
                image.getUrl(),
                mentoring.getIntroduction(),
                reviewStatus.reviewAverage(),
                reviewStatus.reviewCount()
        );
    }

    private static MentoringSummaryResponse of(Mentoring mentoring, List<String> categories,
                                               ReviewStatus reviewStatus) {
        return new MentoringSummaryResponse(
                mentoring.getId(),
                mentoring.getMentorName(),
                categories,
                mentoring.getPrice(),
                mentoring.getCareer(),
                null,
                mentoring.getIntroduction(),
                reviewStatus.reviewAverage(),
                reviewStatus.reviewCount()
        );
    }
}
