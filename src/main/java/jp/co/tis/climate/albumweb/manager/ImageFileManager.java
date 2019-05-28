package jp.co.tis.climate.albumweb.manager;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jp.co.tis.climate.albumweb.config.AlbumConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ImageFileManager {

    private Path imgRoot;

    public ImageFileManager(AlbumConfig albumConfig) {
        this.imgRoot = Paths.get(albumConfig.getImageDirectory()).toAbsolutePath();
        System.out.println(this.imgRoot.toString());
    }

    public Optional<Path> get(String filename) {
        Path target = Paths.get(imgRoot.toString(), filename);
        if (Files.notExists(target)) {
            return Optional.empty();
        }

        try {
            if (!target.toRealPath().toString().startsWith(imgRoot.toRealPath().toString())) {
                return Optional.empty();
            }

            return Optional.of(target);
        } catch (IOException e) {
            log.error(String.format("The file could not be got. file=[%s]", target.toString()), e);
            throw new UncheckedIOException(e);
        }
    }

    public Path create() {
        UUID id = UUID.randomUUID();
        Path path = Paths.get(imgRoot.toString(), id.toString());
        try {
            Files.createFile(path);
        } catch (IOException e) {
            log.error(String.format("The file could not be created. file=[%s]", path.toString()), e);
            throw new UncheckedIOException(e);
        }
        return path;
    }

    public boolean delete(String name) {
        Optional<Path> target = get(name);
        if (target.isPresent()) {
            Path path = target.get();
            try {
                return Files.deleteIfExists(path);
            } catch (IOException e) {
                log.error(String.format("The file could not be deleted. file=[%s]", path.toString()), e);
                return false;
            }
        }
        return false;
    }

}
