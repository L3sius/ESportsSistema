package persistence;

import entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
//Data Access Object - DAO
public class TeamsDAO {

    @Inject
    private EntityManager em;

    //Vat čia panaudojam query parašyta prie teamEntity
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
    public Team update(Team team){
        return em.merge(team);
    }
}
