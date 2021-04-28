package usecases;

import entities.TeamEntity;
import lombok.Getter;
import lombok.Setter;
import persistence.TeamsDAO;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Teams {

    //@Inject looks at the component’s TeamsDAO scope, takes corresponding context and if finds instance of component TeamsDAO, uses it.
    // Otherwise creates a new instance of TeamsDAO, puts it to this context, and returns to component "Teams"
    // Component is a piece of software, which is reusable.
    @Inject
    private TeamsDAO teamsDAO;

    //Subindintas JSF input forma su backend bean
    @Getter @Setter
    private TeamEntity teamToCreate = new TeamEntity();

    @Getter
    private List<TeamEntity> allTeams;

    @PostConstruct
    public void init(){
        loadAllTeams();
    }

    @Transactional
    public String createTeam(){
        this.teamsDAO.persist(teamToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllTeams(){
        this.allTeams = teamsDAO.loadAll();
    }
}