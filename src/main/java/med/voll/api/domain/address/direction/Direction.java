package med.voll.api.domain.address.direction;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.DataDirection;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direction {
    private String street;
    private String distrito;
    private String city;
    private Integer number;
    private String complement;

    public Direction(DataDirection address) {
        this.street = address.street();
        this.distrito = address.distrito();
        this.city = address.city();
        this.number = Integer.valueOf(address.number());
        this.complement = address.complement();
    }

    public Direction updateAddr(DataDirection address) {
        this.street = address.street();
        this.distrito = address.distrito();
        this.city = address.city();
        this.number = Integer.valueOf(address.number());
        this.complement = address.complement();
        return this;
    }
}
