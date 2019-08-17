package ng.sterling.footballfixtures.dto.response;

import ng.sterling.footballfixtures.dto.NameAndId;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class SquadDto extends NameAndId {
    private String position;
    private String role;


    public String getPosition() {
        return position;
    }

    public SquadDto setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getRole() {
        return role;
    }

    public SquadDto setRole(String role) {
        this.role = role;
        return this;
    }
}
