package com.xcg.library.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by xiongchengguang on 2018/7/27.
 */
class BaseSubscriber<T> : Observer<BaseData<T>> {

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: BaseData<T>) {
        success(t)
    }

    override fun onError(e: Throwable) {
    }

    fun success(t: BaseData<T>){

    }
}