package jp.co.tis.climate.albumweb.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.tis.climate.albumweb.config.AlbumConfig;

@Controller
public class ResourceController {
	
	@Autowired
	private AlbumConfig albumConfig;
	
	
	@GetMapping("/image/{filename}")
	public void image(@PathVariable String filename, HttpServletResponse res) {
		Path path = Paths.get(albumConfig.getImageDirectory(), filename);
		
		try(ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
			res.setContentType(MediaType.IMAGE_JPEG_VALUE);
			Files.copy(path, bos);
			res.setContentLength(bos.size());
			res.getOutputStream().write(bos.toByteArray());
		} catch (IOException e) {
			//TODO: 例外処理ちゃんと作る？（なければ画像が表示されないだけだから、握りつぶしちゃってもいいかも？）
			throw new UncheckedIOException(e);
		}
	}
	
	

}
