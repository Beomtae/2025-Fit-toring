package fittoring.mentoring.business.model;

import fittoring.mentoring.business.exception.BusinessErrorMessage;
import fittoring.mentoring.business.exception.InvalidStatusException;
import lombok.Getter;

@Getter
public enum Status {

    APPROVED,
    PENDING,
    REJECTED,
    COMPLETE,
    ;


    public void validate(Status updateStatus) {
        if (this == APPROVED || this == REJECTED || this == COMPLETE) {
            throw new InvalidStatusException(BusinessErrorMessage.RESERVATION_STATUS_ALREADY_UPDATE.getMessage());
        }
        if (this.equals(updateStatus)) {
            throw new InvalidStatusException(BusinessErrorMessage.RESERVATION_STATUS_ALREADY_EQUAL.getMessage());
        }
    }

    public boolean isPending() {
        return this.equals(PENDING);
    }
}
