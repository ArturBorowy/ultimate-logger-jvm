package pl.arturborowy.util.extensionfunctions

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <OnNextT> Observable<OnNextT>.toUiInteraction(): Observable<OnNextT> =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <OnSuccessT> Single<OnSuccessT>.toUiInteraction(): Single<OnSuccessT> =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <OnSuccessT> Maybe<OnSuccessT>.toUiInteraction(): Maybe<OnSuccessT> =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun Completable.toUiInteraction(): Completable =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())