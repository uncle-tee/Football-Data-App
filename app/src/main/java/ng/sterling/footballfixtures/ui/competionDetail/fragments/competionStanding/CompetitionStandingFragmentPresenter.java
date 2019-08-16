package ng.sterling.footballfixtures.ui.competionDetail.fragments.competionStanding;

import java.util.List;

import ng.sterling.footballfixtures.dto.response.CompetitionStandingsTableItemDto;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public interface CompetitionStandingFragmentPresenter {
    void setCompetitionStanding(List<CompetitionStandingsTableItemDto> competitionStanding);
}
