package rest;

import entities.Team;
import lombok.*;
import persistence.TeamsDAO;
import rest.contracts.TeamDto;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/teams")
public class TeamController {

    @Inject
    @Setter
    @Getter
    private TeamsDAO teamsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Team team = teamsDAO.findOne(id);
        if (team == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        TeamDto teamDto = new TeamDto();
        teamDto.setName(team.getName());

        return Response.ok(teamDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer playerId,
            TeamDto teamData) {
        try {
            Team existingTeam = teamsDAO.findOne(playerId);
            if (existingTeam == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingTeam.setName(teamData.getName());
            teamsDAO.update(existingTeam);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}