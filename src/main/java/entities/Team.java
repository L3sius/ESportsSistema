package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Entity
// Pridedam query užklausą, kad galima būtų perpanaudoti ir nekopijuoti.
@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "select t from Team as t")
})
@Table(name = "TEAM")
@Getter @Setter
public class Team {

    public Team(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //Undirectional
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}