package com.example.modernandroidapp.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/modernandroidapp/di/AppModule;", "", "()V", "provideAppDatabase", "Lcom/example/modernandroidapp/data/AppDatabase;", "context", "Landroid/content/Context;", "provideConsignmentDao", "Lcom/example/modernandroidapp/data/dao/ConsignmentDao;", "database", "provideConsignmentItemDao", "Lcom/example/modernandroidapp/data/dao/ConsignmentItemDao;", "provideConsignmentRepository", "Lcom/example/modernandroidapp/data/ConsignmentRepository;", "repository", "Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "provideUserSessionManager", "Lcom/example/modernandroidapp/data/UserSessionManager;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.modernandroidapp.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.data.UserSessionManager provideUserSessionManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.data.AppDatabase provideAppDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.data.dao.ConsignmentDao provideConsignmentDao(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.data.dao.ConsignmentItemDao provideConsignmentItemDao(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.data.ConsignmentRepository provideConsignmentRepository(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.RoomConsignmentRepository repository) {
        return null;
    }
}