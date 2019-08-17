package ng.sterling.footballfixtures.dto.response;

import java.util.List;

import ng.sterling.footballfixtures.dto.NameAndId;

/**
 * Author: Oluwatobi Adenekan
 * date:    15/08/2019
 **/

public class TeamDto extends NameAndId {

    private String crestUrl;

    private List<SquadDto> squad;

    public String getCrestUrl() {
        return crestUrl;
    }

    public TeamDto setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
        return this;
    }

    public List<SquadDto> getSquad() {
        return squad;
    }

    public TeamDto setSquad(List<SquadDto> squad) {
        this.squad = squad;
        return this;
    }
}
