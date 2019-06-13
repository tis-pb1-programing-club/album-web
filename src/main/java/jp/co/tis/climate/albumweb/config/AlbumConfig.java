package jp.co.tis.climate.albumweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "fuudoapp.album")
@Getter
@Setter
public class AlbumConfig {
    private String imageDirectory;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
