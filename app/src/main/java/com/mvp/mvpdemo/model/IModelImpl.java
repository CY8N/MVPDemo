package com.mvp.mvpdemo.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.mvp.mvpdemo.contract.Contract;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by yuning on 16-12-26.
 */
public class IModelImpl implements Contract.IModel {

    @Override
    public void download(final String url,
                         final Contract.OnDownloadListener onDownloadListener) {
        if (onDownloadListener == null)
            return;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL picUrl = new URL(url);
                    URLConnection conn = picUrl.openConnection();
                    conn.setConnectTimeout(5 * 1000);
                    Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream());
                    onDownloadListener.onDownloadSuccess(bitmap);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    onDownloadListener.onDownloadFailed();
                } catch (IOException e) {
                    e.printStackTrace();
                    onDownloadListener.onDownloadFailed();
                }
            }
        }).start();

    }
}
