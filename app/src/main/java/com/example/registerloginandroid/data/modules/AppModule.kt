package com.example.registerloginandroid.data.modules

import com.example.registerloginandroid.util.Constants.BASE_URL
import com.example.registerloginandroid.data.UserApi
import com.example.registerloginandroid.data.repository.UserRepository
import com.example.registerloginandroid.data.repositoryImplementations.UserRepositoryImplementation
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    single<UserRepository> {
        UserRepositoryImplementation(get())
    }

    viewModel<RegisterViewModel> {
        RegisterViewModel(get())
    }
}