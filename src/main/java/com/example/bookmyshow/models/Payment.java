package com.example.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    private String referenceId;
}
