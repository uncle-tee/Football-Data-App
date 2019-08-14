package ng.sterling.footballfixtures.model;

import ng.sterling.footballfixtures.dto.response.ApiResponse;

/**
 * Author: Oluwatobi Adenekan
 * date:    13/08/2019
 **/

public class ApiSuccessResponse<T extends ApiResponse> {

    private T data;

    public T getData() {
        return data;
    }

    public ApiSuccessResponse<T> setData(T data) {
        this.data = data;
        return this;
    }
}
