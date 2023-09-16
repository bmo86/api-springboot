package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.address.direction.Direction;
import med.voll.api.domain.medico.dto.DataRegisterDoctor;
import med.voll.api.domain.medico.dto.DataUpdateDoctor;

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
    private boolean active = true;
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

    public void updateDoc(DataUpdateDoctor updateMed) {
        if (updateMed.name() != null) {
            this.name = updateMed.name();
        }
        if (updateMed.document() != null) {
            this.document = updateMed.document();
        }
        if (updateMed.address() != null) {
            this.address = address.updateAddr(updateMed.address());
        }



    }
    public void updateActive() {
        this.active = false;
    }
}
