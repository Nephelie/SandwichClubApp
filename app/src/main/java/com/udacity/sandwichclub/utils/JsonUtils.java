package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

                JSONObject sandwichJs = new JSONObject(json);
                JSONObject name = sandwichJs.getJSONObject("name");

                String mainName = name.optString("mainName");
                String placeOfOrigin = sandwichJs.optString("placeOfOrigin");
                String description = sandwichJs.optString("description");
                String image = sandwichJs.optString("image");

                JSONArray jsonArrayAKA = name.getJSONArray("alsoKnownAs");
                ArrayList<String> alsoKnownAs = new ArrayList<>();
                for (int i = 0; i < jsonArrayAKA.length(); i++){
                    alsoKnownAs.add(jsonArrayAKA.getString(i));
                }

                JSONArray jsonArrayIngredients = sandwichJs.getJSONArray("ingredients");
                ArrayList<String> ingredients = new ArrayList<>();
                for (int i = 0; i < jsonArrayIngredients.length(); i++){
                    ingredients.add(jsonArrayIngredients.getString(i));
                }

                Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
                return  sandwich;

    }
}
