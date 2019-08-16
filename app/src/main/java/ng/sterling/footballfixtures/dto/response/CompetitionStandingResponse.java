package ng.sterling.footballfixtures.dto.response;

import java.util.List;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class CompetitionStandingResponse extends ApiResponse {
    private List<CompetitionStandingTable> standings;

    public List<CompetitionStandingTable> getStandings() {
        return standings;
    }

    public CompetitionStandingResponse setStandings(List<CompetitionStandingTable> standings) {
        this.standings = standings;
        return this;
    }
}
