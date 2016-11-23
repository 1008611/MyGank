package com.wildwolf.mygank.ui.activity;

import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GirlsItemData;
import com.wildwolf.mygank.utils.ImageLoader;

import butterknife.Bind;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class GirlsDetailActivity extends  BaseActivity {

    private static final String URL = "girls_data";

    private String mUrl;
    private GirlsItemData girlsItemData;

    @Bind(R.id.girl_detail_iv)
    PhotoView mImageView;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_girl_detail;
    }

    @Override
    protected void initView() {
        ImageLoader.load(this, mUrl, mImageView);
        PhotoViewAttacher attacher = new PhotoViewAttacher(mImageView);
        attacher.update();
    }

    @Override
    protected void initData() {
        girlsItemData = getIntent().getParcelableExtra(URL);
        mUrl = girlsItemData.getSourceurl();
    }
}
