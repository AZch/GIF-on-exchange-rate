package com.wcreator.demo.clients.gif;

import com.wcreator.demo.clients.gif.configuration.GifConfiguration;
import com.wcreator.demo.clients.gif.dto.GifResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${gif.name}", url = "${gif.api.urls.base}", configuration = GifConfiguration.class)
public interface GifClient {

    @GetMapping("${gif.api.urls.rich}")
    GifResponse rich();

    @GetMapping("${gif.api.urls.broke}")
    GifResponse broke();
}
