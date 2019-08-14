package ng.sterling.footballfixtures.network;


import io.reactivex.Observable;
import ng.sterling.footballfixtures.dto.response.CompetitionResponse;
import ng.sterling.footballfixtures.dto.response.MatchResponse;
import retrofit2.http.GET;

/**
 * Author: Oluwatobi Adenekan
 * date:    10/08/2019
 **/

public interface ApiService {


    @GET("matches")
    Observable<MatchResponse> getMatches();

    @GET("competitions")
    Observable<CompetitionResponse> getCompetions();


}
