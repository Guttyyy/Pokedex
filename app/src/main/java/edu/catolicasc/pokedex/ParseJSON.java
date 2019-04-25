package edu.catolicasc.pokedex;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJSON {

    public class ParseJson {
        private static final String TAG = "ParseJson";
        private List<Pokemon> pokemons;

        public ParseJson(List<Pokemon> pokemons) {
            this.pokemons = pokemons;
        }

        public List<Pokemon> getPokemons() {
            return pokemons;
        }

        public void parse(String jsonString) {
            try {
                JSONObject json = new JSONObject(jsonString);
                JSONArray jsonArray = json.getJSONArray("pokemon");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject pokemon = jsonArray.getJSONObject(i);
                    Pokemon p = new Pokemon(
                            pokemon.getInt("id"),
                            pokemon.getString("name"),
                            pokemon.getDouble("peso"),
                            pokemon.getDouble("altura"),
                            pokemon.getString("img")
                    );
                    pokemons.add(p);
                }
            } catch (JSONException e) {
                Log.d(TAG, "parse: Erro fazendo parse de String JSON: " + e.getMessage());
            }

        }
    }
}
