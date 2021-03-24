package usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import entities.Player;
import entities.Team;
import lombok.Getter;
import lombok.Setter;
import persistence.PlayersDAO;
import persistence.TeamsDAO;


@Model
public class PlayersForTeam implements Serializable {

    @Inject
    private TeamsDAO teamsDAO;

    @Inject
    private PlayersDAO playersDAO;

    @Getter @Setter
    private Team team;

    @Getter @Setter
    private Player playerToCreate = new Player();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer teamId = Integer.parseInt(requestParameters.get("teamId"));
        this.team = teamsDAO.findOne(teamId);
    }

    @Transactional
    public String createPlayer() {
        playerToCreate.setTeam(this.team);
        playersDAO.persist(playerToCreate);
        return "playersPage?faces-redirect=true&teamId=" + this.team.getId();
    }
}