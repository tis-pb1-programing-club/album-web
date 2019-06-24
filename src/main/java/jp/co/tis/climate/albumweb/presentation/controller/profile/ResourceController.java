package jp.co.tis.climate.albumweb.presentation.controller.profile;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ImageFileManager imageFileManager;

    @GetMapping("/image/{filename}")
    public ResponseEntity<StreamingResponseBody> image(@PathVariable String filename) {
        Path path = imageFileManager.get(filename).orElseThrow(() -> HttpClientErrorException.create(HttpStatus.NOT_FOUND, null, null, null, null));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", MediaType.IMAGE_JPEG_VALUE);
        return new ResponseEntity<>(outputStream -> Files.copy(path, outputStream), responseHeaders,
                HttpStatus.OK);
    }
}
