package com.example.modernandroidapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u001a\u0016\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a&\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a8\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001b"}, d2 = {"ModernBottomNavigation", "", "navController", "Landroidx/navigation/NavHostController;", "tabs", "", "Lcom/example/modernandroidapp/BottomNavTab;", "ModernLogoutButton", "onLogout", "Lkotlin/Function0;", "ModernNavigationItem", "tab", "isSelected", "", "onClick", "PlaceholderScreen", "title", "", "color", "Landroidx/compose/ui/graphics/Color;", "buttonText", "PlaceholderScreen-RPmYEkk", "(Ljava/lang/String;JLjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "RealNavApp", "RoleBasedMainScreen", "currentUserRole", "Lcom/example/modernandroidapp/data/UserRole;", "app_debug"})
public final class MainActivityKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void RoleBasedMainScreen(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.UserRole currentUserRole, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernLogoutButton(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernBottomNavigation(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.example.modernandroidapp.BottomNavTab> tabs) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernNavigationItem(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.BottomNavTab tab, boolean isSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RealNavApp() {
    }
}