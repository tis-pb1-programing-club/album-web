package jp.co.tis.climate.albumweb.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.tis.climate.albumweb.manager.ImageFileManager;

@Controller
public class ResourceController {
	
	@Autowired
	private ImageFileManager imageFileManager;
	
	
	@GetMapping("/image/{filename}")
	public void image(@PathVariable String filename, HttpServletResponse res) {
		Optional<Path> path = imageFileManager.get(filename);
		
		try(ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
			res.setContentType(MediaType.IMAGE_JPEG_VALUE);
			Files.copy(path.get(), bos);
			res.setContentLength(bos.size());
			res.getOutputStream().write(bos.toByteArray());
		} catch (IOException e) {
			//TODO: 例外処理ちゃんと作る？（なければ画像が表示されないだけだから、握りつぶしちゃってもいいかも？）
			throw new UncheckedIOException(e);
		}
	}
}
