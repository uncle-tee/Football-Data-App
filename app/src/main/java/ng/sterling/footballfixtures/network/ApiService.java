package ng.sterling.footballfixtures.network;


import io.reactivex.Observable;
import ng.sterling.footballfixtures.dto.response.CompetitionResponse;
import ng.sterling.footballfixtures.dto.response.CompetitionStandingResponse;
import ng.sterling.footballfixtures.dto.response.MatchResponse;
import ng.sterling.footballfixtures.dto.response.TeamDto;
import ng.sterling.footballfixtures.dto.response.TeamsResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author: Oluwatobi Adenekan
 * date:    10/08/2019
 **/

public interface ApiService {


    @GET("matches?dateFrom=2019-08-10&dateTo=2019-08-10")
    Observable<MatchResponse> getMatches();

    @GET("competitions")
    Observable<CompetitionResponse> getCompetions();

    @GET("competitions/{id}/standings")
    Observable<CompetitionStandingResponse> getCompetitionStandings(@Path("id") Long CompetitionId);

    @GET("competitions/{id}/teams")
    Observable<TeamsResponse> getTeams(@Path("id") Long CompetitionId);

    @GET("/teams/{id}")
    Observable<TeamDto> getTeam(@Path("id") Long teamId);




}
