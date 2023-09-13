package med.voll.api.paciente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.direction.Direction;
import med.voll.api.paciente.dto.DataRegisterPaciente;
import med.voll.api.paciente.dto.DataUpdatePaciente;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "paciente")
@Table(name = "pacientes")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String doc_identify;
    @Embedded
    private Direction address;

    private boolean active;

    public Paciente(DataRegisterPaciente dataRegisterPaciente) {
        this.name = dataRegisterPaciente.name();
        this.email = dataRegisterPaciente.email();
        this.phone = dataRegisterPaciente.phone();
        this.doc_identify = dataRegisterPaciente.docIdentify();
        this.address = new Direction(dataRegisterPaciente.address());
        this.active = true;
    }


    public void updateData(DataUpdatePaciente data) {
        if (data.name() != null) this.name = data.name();
        if (data.phone() != null) this.phone = data.phone();
        if (data.address() != null) this.address = address.updateAddr(data.address());
    }

    public void updateActive() {
        this.active = false;
    }

}
