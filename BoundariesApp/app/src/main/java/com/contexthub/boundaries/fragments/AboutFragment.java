package com.contexthub.boundaries.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.contexthub.boundaries.BuildConfig;
import com.contexthub.boundaries.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by andy on 10/21/14.
 */
public class AboutFragment extends Fragment implements View.OnClickListener {

    @InjectView(R.id.version_info) TextView versionInfo;
    @InjectView(R.id.powered_by_contexthub) ImageView poweredByContextHub;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        versionInfo.setText(getString(R.string.version_info, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE));
        poweredByContextHub.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.contexthub_url)));
        startActivity(intent);
    }
}

