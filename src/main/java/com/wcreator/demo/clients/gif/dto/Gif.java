package com.wcreator.demo.clients.gif.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URI;

@Data
public class Gif {
    @JsonProperty("embed_url")
    private URI embedUrl;
}
