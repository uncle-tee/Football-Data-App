package ng.sterling.footballfixtures.model;

/**
 * Author: Oluwatobi Adenekan
 * date:    18/08/2019
 **/

public class ApiErorMessageEvent {
    private  String message;

    public ApiErorMessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ApiErorMessageEvent setMessage(String message) {
        this.message = message;
        return this;
    }
}
