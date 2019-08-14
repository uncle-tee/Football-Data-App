package ng.sterling.footballfixtures.ui.main;

import java.util.List;

import ng.sterling.footballfixtures.dto.Match;
import ng.sterling.footballfixtures.dto.NameAndId;
import ng.sterling.footballfixtures.dto.response.MainResponseDto;

/**
 * Author: Oluwatobi Adenekan
 * date:    09/08/2019
 **/

public interface MainView {

    void showMatchAndCompetitions(MainResponseDto matchAndCompetition);


}
