package com.mvp.mvpdemo.contract;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.mvp.mvpdemo.presenter.BasePresenter;

/**
 * Created by yuning on 16-12-26.
 */
public final class Contract {
    private Contract() {
    }

    public static interface IView {
        void onShowPic(Bitmap pic);

        void onDownloadFailed();

        void onShowDowning();
    }

    public static abstract class IPresenterDownload<V> extends BasePresenter<V> {
        public abstract void startDownload(String url);
    }

    public static interface OnDownloadListener {
        void onDownloadSuccess(Bitmap pic);

        void onDownloadFailed();
    }

    public static interface IModel {
        void download(String url, @NonNull OnDownloadListener onDownloadListener);
    }
}
