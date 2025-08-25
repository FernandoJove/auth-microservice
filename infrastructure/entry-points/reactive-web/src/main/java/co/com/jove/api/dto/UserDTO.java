package co.com.jove.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record UserDTO(String name, String last,
                      String email, Integer dni,
                      Integer phoneNumber,
                      UUID idRole, BigDecimal salary,
                      LocalDate createdAt, LocalDate updatedAt) {
}
