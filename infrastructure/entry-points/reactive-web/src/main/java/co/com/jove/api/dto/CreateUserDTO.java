package co.com.jove.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

        @NotBlank
        @NotNull
        @Size(max = 8)
        BigDecimal salary,


                             Integer dni,
                             Integer phoneNumber,
                             UUID idRole,

                             LocalDate createdAt,
                             LocalDate updatedAt) {
}
