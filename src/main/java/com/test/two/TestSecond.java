package com.test.two;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestSecond {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("list.json")) {

            //Work with file and main lines
            JSONParser jsonParse = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParse.parse(reader);
            JSONArray jsonMainLIst = (JSONArray) jsonObject.get("data");

            //Take main rule object
            JSONObject ruleObject = (JSONObject) jsonObject.get("condition");

            //Take array of users from file
            ArrayList<JSONObject> jsonList = new ArrayList<>(jsonMainLIst);
            ArrayList<JSONObject> jsonTempList = new ArrayList();

            if (ruleObject.get("exclude") != null) {

                //Take rule exclude
                JSONArray ruleExcludeList = (JSONArray) ruleObject.get("exclude");
                ArrayList<String> exclude = new ArrayList<>(ruleExcludeList);
                System.out.println("Exclude:\n" + ExcludeRule.excludeJsonRule(jsonList, exclude));
                jsonTempList.addAll(IncludeRule.includeJsonRule(jsonList, exclude));

            } else if (ruleObject.get("include") != null) {

                //Take rule include
                JSONArray ruleIncludeList = (JSONArray) ruleObject.get("include");
                ArrayList<String> include = new ArrayList<>(ruleIncludeList);
                System.out.println("Include:\n" + IncludeRule.includeJsonRule(jsonList, include));
                jsonTempList.addAll(IncludeRule.includeJsonRule(jsonList, include));
            }

            //Take sort rule
            JSONArray sortedList = (JSONArray) ruleObject.get("sort_by");
            ArrayList<String> sortList = new ArrayList<>(sortedList);
            System.out.println("Sort:\n" + SortRule.sortedList(jsonTempList, sortList));

            ArrayList<User> userList = new ArrayList<>();
            userList.addAll(SortRule.sortedList(jsonTempList, sortList));

            System.out.println("Final:\n" + userList);

            try (FileWriter file = new FileWriter("list.json", true)) {

                ArrayList arr = new ArrayList(userList);
                JSONObject obj = new JSONObject();
                obj.put("result", arr);
                file.write(obj.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException | ParseException | InputMismatchException e) {
            e.printStackTrace();
        }
    }
}

