package persistence;

import entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@RequestScoped - This means that an instance will be created only once for every request can be called with @Inject
    //For simple forms/presentations
//@SessionScoped - Basically the same as RequestScoped, but the instance will stay as long as the established HTTP session.
    //Best used for client specific data, such as the logged-in user and user preferences
//@ApplicationScoped - Lives as long as the web application runs.
    //Application wide data/constants, such as dropdown lists which are the same for everyone
@ApplicationScoped
public class PlayersDAO {

    @Inject
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Player player){
        this.em.persist(player);
    }
}
