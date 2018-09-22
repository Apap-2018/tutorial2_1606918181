package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value="a", defaultValue="0") String a, @RequestParam(value="b", defaultValue="0") String b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		
		if (aa == 0){
			aa = 1;
		}
		
		if (bb == 0) {
			bb = 1;
		}
		
		String jumlah = "h";
		for (int i=0; i<aa; i++) {
			jumlah += "m";
		}
		
		String hm = "";
		for (int j=0; j<bb; j++) {
			hm += (jumlah + " ");
		}
		
		System.out.println(hm);
		model.addAttribute("hm", hm);
		return "generator";
	}
}