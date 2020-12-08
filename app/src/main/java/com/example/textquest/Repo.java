package com.example.textquest;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Repo implements IRepository{
    private Location[] locations;

    public Repo(Context context) {
        Action[] actions;
        try {
            // считывание файла JSON
            String jsonText = readFile(context, R.raw.quest);

            // создаём json объект
            JSONObject obj = new JSONObject(jsonText);

            // создаём массив локаций
            locations = new Location[obj.length()];

            for (int i = 0; i < obj.length(); i++) {
                // получаем локацию
                JSONObject location = obj.getJSONObject(String.valueOf(i + 1));

                // получаем действия
                JSONObject actionsObj = location.getJSONObject("actions");

                // обновляем массив действий
                actions = new Action[actionsObj.length()];
                for (int j = 0; j < actionsObj.length(); j++) {
                    // получаем действие
                    JSONObject action = actionsObj.getJSONObject(String.valueOf(j + 1));

                    // получаем текст и направление действия
                    String actionText = action.getString("text");
                    int n = action.getInt("To");

                    // создаём новое действие и добавляем его в массив
                    actions[j] = new Action(actionText, n);
                }
                // получаем текст локации, создаём новую локацию и добавляем её в массив
                String text = location.getString("text");
                locations[i] = new Location(text, actions);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private String readFile(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Location getLocation(int nLoc) {
        return locations[nLoc - 1];
    }
}
