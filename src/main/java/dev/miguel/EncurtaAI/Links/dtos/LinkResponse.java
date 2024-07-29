package dev.miguel.EncurtaAI.Links.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public class LinkResponse {
    private UUID id;
    @NotBlank
    private String urlOriginal;
    private String urlEncurtada;
    private String urlQrCode;
    private LocalDateTime timestamp;

    public LinkResponse() {
    }

    public LinkResponse(UUID id, String urlOriginal, String urlEncurtada, String urlQrCode, LocalDateTime timestamp) {
        this.id = id;
        this.urlOriginal = urlOriginal;
        this.urlEncurtada = urlEncurtada;
        this.urlQrCode = urlQrCode;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
