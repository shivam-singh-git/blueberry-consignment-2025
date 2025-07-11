// Generated by Dagger (https://dagger.dev).
package com.example.modernandroidapp.di;

import com.example.modernandroidapp.data.ConsignmentRepository;
import com.example.modernandroidapp.data.RoomConsignmentRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideConsignmentRepositoryFactory implements Factory<ConsignmentRepository> {
  private final Provider<RoomConsignmentRepository> repositoryProvider;

  public AppModule_ProvideConsignmentRepositoryFactory(
      Provider<RoomConsignmentRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ConsignmentRepository get() {
    return provideConsignmentRepository(repositoryProvider.get());
  }

  public static AppModule_ProvideConsignmentRepositoryFactory create(
      Provider<RoomConsignmentRepository> repositoryProvider) {
    return new AppModule_ProvideConsignmentRepositoryFactory(repositoryProvider);
  }

  public static ConsignmentRepository provideConsignmentRepository(
      RoomConsignmentRepository repository) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideConsignmentRepository(repository));
  }
}
