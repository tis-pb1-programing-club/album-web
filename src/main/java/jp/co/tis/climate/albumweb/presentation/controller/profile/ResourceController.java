package jp.co.tis.climate.albumweb.presentation.controller.profile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import jp.co.tis.climate.albumweb.infrastructure.manager.ImageFileManager;

@Controller
@RequestMapping("album")
public class ResourceController {

    private final ImageFileManager imageFileManager;

    private final ResourceLoader resourceLoader;

    public ResourceController(ImageFileManager imageFileManager, ResourceLoader resourceLoader) {
        this.imageFileManager = imageFileManager;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity<StreamingResponseBody> image(@PathVariable String filename) {
        Path path = imageFileManager.get(filename).orElseGet(getNoImagePath());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", MediaType.IMAGE_JPEG_VALUE);
        return new ResponseEntity<>(outputStream -> Files.copy(path, outputStream), responseHeaders,
                HttpStatus.OK);
    }

    private Supplier<Path> getNoImagePath() {
        return () -> {
            try {
                return resourceLoader.getResource("classpath:static/image/no-image.jpg").getFile().toPath();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        };
    }
}
