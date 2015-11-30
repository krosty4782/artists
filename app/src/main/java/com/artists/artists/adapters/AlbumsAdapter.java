package com.artists.artists.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.artists.artists.R;
import com.artists.artists.model.Album;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class AlbumsAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Album> mAlbum;

    public AlbumsAdapter(Context context, List<Album> albums) {
        mInflater = LayoutInflater.from(context);
        mAlbum = albums;
    }

    @Override
    public int getCount() {
        return mAlbum.size();
    }

    @Override
    public Object getItem(int position) {
        return mAlbum.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.album_item, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }

        Album album = ((Album)this.getItem(position));
        holder.mName.setText(album.getTitle());
        holder.mPicture.setImageDrawable(null);
        ImageLoader.getInstance().displayImage(album.getPicture(), holder.mPicture);
        return convertView;
    }

    static class Holder {

        @InjectView(R.id.albumName)
        TextView mName;

        @InjectView(R.id.albumPicture)
        ImageView mPicture;

        public Holder(View view) {

            ButterKnife.inject(this, view);
        }
    }
}
