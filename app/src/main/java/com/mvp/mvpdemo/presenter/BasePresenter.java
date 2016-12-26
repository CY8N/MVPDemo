package com.mvp.mvpdemo.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by yuning on 16-12-26.
 */
public class BasePresenter<V> {
    private WeakReference<V> weakRefView;
    public void attach(V view){
        weakRefView = new WeakReference<V>(view);
    }

    public void detach()
    {
        if(isAttach())
        {
            weakRefView.clear();
            weakRefView = null;
        }
    }
    public V obtainView(){
        return isAttach()?weakRefView.get():null;
    }

    protected boolean isAttach()
    {
        return weakRefView != null &&
                weakRefView.get() != null;
    }
}
