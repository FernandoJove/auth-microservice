package co.com.jove.api.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateUserDTO (
        @NotBlank
        @NotNull
        @Size(max = 40)
        String name,

        @NotBlank
        @NotNull
        @Size(max = 40)
        String lastname,

        @NotBlank
        @NotNull
        @Email
        String email,

        @NotNull
        @DecimalMin(value = "0.01", inclusive = true)
        @DecimalMax(value = "15000000", inclusive = true)
        BigDecimal salary,


                             Integer dni,
                             Integer phoneNumber,
                             UUID idRole,

                             LocalDate createdAt,
                             LocalDate updatedAt) {
}
