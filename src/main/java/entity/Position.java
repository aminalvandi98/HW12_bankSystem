package entity;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "administrative_position")
    private String administrativePosition;

    public String getAdministrativePosition() {
        return administrativePosition;
    }

    public void setAdministrativePosition(String administrativePosition) {
        this.administrativePosition = administrativePosition;
    }
}
