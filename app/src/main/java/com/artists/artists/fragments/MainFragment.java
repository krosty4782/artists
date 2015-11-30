package com.artists.artists.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.artists.artists.R;
import com.artists.artists.viewModels.MainViewModel;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainFragment extends BaseFragment {
    public static final String TAG = "MainFragment";
    private MainViewModel mMainViewModel;
    @InjectView(R.id.artistList)
    ListView artistListV;
    @InjectView(R.id.artistError)
    TextView artistErrorTV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.inject(this, view);
        mMainViewModel = new MainViewModel(this);
        mMainViewModel.downloadArtists();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public ListView getArtistList() {
        return artistListV;
    }

    public TextView getArtistErrorTV() {
        return artistErrorTV;
    }

}

