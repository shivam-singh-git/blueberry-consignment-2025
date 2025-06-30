package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u001a\"\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a>\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u001fH\u0007\u001a\b\u0010 \u001a\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006!"}, d2 = {"AnimatedStepperButton", "", "onClick", "Lkotlin/Function0;", "enabled", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AnimatedStepperButton-VT9Kpxs", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;JJ)V", "ConsignmentDetailScreen", "consignmentId", "onNavigateBack", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/ConsignmentDetailViewModel;", "CustomerInfoCard", "consignment", "Lcom/example/modernandroidapp/data/Consignment;", "currentUserRole", "Lcom/example/modernandroidapp/data/UserRole;", "ItemStepperCard", "item", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "index", "", "onQuantityChange", "Lkotlin/Function1;", "ItemsHeader", "app_debug"})
public final class ConsignmentDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ConsignmentDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CustomerInfoCard(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.Consignment consignment, @org.jetbrains.annotations.Nullable()
    com.example.modernandroidapp.data.UserRole currentUserRole, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ItemsHeader() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ItemStepperCard(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.ConsignmentItem item, int index, @org.jetbrains.annotations.Nullable()
    com.example.modernandroidapp.data.UserRole currentUserRole, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onQuantityChange) {
    }
}