package org.scaler.bookmyshow_backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private int amount;
    private String referenceId;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
