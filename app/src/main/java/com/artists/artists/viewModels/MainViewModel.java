package com.artists.artists.viewModels;

import android.content.Context;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.artists.artists.R;
import com.artists.artists.adapters.ArtistAdapter;
import com.artists.artists.fragments.ArtistDetailFragment;
import com.artists.artists.fragments.MainFragment;
import com.artists.artists.model.Artist;
import com.artists.artists.services.RequestManager;
import com.artists.artists.utilities.Parser;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private List<Artist> mArtists;
    private Context mContext;
    private MainFragment mView;

    public MainViewModel(MainFragment mView) {
        this.mView = mView;
        mContext = mView.getActivity();
    }

    public List<Artist> getmArtists() {
        return mArtists;
    }

    public void setmArtists(List<Artist> artists) {
        this.mArtists = artists;
    }

    public void downloadArtists() {

        RequestManager.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(artists -> {
                    List<Artist> listArtists = Parser.parseData(artists);
                    if (listArtists.size() > 0) {
                        mView.getArtistErrorTV().setVisibility(View.GONE);
                        this.setmArtists(listArtists);
                        this.setArtistsAdapter();
                        this.setClickListeners();
                    }
                }, throwable -> {
                    Log.e("ERROR", throwable.toString());
                    mView.getArtistErrorTV().setText(R.string.network_error);
                    mView.getArtistErrorTV().setVisibility(View.VISIBLE);
                });
    }

    private void setArtistsAdapter() {
        mView.getArtistList().setAdapter(new ArtistAdapter(mContext, mArtists));
    }

    private void setClickListeners() {
        ListView listView = mView.getArtistList();
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("artist", (Artist)listView.getAdapter().getItem(position));
            ArtistDetailFragment artistDetailFragment = new ArtistDetailFragment();
            artistDetailFragment.setArguments(bundle);
            mView.addFragment(artistDetailFragment, true);
        });
    }
}

