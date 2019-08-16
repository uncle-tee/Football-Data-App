package ng.sterling.footballfixtures.dto.response;

import java.util.List;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class TeamsResponse extends  ApiResponse {

    private List<TeamDto> teams;

    public List<TeamDto> getTeams() {
        return teams;
    }

    public TeamsResponse setTeams(List<TeamDto> teams) {
        this.teams = teams;
        return this;
    }
}
