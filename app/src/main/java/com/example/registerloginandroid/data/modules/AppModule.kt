package com.example.registerloginandroid.data.modules

import com.example.registerloginandroid.util.Constants.BASE_URL
import com.example.registerloginandroid.data.UserApi
import com.example.registerloginandroid.data.models.Login
import com.example.registerloginandroid.data.repository.UserRepository
import com.example.registerloginandroid.data.repositoryImplementations.UserRepositoryImplementation
import com.example.registerloginandroid.ui.screens.loginScreen.LoginViewModel
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.Credentials
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * the app module for koin
 * @author Ömer Aynaci
 */
val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOKHttpClient(Login("keesvandenkaas@hotmail.com","Password1234$")))
            .build()
            .create(UserApi::class.java)
    }

    single<UserRepository> {
        UserRepositoryImplementation(get())
    }

    viewModel<RegisterViewModel> {
        RegisterViewModel(get())
    }

    viewModel<LoginViewModel> {
        LoginViewModel(get())
    }
}

private fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

private fun provideOKHttpClient(login: Login): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            val credentials = Credentials.basic(login.email,login.password)
            val newRequest = chain.request().newBuilder()
                .header("Authorization", credentials)
                .build()
            chain.proceed(newRequest)
        }
        .build()
}