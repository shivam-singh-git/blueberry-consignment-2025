package com.example.modernandroidapp;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/modernandroidapp/ModernAndroidApp;", "Landroid/app/Application;", "()V", "repository", "Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "getRepository", "()Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "setRepository", "(Lcom/example/modernandroidapp/data/RoomConsignmentRepository;)V", "onCreate", "", "app_release"})
public final class ModernAndroidApp extends android.app.Application {
    @javax.inject.Inject()
    public com.example.modernandroidapp.data.RoomConsignmentRepository repository;
    
    public ModernAndroidApp() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.modernandroidapp.data.RoomConsignmentRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.RoomConsignmentRepository p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
}