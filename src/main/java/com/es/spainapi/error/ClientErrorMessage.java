package com.es.spainapi.error;

import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
public class ClientErrorMessage {
    private String message;
    private String uri;
    private String method;
    private int status;
    private LocalTime timestamp;

    public ClientErrorMessage(String message, String uri, String method, int status) {
        this.message = message;
        this.uri = uri;
        this.method = method;
        this.status = status;
        this.timestamp = LocalTime.now();
    }
}
