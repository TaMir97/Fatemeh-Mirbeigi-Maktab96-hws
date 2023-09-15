package org.example.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class JsonFileReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Scanner scanner = new Scanner(System.in);

    public static JsonNode readJsonFromFile(String filePath) {
        File jsonFile = new File(filePath);
        try {
            return objectMapper.readTree(jsonFile);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + e.getMessage(), e);
        }
    }

    public static String jsonPrinter() {
        JsonNode rootNode = readJsonFromFile("src/main/resources/provinces.json");
        String selectedString = null;
        if (rootNode.isArray()) {
            System.out.println("Available options:");

            int index = 0;
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode element = elements.next();
                JsonNode cityNode = element.get("City");
                System.out.println(index + ": " + cityNode.asText());
                index++;
            }

            int selectedIndex = -1;
            try {
                System.out.print("Enter the index of the city you want to select: ");
                selectedIndex = scanner.nextInt();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid index.");
            }

            if (selectedIndex >= 0 && selectedIndex < index) {
                JsonNode selectedNode = rootNode.get(selectedIndex);
                selectedString = selectedNode.get("City").toString();
                System.out.println("Selected JSON: " + selectedString);
            } else {
                System.out.println("Invalid index selection. Please choose a valid index.");
            }
        } else {
            System.out.println("The JSON file does not contain an array with numeric indexes.");
        }
        return selectedString;
    }
}
