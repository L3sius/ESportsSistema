package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

// Ši anotacija reiškia, kad klasė turi būti primappinta prie DB
@Entity
// Pridedam query užklausą, kad galima būtų perpanaudoti ir nekopijuoti.
@NamedQueries({
        @NamedQuery(name = "Player.findAll", query = "select a from Player as a")
})

@Table(name = "PLAYER")
@Getter @Setter
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    //Sujungiam su Team
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Player() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
