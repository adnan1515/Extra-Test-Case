package com.application.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public String getArrayOutputPositive(Integer tests, Integer maxSize, Integer maxVal) {
		StringBuilder sb = new StringBuilder();
		sb.append(tests + "\n");
		for (Integer i = 0; i < tests; i++) {
			int size = (int) (Math.random() * (maxSize) + 1);
			sb.append(size + "\n");
			for (int j = 0; j < size; j++) {
				int value = (int) (Math.random() * (maxVal + 1));
				sb.append(value + " ");
			}
			sb.append("\n");

		}

		return sb.toString();
	}

	public String getArrayOutputNegative(Integer tests, Integer maxSize, Integer maxVal) {
		StringBuilder sb = new StringBuilder();
		sb.append(tests + "\n");
		for (Integer i = 0; i < tests; i++) {
			Integer size = (int) (Math.random() * (maxSize) + 1);
			sb.append(size + "\n");
			for (Integer j = 0; j < size; j++) {
				int value = (int) (Math.random() * (maxVal + maxVal + 1) - maxVal);
				sb.append(value + " ");
			}
			sb.append("\n");

		}
		return sb.toString();
	}

	public String getRandomValues(Integer tests, Integer maxValue) {
		StringBuilder sb = new StringBuilder();
		sb.append(tests + "\n");
		for (Integer i = 0; i < tests; i++) {
			int value = (int) (Math.random() * (maxValue) + 1);
			sb.append(value + "\n");
		}
		return sb.toString();
	}

	public String getRandomStrings(Integer tests, Integer maxLen) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		sb.append(tests + "\n");
		for (Integer i = 0; i < tests; i++) {
			int targetStringLength = (int) ((Math.random() * (maxLen - 1)) + 1);

			StringBuilder generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
			sb.append(generatedString + "\n");
		}

		return sb.toString();
	}

	public String getRandomMatrix(Integer tests, Integer rowSize, Integer colSize, Integer maxValue) {
		StringBuilder sb = new StringBuilder();

		sb.append(tests + "\n");

		for (Integer i = 0; i < tests; i++) {
			Integer rSize = (int) (Math.random() * (rowSize - 1 + 1) + 1);
			Integer cSize = (int) (Math.random() * (colSize - 1 + 1) + 1);

			sb.append(rSize + " " + cSize + "\n");

			for (Integer j = 0; j < rSize; j++) {
				for (Integer k = 0; k < cSize; k++) {
					Integer value = (int) (Math.random() * (maxValue - 1 + 1) + 1);
					sb.append(value + " ");
				}
				sb.append("\n");
			}

		}

		return sb.toString();
	}

}
