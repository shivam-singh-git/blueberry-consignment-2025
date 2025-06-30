package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a$\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\b\u0010\n\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u0016"}, d2 = {"HomeScreen", "", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/HomeViewModel;", "onConsignmentClick", "Lkotlin/Function1;", "", "ModernConsignmentCard", "consignment", "Lcom/example/modernandroidapp/data/Consignment;", "ModernEmptyState", "ModernItemsPreview", "items", "", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "ModernProgressIndicator", "ModernStatsCard", "title", "value", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ModernStatusBadge", "app_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.HomeViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConsignmentClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernConsignmentCard(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.Consignment consignment, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConsignmentClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernStatusBadge(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.Consignment consignment) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernProgressIndicator(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.Consignment consignment) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernItemsPreview(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.modernandroidapp.data.ConsignmentItem> items) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernEmptyState() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernStatsCard(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
}