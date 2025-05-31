package app.scr.makermusic.dto.response;

import lombok.Data;

@Data
public class AuthResponse {
    private int statusCode;
    private String message;

    public AuthResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
