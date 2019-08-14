package ng.sterling.footballfixtures.dto;

import ng.sterling.footballfixtures.dto.response.ApiResponse;

/**
 * Author: Oluwatobi Adenekan
 * date:    12/08/2019
 **/

public class NameAndId extends ApiResponse {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public NameAndId setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public NameAndId setName(String name) {
        this.name = name;
        return this;
    }
}
