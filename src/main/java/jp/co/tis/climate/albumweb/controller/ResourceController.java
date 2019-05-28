package jp.co.tis.climate.albumweb.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import jp.co.tis.climate.albumweb.manager.ImageFileManager;

@Controller
public class ResourceController {

    @Autowired
    private ImageFileManager imageFileManager;

    @GetMapping("/image/{filename}")
    public ResponseEntity<StreamingResponseBody> image(@PathVariable String filename) {
        Optional<Path> path = imageFileManager.get(filename);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", MediaType.IMAGE_JPEG_VALUE);
        return new ResponseEntity<>(outputStream -> Files.copy(path.get(), outputStream), responseHeaders,
                HttpStatus.OK);
    }
}
