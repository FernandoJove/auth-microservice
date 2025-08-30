package co.com.jove.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static co.com.jove.model.constants.ErrorConstants.*;

@Schema(name = "CreateUserRequest", description = "Payload to save new user")
public record CreateUserDTO (
        @NotBlank(message = EMPTY_NAME)
        @Size(max = 40, message = MAX_NAME)
        @Schema(example = "Adrian Roberto", description = "Both names can be in the same field with a max of 40 characters")
        String name,

        @NotBlank(message = EMPTY_LASTNAME)
        @Size(max = 40, message = MAX_LASTNAME)
        @Schema(example = "Montana Vaca", description = "Both lastnames can be in the same field with a max of 40 characters")
        String lastname,

        @NotBlank(message = EMPTY_EMAIL)
        @Email(message = INVALID_EMAIL)
        @Schema(example = "amontana@gmail.com", description = "Email have to be unique and not be repeatable")
        String email,

        @NotNull
        @DecimalMin(value = "0.00", message = SALARY_OUT_OF_RANGE)
        @DecimalMax(value = "15000000", message = SALARY_OUT_OF_RANGE)
        @Schema(example = "1500", description = "Salary has to be an amount between 0 and 15,000,000")
        BigDecimal salary,

        @NotNull(message = EMPTY_DNI)
        @Schema(example = "98765432", description = "Dni couldn't be empty")
        Integer dni,

        @NotNull(message = EMPTY_PHONE)
        @Schema(example = "987654321", description = "Phone couldn't be empty and just numeric values")
        Integer phoneNumber,

        @Schema(description = "You will be assigned the 'User' role by default")
        UUID idRole,

        LocalDate createdAt,
        LocalDate updatedAt) {
}
