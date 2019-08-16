package ng.sterling.footballfixtures.dto.response;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class CompetitionDetailResponse  extends ApiResponse{
    private TeamsResponse teams;
    private CompetitionStandingResponse competitionStanding;

    public CompetitionDetailResponse(TeamsResponse teams, CompetitionStandingResponse competitionStanding) {
        this.teams = teams;
        this.competitionStanding = competitionStanding;
    }

    public TeamsResponse getTeams() {
        return teams;
    }

    public CompetitionDetailResponse setTeams(TeamsResponse teams) {
        this.teams = teams;
        return this;
    }

    public CompetitionStandingResponse getCompetitionStanding() {
        return competitionStanding;
    }

    public CompetitionDetailResponse setCompetitionStanding(CompetitionStandingResponse competitionStanding) {
        this.competitionStanding = competitionStanding;
        return this;
    }
}
