package co.com.jove.model.user;
import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

    private Long idNumber;

    private String name;
    private String lastname;
    private String email;

    private Integer dni;
    private Integer phoneNumber;

    private Integer idRole;
    private Double salary;
}
