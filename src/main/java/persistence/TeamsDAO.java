package persistence;

import entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
//Data Access Object - DAO
public class TeamsDAO {

    @PersistenceContext
    private EntityManager em;

    //Vat čia panaudojam query parašyta prie team Entity
    public List<Team> loadAll() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Team team){
        this.em.persist(team);
    }

    public Team findOne(Integer id) {
        // Select from Team where id = id
        return em.find(Team.class, id);
    }
}
