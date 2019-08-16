package ng.sterling.footballfixtures.dto.response;

import java.util.List;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class CompetitionStandingTable {
    private List<CompetitionStandingsTableItemDto> table;

    public List<CompetitionStandingsTableItemDto> getTable() {
        return table;
    }

    public CompetitionStandingTable setTable(List<CompetitionStandingsTableItemDto> table) {
        this.table = table;
        return this;
    }
}
