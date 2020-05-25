package utils;

import com.google.gson.Gson;
import models.ItemPrice;

import java.io.*;

public class JsonParser {

	private Gson gson = new Gson();
	String fileName = "src/test/resources/" + "Price.json";

	public void writeToFile(ItemPrice... value) {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write(gson.toJson(value));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ItemPrice[] readFromFile(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			return gson.fromJson(reader, ItemPrice[].class);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}