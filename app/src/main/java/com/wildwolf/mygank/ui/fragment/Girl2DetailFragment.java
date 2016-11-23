package com.wildwolf.mygank.ui.fragment;

import android.os.Bundle;

import com.wildwolf.mygank.R;
import com.wildwolf.mygank.utils.ImageLoader;

import butterknife.Bind;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class Girl2DetailFragment extends BaseFragment {

    private static final String URL = "url";

    private String mUrl;

    @Bind(R.id.girl_detail_iv)
    PhotoView mImageView;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_girl_detail;
    }

    @Override
    protected void initView() {
        ImageLoader.load(mActivity, mUrl, mImageView);
        PhotoViewAttacher attacher = new PhotoViewAttacher(mImageView);
        attacher.update();
    }

    @Override
    protected void initData() {
        if (getArguments() == null) {
            return;
        }
        mUrl = getArguments().getString(URL);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

    }

    public static BaseFragment newInstance(String url) {
        Girl2DetailFragment fragment = new Girl2DetailFragment();
        Bundle arguments = new Bundle();
        arguments.putString(URL, url);
        fragment.setArguments(arguments);
        return fragment;
    }
}
