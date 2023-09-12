package med.voll.api.medico;

public record ListDoctors(Long id, String name, String email, String document, Especialidad espacialidad) {

    public ListDoctors(Medico medico) {
        this(medico.getId(), medico.getName(), medico.getEmail(), medico.getDocument(), medico.getEspacialidad());
    }

}
