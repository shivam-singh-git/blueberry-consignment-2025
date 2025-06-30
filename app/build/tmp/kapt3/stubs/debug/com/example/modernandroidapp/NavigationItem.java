package com.example.modernandroidapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0003\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/example/modernandroidapp/NavigationItem;", "", "route", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "title", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getRoute", "()Ljava/lang/String;", "getTitle", "AddConsignment", "History", "Home", "Lcom/example/modernandroidapp/NavigationItem$AddConsignment;", "Lcom/example/modernandroidapp/NavigationItem$History;", "Lcom/example/modernandroidapp/NavigationItem$Home;", "app_debug"})
public abstract class NavigationItem {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    
    private NavigationItem(java.lang.String route, androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String title) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/modernandroidapp/NavigationItem$AddConsignment;", "Lcom/example/modernandroidapp/NavigationItem;", "()V", "app_debug"})
    public static final class AddConsignment extends com.example.modernandroidapp.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.modernandroidapp.NavigationItem.AddConsignment INSTANCE = null;
        
        private AddConsignment() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/modernandroidapp/NavigationItem$History;", "Lcom/example/modernandroidapp/NavigationItem;", "()V", "app_debug"})
    public static final class History extends com.example.modernandroidapp.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.modernandroidapp.NavigationItem.History INSTANCE = null;
        
        private History() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/modernandroidapp/NavigationItem$Home;", "Lcom/example/modernandroidapp/NavigationItem;", "()V", "app_debug"})
    public static final class Home extends com.example.modernandroidapp.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.modernandroidapp.NavigationItem.Home INSTANCE = null;
        
        private Home() {
        }
    }
}