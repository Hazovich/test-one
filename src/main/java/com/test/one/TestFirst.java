package com.test.one;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestFirst {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean var = true;
        while (var) {
            try (FileReader reader = new FileReader("units.json")) {
                System.out.println("Please, enter a number of JSON object: ");

                //Work with file and main lines
                JSONParser jPars = new JSONParser();
                JSONObject jObj = (JSONObject) jPars.parse(reader);
                int id = sc.nextInt();
                JSONObject main = (JSONObject) jObj.get("param " + id);
                JSONObject structure = (JSONObject) main.get("distance");
                String unit = (String) structure.get("unit");
                double value = (Double) structure.get("value");
                String convert = (String) main.get("convert_to");
                System.out.println(unit + " " + value + " " + convert);

                //Parse file
                convertToMillimeters(unit, value, convert);
                var = false;
            } catch (IOException | ParseException | InputMismatchException e) {
                System.out.println("You entered illegal character.\nPlease try again");
                sc.next();
            }
        }
    }

    public static String convertToMillimeters(String unit, Double value, String convert) {

        //Convert unit to mm
        double result = 0;
        switch (unit) {
            case "m":
                result = value / 0.001;
                break;
            case "cm":
                result = value / 0.1;
                break;
            case "ft":
                result = value / 0.00328084;
                break;
            case "in":
                result = value / 0.03937008;
                break;
            case "yd":
                result = value / 0.0010936133333333;
                break;
            case "km":
                result = value / 0.000001;
                break;
            case "mm":
                result = value;
                break;
        }

        //Convert mm to unit
        switch (convert) {
            case "m":
                result = result * 0.001;
                break;
            case "cm":
                result = result * 0.1;
                break;
            case "ft":
                result = result * 0.00328084;
                break;
            case "in":
                result = result * 0.03937008;
                break;
            case "yd":
                result = result * 0.0010936133333333;
                break;
            case "km":
                result = result * 0.000001;
                break;
            case "mm":
                break;
        }

        //#.##
        String res = String.format("%.2f", result);
        System.out.println(res);
        return res;
    }

}
