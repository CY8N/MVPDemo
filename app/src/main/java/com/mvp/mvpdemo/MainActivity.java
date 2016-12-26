package com.mvp.mvpdemo;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mvp.mvpdemo.contract.Contract;
import com.mvp.mvpdemo.databinding.ActivityMainBinding;
import com.mvp.mvpdemo.presenter.IPresenterDownloadImpl;
import com.mvp.mvpdemo.view.BaseActivity;

public class MainActivity extends BaseActivity<Contract.IView, Contract.IPresenterDownload<Contract.IView>>
        implements Contract.IView {

<<<<<<< HEAD
    private static final String PIC_DOWN_URL = "http://ww4.sinaimg.cn/mw1024/005vbOHfgw1eylg2gnnrlj30ia0s87ac.jpg";
=======
    private static final String PIC_DOWN_URL = "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E7%BE%8E%E5%A5%B3%E5%9B%BE%E7%89%87&hs=0&pn=0&spn=3&di=0&pi=15906347949&rn=1&tn=baiduimagedetail&is=0%2C94912&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2193991606%2C2366854261&os=&simid=&adpicid=0&ln=30&fr=ala&fm=&sme=&cg=girl&bdtype=-1&oriquery=&objurl=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff703738da97739125daca7e5fb198618377ae2a8.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bp7rtwgz3_z%26e3Bv54AzdH3F4jtgeAzdH3Fda8ca889AzdH3F8mm0d_z%26e3Bip4s&gsm=0";
>>>>>>> 688241c98db72ef878fcdedfd7b8e9e87222cddb
    private ActivityMainBinding mDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        mDataBinding.setPresenter(new DataBindingPresenter());
    }

    @Override
    public Contract.IPresenterDownload createPresenter() {
        return new IPresenterDownloadImpl();
    }

    @Override
    public void onShowPic(final Bitmap pic) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mDataBinding.ivPic.setImageBitmap(pic);
                Toast.makeText(MainActivity.this, "download successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDownloadFailed() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "download failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onShowDowning() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "onDowning", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class DataBindingPresenter {
        public void onClick(View view) {
            mPresenter.startDownload(PIC_DOWN_URL);
        }
    }




}
