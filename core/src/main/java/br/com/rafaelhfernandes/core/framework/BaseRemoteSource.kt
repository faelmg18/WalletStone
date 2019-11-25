package br.com.rafaelhfernandes.core.framework

import br.com.rafaelhfernandes.core.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

open class BaseRemoteSource<T>(clazz: Class<T>) {

    companion object {
        private const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(createOkHttpClient())
        .addConverterFactory(getConvertFactory())
        .build()

    protected val api = retrofit.create(clazz)

    private fun createOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
        }

        return builder.build()
    }

    private fun getConvertFactory(): Converter.Factory {
        return getGsonConverterFactory(getGson())
    }

    private fun getGsonConverterFactory(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    private fun getGson(): Gson {
        return GsonBuilder().setDateFormat(getPattern()).create()
    }

    private fun getPattern(): String {
        return DEFAULT_DATE_FORMAT
    }
}