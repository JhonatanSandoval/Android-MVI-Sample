package pro.jsandoval.mvisample.di

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import pro.jsandoval.mvisample.BuildConfig
import pro.jsandoval.mvisample.data.api.Api
import pro.jsandoval.mvisample.data.api.AppInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Simple implementation
 */

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAppInterceptor(): AppInterceptor {
        return AppInterceptor(BuildConfig.VERSION_NAME)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): Interceptor {
        return LoggingInterceptor.Builder()
            .loggable(BuildConfig.DEBUG)
            .setLevel(Level.BASIC)
            .tag("Api Call")
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(appInterceptor: AppInterceptor, interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(appInterceptor)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://pokeapi.co/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(Api::class.java)
    }
}