package com.sevens.brkipedia.di

import android.util.Log
import com.sevens.brkipedia.data.remote.apis.CharacterApi
import com.sevens.brkipedia.data.remote.apis.QuoteApi
import com.sevens.brkipedia.domain.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
    }

    @Singleton
    @Provides
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi{
        return retrofit.create(CharacterApi::class.java)
    }

    @Singleton
    @Provides
    fun provideQuoteApi(retrofit: Retrofit): QuoteApi{
        return retrofit.create(QuoteApi::class.java)
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(interceptor())
        }.build()
    }

    private fun interceptor(): Interceptor {
        return Interceptor { chain ->
            val newRequest = chain.request()
            with(newRequest) {
                body()?.let{
                    print(url().toString(), method(), bodyToString(body()!!), null, true)
                }?: run{
                    print(url().toString(), method(), null, null, true)
                }
            }
            chain.proceed(newRequest)
        }
    }

    private fun print(url: String, method: String, json: String?, headers: String?, isRequest: Boolean = true){
        val tag = "Connection"
        val info = " \n" +
                when(isRequest){
                    true -> "---------- REQUEST ----------"
                    false -> "---------- RESPONSE ----------"
                } +
                "\n" +
                "URL: $url" +
                jsonLine(json) +
                headersLine(headers) +
                "\n"
        Log.i(tag, info)
    }

    private fun headersLine(headers: String?): Any? {
        return if(!headers.isNullOrBlank()) "\nHEADERS: [\n\t${headers.replace("\n", "\n\t")}\n]" else ""
    }

    private fun jsonLine(json: String?): Any? {
        return if(!json.isNullOrBlank()) "\nBODY: \n{ $json\n}" else ""
    }

    private fun bodyToString(request: RequestBody?): String {
        return request?.let {
            try {
                val buffer = okio.Buffer()
                request.writeTo(buffer)
                buffer.readUtf8()
            } catch (e: IOException) {
                "did not work"
            }
        } ?: ""
    }
}
