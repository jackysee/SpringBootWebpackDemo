package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@Value("${welcome.message}")
	private String welcome;
	
	@Autowired
	private ServletContext sc;
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("welcome", welcome);
		
		
		
		try {
			File file = new ClassPathResource("assets/index_assets.html").getFile();
			model.put("fileExist", file.exists());
			model.put("filePath", file.getPath());
			
			String scpath = sc.getRealPath("/assets/index_assets.html");
			File scfile = new File(scpath);
			model.put("scFilePath", scpath);
			model.put("scFileExist", scfile.exists());
			
			ResourceLoader resourceLoader = new DefaultResourceLoader();
			Resource r = resourceLoader.getResource("classpath:/assets/index_assets.html");
			model.put("rsFilePath", r.getFile().getPath());
			model.put("rsFileExist", r.exists());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.put("fileExist", "io-error");
		}
		
		return "index";
	}

}
