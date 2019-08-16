package ng.sterling.footballfixtures.ui.competionDetail.fragments.competitionTeam;

import java.util.List;

import ng.sterling.footballfixtures.dto.response.TeamDto;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public interface CompetitionTeamFragmentPresenter {

    void setCompetitionTeam(List<TeamDto> teams);
}
