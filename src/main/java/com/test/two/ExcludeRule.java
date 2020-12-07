package com.test.two;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcludeRule {

    public static List<JSONObject> excludeJsonRule(ArrayList<JSONObject> userList, List<String> excludeRules) {

        Iterator users = userList.iterator();
        Iterator rules = excludeRules.iterator();

        while (rules.hasNext()) {
            JSONObject ruleObj = (JSONObject) rules.next();

            while (users.hasNext()) {
                JSONObject userObj = (JSONObject) users.next();
                String user = (String) userObj.get("user");
                long rating = (Long) userObj.get("rating");
                boolean disabled = (Boolean) userObj.get("disabled");

                if (ruleObj.get("user") != null && user.contains((String) ruleObj.get("user"))) {
                    users.remove();
                } else if (ruleObj.get("rating") != null && rating == (Long) ruleObj.get("rating")) {
                    users.remove();
                } else if (ruleObj.get("disabled") != null && disabled == (Boolean) ruleObj.get("disabled")) {
                    users.remove();
                }
            }
        }
        return userList;
    }
}
