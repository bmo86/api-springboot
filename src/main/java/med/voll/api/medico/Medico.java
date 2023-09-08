package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.address.DataDirection;
import med.voll.api.medico.direction.Direction;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    @Enumerated(EnumType.STRING)
    private Especialidad espacialidad;
    @Embedded
    private Direction address;


    public Medico(DataRegisterDoctor data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.document = data.document();
        this.espacialidad = data.espacialidad();
        this.address = new Direction(data.address());
    }
}
