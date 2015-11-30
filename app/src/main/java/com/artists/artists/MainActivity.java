package com.artists.artists;

import android.os.Bundle;

import com.artists.artists.fragments.MainFragment;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected int getFragmentContainerId() {
        return R.id.mainFragmentContainer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        addFragment(new MainFragment(), false);
    }
}
