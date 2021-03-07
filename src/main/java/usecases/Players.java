package usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entities.Player;
import persistence.PlayersDAO;

@Model
public class Players implements Serializable {

    @Inject
    private PlayersDAO playersDAO;

    private Player playerToCreate = new Player();


    private List<Player> allPlayers;
    @PostConstruct
    public void init(){
        loadPlayers();
    }

    public void loadPlayers() {
//        TODO this is a mock implementation - later we will connect it to real data store
//        List<Player> players = new ArrayList<Player>();
//        players.add(new Player("Jordan"));
//        players.add(new Player("Kobe"));
//        this.allPlayers = players;
        this.allPlayers = playersDAO.loadAll();

    }

    public List<Player> getAllPlayers(){
        return allPlayers;
    }

    @Transactional
    public String createPlayer(){
        this.playersDAO.persist(playerToCreate);
        return "success";
    }

    public Player getPlayerToCreate() {
        return playerToCreate;
    }

    public void setPlayerToCreate(Player playerToCreate) {
        this.playerToCreate = playerToCreate;
    }

}
