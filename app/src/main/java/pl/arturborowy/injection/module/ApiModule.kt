package pl.arturborowy.injection.module

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import pl.arturborowy.data.remote.StudioGhibliApi
import pl.arturborowy.util.RetrofitBuilder
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    @Singleton
    internal fun provideStudioGhibliApi(retrofitBuilder: RetrofitBuilder,
                                        okHttpClient: OkHttpClient,
                                        moshi: Moshi): StudioGhibliApi =
            retrofitBuilder.getRetrofit(StudioGhibliApi.BASE_URL, okHttpClient, moshi)
                    .create(StudioGhibliApi::class.java)
}