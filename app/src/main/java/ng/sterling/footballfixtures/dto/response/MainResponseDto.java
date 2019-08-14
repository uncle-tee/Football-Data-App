package ng.sterling.footballfixtures.dto.response;

/**
 * Author: Oluwatobi Adenekan
 * date:    11/08/2019
 **/

public class MainResponseDto extends ApiResponse {
    private MatchResponse matches;
    private CompetitionResponse competitions;

    public MainResponseDto(MatchResponse matches,
                           CompetitionResponse competitions) {
        this.matches = matches;
        this.competitions = competitions;
    }

    public MatchResponse getMatches() {
        return matches;
    }

    public MainResponseDto setMatches(MatchResponse matches) {
        this.matches = matches;
        return this;
    }

    public CompetitionResponse getCompetitions() {
        return competitions;
    }

    public MainResponseDto setCompetitions(CompetitionResponse competitions) {
        this.competitions = competitions;
        return this;
    }
}
