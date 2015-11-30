package com.artists.artists.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.artists.artists.R;
import com.artists.artists.model.Artist;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ArtistAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Artist> mArtists;

    public ArtistAdapter(Context context, List<Artist> artists) {
        mInflater = LayoutInflater.from(context);
        mArtists = artists;
    }

    @Override
    public int getCount() {
        return mArtists.size();
    }

    @Override
    public Object getItem(int position) {
        return mArtists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.artist_item, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }

        Artist artist = ((Artist)this.getItem(position));
        holder.mName.setText(artist.getName());
        holder.mGenre.setText(artist.getGenres());
        holder.mPicture.setImageDrawable(null);
        ImageLoader.getInstance().displayImage(artist.getPicture(), holder.mPicture);
        return convertView;
    }

    static class Holder {

        @InjectView(R.id.artistName)
        TextView mName;

        @InjectView(R.id.artistGenre)
        TextView mGenre;

        @InjectView(R.id.artistPicture)
        ImageView mPicture;

        public Holder(View view) {

            ButterKnife.inject(this, view);
        }
    }
}
