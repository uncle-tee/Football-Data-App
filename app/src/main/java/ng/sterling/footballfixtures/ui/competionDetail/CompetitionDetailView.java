package ng.sterling.footballfixtures.ui.competionDetail;

import ng.sterling.footballfixtures.dto.response.CompetitionDetailResponse;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public interface CompetitionDetailView {
    void data(CompetitionDetailResponse data);

    void showViewDistroyMessage(String message);

    void showNetworkErrorMessage(String message);
}
