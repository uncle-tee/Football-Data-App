package ng.sterling.footballfixtures.exceptions;

import java.io.IOException;

/**
 * Author: Oluwatobi Adenekan
 * date:    18/08/2019
 **/

public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No network available, please check your WiFi or Data connection";
    }
}
