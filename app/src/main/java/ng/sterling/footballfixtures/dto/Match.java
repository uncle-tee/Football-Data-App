package ng.sterling.footballfixtures.dto;

import ng.sterling.footballfixtures.dto.response.ApiResponse;

/**
 * Author: Oluwatobi Adenekan
 * date:    12/08/2019
 **/

public class Match extends ApiResponse {
    private String utcDate;
    private String status;
    private NameAndId homeTeam;
    private NameAndId awayTeam;
    private Score score;

    public String getUtcDate() {
        return utcDate;
    }

    public Match setUtcDate(String utcDate) {
        this.utcDate = utcDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Match setStatus(String status) {
        this.status = status;
        return this;
    }

    public NameAndId getHomeTeam() {
        return homeTeam;
    }

    public Match setHomeTeam(NameAndId homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    public NameAndId getAwayTeam() {
        return awayTeam;
    }

    public Match setAwayTeam(NameAndId awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public Match setScore(Score score) {
        this.score = score;
        return this;
    }

    public static class Score{

        private Result fullTime;

        public Result getFullTime() {
            return fullTime;
        }

        public Score setFullTime(Result fullTime) {
            this.fullTime = fullTime;
            return this;
        }
    }


    public static class Result{
        private String homeTeam;
        private String awayTeam;

        public String getHomeTeam() {
            return homeTeam;
        }

        public Result setHomeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public String getAwayTeam() {
            return awayTeam;
        }

        public Result setAwayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }
    }
}
