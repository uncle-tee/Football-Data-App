package ng.sterling.footballfixtures.dto.response;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class CompetitionStandingsTableItemDto extends ApiResponse{
    private String position;
    private String points;
    private String goalsFor;
    private String goalsAgainst;
    private TeamDto team;

    public String getPosition() {
        return position;
    }

    public CompetitionStandingsTableItemDto setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getPoints() {
        return points;
    }

    public CompetitionStandingsTableItemDto setPoints(String points) {
        this.points = points;
        return this;
    }

    public String getGoalsFor() {
        return goalsFor;
    }

    public CompetitionStandingsTableItemDto setGoalsFor(String goalsFor) {
        this.goalsFor = goalsFor;
        return this;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }

    public CompetitionStandingsTableItemDto setGoalsAgainst(String goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
        return this;
    }

    public TeamDto getTeam() {
        return team;
    }

    public CompetitionStandingsTableItemDto setTeam(TeamDto team) {
        this.team = team;
        return this;
    }
}
