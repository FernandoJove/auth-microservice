package co.com.jove.model.user;
import lombok.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

    private UUID id;

    private String name;
    private String lastname;
    private String email;

    private Integer dni;
    private Integer phoneNumber;

    private UUID idRole;
    private BigDecimal salary;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public User(String email) {
        this.email = email;
    }

}
