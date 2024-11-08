package com.example.demo.validation;

import com.example.demo.domain.ChargeDetailRecord;
import com.example.demo.port.outbound.ChargeDetailRecordStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.Optional;


@RequiredArgsConstructor
public class CreationStartTimeBiggerLastRecordEndTimeValidator implements ValidationRule<ChargeDetailRecord> {


    private final ChargeDetailRecordStorage chargeDetailRecordStorage;

    public static <T> T getLastElement(final Iterable<T> elements) {
        T lastElement = null;

        for (T element : elements) {
            lastElement = element;
        }

        return lastElement;
    }

    @Override
    public Optional<FieldError> validate(ChargeDetailRecord chargeDetailRecord, Long id) {
        Iterable<ChargeDetailRecord> allRecords = chargeDetailRecordStorage.findAll();
        ChargeDetailRecord lastElement = getLastElement(allRecords);

        if (allRecords != null && lastElement != null) {
            if (lastElement.getEndTime().isBefore(chargeDetailRecord.getStartTime())) {
                return Optional.of(
                        new FieldError("ChargeDetailRecord", "StartTime",
                                " The Start time of an upcoming Charge Detail Record for a particular vehicle \n" +
                                        "must always be bigger than the End time of any previous Charge Detail " +
                                        "Records")
                );
            }

        }
        return Optional.empty();

    }

}
