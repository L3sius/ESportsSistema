package persistence;

import entities.TeamEntity;

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
    public List<TeamEntity> loadAll() {
        System.out.println("HELP ME " + em.createNamedQuery("TeamEntity.findAll", TeamEntity.class).getResultList());
        return em.createNamedQuery("TeamEntity.findAll", TeamEntity.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(TeamEntity team){
        this.em.persist(team);
    }

    public TeamEntity findOne(Integer id) {
        // Select from Team where id = id
        return em.find(TeamEntity.class, id);
    }
    public TeamEntity update(TeamEntity team){
        return em.merge(team);
    }
}
