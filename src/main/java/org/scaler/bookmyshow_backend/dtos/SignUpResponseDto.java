package org.scaler.bookmyshow_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.bookmyshow_backend.models.User;

@Getter
@Setter
public class SignUpResponseDto {
    private User user;
}
