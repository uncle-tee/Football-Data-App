package ng.sterling.footballfixtures.dto.response;

import java.util.List;

import ng.sterling.footballfixtures.dto.NameAndId;

/**
 * Author: Oluwatobi Adenekan
 * date:    12/08/2019
 **/

public class CompetitionResponse extends ApiResponse {
    private List<NameAndId> competitions;

    public List<NameAndId> getCompetitions() {
        return competitions;
    }

    public CompetitionResponse setCompetitions(List<NameAndId> competitions) {
        this.competitions = competitions;
        return this;
    }
}
