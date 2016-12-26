package com.mvp.mvpdemo.presenter;

import android.graphics.Bitmap;

import com.mvp.mvpdemo.contract.Contract;
import com.mvp.mvpdemo.model.IModelImpl;

/**
 * Created by yuning on 16-12-26.
 */
public class IPresenterDownloadImpl
        extends Contract.IPresenterDownload<Contract.IView> {

    private Contract.IModel model;

    public IPresenterDownloadImpl() {
        model = new IModelImpl();
    }

    @Override
    public void startDownload(String url) {
        final Contract.IView view = IPresenterDownloadImpl.this.obtainView();
        if (view == null)
            return;
        view.onShowDowning();
        model.download(url, new Contract.OnDownloadListener() {
            @Override
            public void onDownloadSuccess(Bitmap pic) {
                view.onShowPic(pic);
            }

            @Override
            public void onDownloadFailed() {
                view.onDownloadFailed();
            }
        });
    }
}
