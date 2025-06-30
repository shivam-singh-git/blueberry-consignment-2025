package com.example.modernandroidapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a8\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\b\u0010\u0011\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0015"}, d2 = {"BottomNavigationBar", "", "navController", "Landroidx/navigation/NavController;", "userRole", "Lcom/example/modernandroidapp/data/UserRole;", "currentRoute", "", "PlaceholderScreen", "title", "color", "Landroidx/compose/ui/graphics/Color;", "buttonText", "onClick", "Lkotlin/Function0;", "PlaceholderScreen-RPmYEkk", "(Ljava/lang/String;JLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "RealNavApp", "RoleBasedMainScreen", "currentUserRole", "onLogout", "app_debug"})
public final class MainActivityKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void RoleBasedMainScreen(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.UserRole currentUserRole, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RealNavApp() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BottomNavigationBar(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.UserRole userRole, @org.jetbrains.annotations.Nullable()
    java.lang.String currentRoute) {
    }
}