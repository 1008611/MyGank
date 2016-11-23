package com.wildwolf.mygank.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wildwolf.mygank.App;
import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GankItemData;
import com.wildwolf.mygank.utils.ImageLoader;

import butterknife.Bind;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class GankDetailActivity extends BaseActivity {

    private GankItemData mGankItemData;

//    @Bind(R.id.gank_detail_toolbar)
//    Toolbar mToolbar;
//
//    @Bind(R.id.gank_detail_webview)
//    WebView mWebView;
//
//    @Bind(R.id.gank_detail_loading)
//    AVLoadingIndicatorView mLoading;
//
//    @Bind(R.id.gank_detail_progress)
//    ProgressBar mProgressBar;


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private String id;
    @Bind(R.id.web_view)
    WebView mWebView;
    @Bind(R.id.iv_web_img)
    ImageView webImg;
    @Bind(R.id.tv_img_title)
    TextView imgTitle;
    @Bind(R.id.tv_img_source)
    TextView imgSource;

    @Bind(R.id.gank_detail_progress)
    ProgressBar mProgressBar;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_gank_detail2;
    }

    @Override
    protected void initView() {
        initToolbar();
        initWebView();
    }

    @Override
    protected void initData() {
        mGankItemData = getIntent().getParcelableExtra("gank_item_data");
    }

    private void initWebView() {
        final WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setBlockNetworkImage(true);

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                mLoading.hide();
                settings.setBlockNetworkImage(false);
            }
        });
        mWebView.loadUrl(mGankItemData.getUrl());
    }

    private void initToolbar() {
        String desc = mGankItemData.getDesc();
        desc = desc.length() > 10 ? desc.substring(0, 10) + "..." : desc;
        toolbar.setTitle(desc);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        imgTitle.setText(mGankItemData.getDesc());
        imgSource.setText("来自:" + mGankItemData.getWho());

        String[] images = mGankItemData.getImages();
        if (images != null && images.length > 0) {
            ImageLoader.load(App.getContext(),
                    images[0] + "?imageView2/0/w/100", webImg, R.drawable.web);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        mWebView.destroy();
        super.onDestroy();
    }
}
