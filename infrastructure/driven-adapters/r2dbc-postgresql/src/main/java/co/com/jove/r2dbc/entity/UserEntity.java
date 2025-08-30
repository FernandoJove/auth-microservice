package co.com.jove.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table("usuario")
public class UserEntity {
    @Id
    @Column("id_usuario")
    private UUID id;

    @Column("nombre")
    private String name;

    @Column("apellido")
    private String lastname;

    @Column("email")
    private String email;

    @Column("telefono")
    private int phoneNumber;

    @Column("documento_identidad")
    private int dni;

    @Column("salario_base")
    private BigDecimal salary;

    @Column("birth_date")
    private LocalDate birthDate;

    @Column("id_rol")
    private UUID idRole;

    @Column("created_at")
    private LocalDate createdAt;

    @Column("updated_at")
    private LocalDate updatedAt;




}
