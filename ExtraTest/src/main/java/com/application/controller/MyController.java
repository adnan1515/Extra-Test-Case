package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.classes.Inputs;
import com.application.classes.MatrixValues;
import com.application.classes.Random;
import com.application.service.MyService;

@Controller
public class MyController {

	@Autowired
	public MyService myService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Extra Test Case");
		return "home";
	}

	@PostMapping("/array")
	public String array(@ModelAttribute("inputs") Inputs inputs, ModelMap model) {
		Integer tests = inputs.getTests();
		Integer maxSize = inputs.getMaxSize();
		Integer maxVal = inputs.getMaxVal();
		String result = myService.getArrayOutputPositive(tests, maxSize, maxVal);
		model.addAttribute("pos", result);
		return "home";
	}

	@PostMapping("/negArray")
	public String negativeArray(@ModelAttribute("inputs") Inputs inputs, ModelMap model) {
		Integer tests = inputs.getTests();
		Integer maxSize = inputs.getMaxSize();
		Integer maxVal = inputs.getMaxVal();
		String result = myService.getArrayOutputNegative(tests, maxSize, maxVal);
		model.addAttribute("neg", result);
		return "home";
	}

	@PostMapping("/random")
	public String randomValues(@ModelAttribute("random") Random random, ModelMap model) {
		Integer tests = random.getTests();
		Integer maxValue = random.getMaxValue();
		String result = myService.getRandomValues(tests, maxValue);
		model.addAttribute("random", result);
		return "home";
	}

	@PostMapping("/strings")
	public String randomStrings(@ModelAttribute("random") Random random, ModelMap model) {
		Integer tests = random.getTests();
		Integer maxValue = random.getMaxValue();
		String result = myService.getRandomStrings(tests, maxValue);
		model.addAttribute("strings", result);
		model.addAttribute("random", "");
		return "home";
	}

	@PostMapping("/matrix")
	public String rondomMatrix(@ModelAttribute("matrix") MatrixValues values, ModelMap model) {
		Integer tests = values.getTests();
		Integer rowSize = values.getRowSize();
		Integer colSize = values.getColSize();
		Integer maxVal = values.getMaxValue();
		String result = myService.getRandomMatrix(tests, rowSize, colSize, maxVal);

		model.addAttribute("matrixtext", result);
		return "home";
	}
}
