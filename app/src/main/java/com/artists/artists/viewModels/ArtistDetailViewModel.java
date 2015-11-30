package com.artists.artists.viewModels;


import android.text.Html;

import com.artists.artists.adapters.AlbumsAdapter;
import com.artists.artists.fragments.ArtistDetailFragment;
import com.artists.artists.model.Artist;
import com.nostra13.universalimageloader.core.ImageLoader;


public class ArtistDetailViewModel extends BaseViewModel {

    private Artist mArtist;
    private ArtistDetailFragment mView;

    public ArtistDetailViewModel(ArtistDetailFragment mView, Artist artist) {
        this.mArtist = artist;
        this.mView = mView;
    }

    public void setUpView() {
        mView.getmArtistNameTV().setText(mArtist.getName());
        mView.getmArtistGenreTV().setText(mArtist.getGenres());
        //JSON contains description as HTML
        mView.getmArtistDescriptionTV().setText(Html.fromHtml(mArtist.getDescription()));
        mView.getmAlbumListV().setAdapter(new AlbumsAdapter(mView.getContext(), mArtist.getAlbums()));
        ImageLoader.getInstance().displayImage(mArtist.getPicture(), mView.getmArtistPictureIV());
    }
}



