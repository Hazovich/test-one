package com.test.two;

import com.test.two.comparator.DisabledComparator;
import com.test.two.comparator.NameComparator;
import com.test.two.comparator.RatingComparator;
import org.json.simple.JSONObject;

import java.util.*;

public class SortRule {

    public static List<User> sortedList(ArrayList<JSONObject> listUsers, List<String> ruleSort) {

        ArrayList<User> result = new ArrayList<>();
        Iterator user = listUsers.iterator();
        while (user.hasNext()) {
            JSONObject userObj = (JSONObject) user.next();
            String name = (String) userObj.get("user");
            long rating = (Long) userObj.get("rating");
            boolean disabled = (Boolean) userObj.get("disabled");
            result.add(new User(name, rating, disabled));
        }
        Comparator nameComparator = new NameComparator();
        Comparator ratingComparator = new RatingComparator();
        Comparator disabledComparator = new DisabledComparator();


        for (int i = 0; i < ruleSort.size(); i++) {
            String rule = ruleSort.get(i);

            if (rule.equalsIgnoreCase("user")) {
                Collections.sort(result, nameComparator);
            } else if (rule.equalsIgnoreCase("rating")) {
                Collections.sort(result, ratingComparator);
            } else if (rule.equalsIgnoreCase("disabled")) {
                Collections.sort(result, disabledComparator);
            }
        }
        return result;
    }
}



