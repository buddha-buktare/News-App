package me.buddha.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import me.buddha.news.data.network.service.ApiService
import me.buddha.news.domain.repository.MainRepository

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

  @Provides
  @ViewModelScoped
  fun provideRepository(
    service: ApiService
  ): MainRepository = MainRepository(service)
}