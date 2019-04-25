package edu.catolicasc.pokedex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

import java.util.List;

public class PokemonListAdapter{
    public static final String TAG= "PokemonListAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<Pokemon> pokemons;

    public PokemonListAdapter(int layoutResource, LayoutInflater layoutInflater, List<Pokemon> pokemons) {
        this.layoutResource = layoutResource;
        this.layoutInflater = layoutInflater;
        this.pokemons = pokemons;
    }

    @Override
    public int getCount(){
        return pokemons.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            Log.d(TAG, "getView: chamada com um convertView null");
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            Log.d(TAG, "getView: recebeu um convertView");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        RSSEntry appAtual = aplicativos.get(position);

        viewHolder.nome.setText(appAtual.getNome());
        viewHolder.tvArtista.setText(appAtual.getArtista());
        viewHolder.tvData.setText(appAtual.getDataLancamento());

        new DownloadImageTask(viewHolder.ivAppImg).execute(appAtual.getUrlImagem());

        return convertView;
    }

}
