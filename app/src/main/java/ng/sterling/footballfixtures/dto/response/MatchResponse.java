package ng.sterling.footballfixtures.dto.response;

import java.util.List;

import ng.sterling.footballfixtures.dto.Match;

/**
 * Author: Oluwatobi Adenekan
 * date:    12/08/2019
 **/

public class MatchResponse extends ApiResponse {
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public MatchResponse setMatches(List<Match> matches) {
        this.matches = matches;
        return this;
    }
}
