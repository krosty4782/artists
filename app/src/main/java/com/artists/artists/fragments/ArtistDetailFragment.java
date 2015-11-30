package com.artists.artists.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.artists.artists.R;
import com.artists.artists.model.Artist;
import com.artists.artists.viewModels.ArtistDetailViewModel;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ArtistDetailFragment extends BaseFragment{
    public static final String TAG = "ArtistDetailFragment";
    private ArtistDetailViewModel mArtistDetailViewModel;
    @InjectView(R.id.artistGenre)
    TextView mArtistGenreTV;
    @InjectView(R.id.artistName)
    TextView mArtistNameTV;
    @InjectView(R.id.artistDescription)
    TextView mArtistDescriptionTV;
    @InjectView(R.id.albumName)
    TextView mAlbumNameTV;
    @InjectView(R.id.artistPicture)
    ImageView mArtistPictureIV;
    @InjectView(R.id.albumsList)
    ListView mAlbumListV;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.artist_detail_fragment, null);
        ButterKnife.inject(this, view);
        setUpFragment();
        return view;
    }

    private void setUpFragment() {
        Bundle args = getArguments();
        mArtistDetailViewModel = new ArtistDetailViewModel(this, (Artist)args.getSerializable("artist"));
        mArtistDetailViewModel.setUpView();
    }

    public TextView getmArtistGenreTV() {
        return mArtistGenreTV;
    }

    public TextView getmArtistNameTV() {
        return mArtistNameTV;
    }

    public TextView getmArtistDescriptionTV() {
        return mArtistDescriptionTV;
    }

    public TextView getmAlbumNameTV() {
        return mAlbumNameTV;
    }

    public ListView getmAlbumListV() {
        return mAlbumListV;
    }

    public ImageView getmArtistPictureIV() {
        return mArtistPictureIV;
    }

}

