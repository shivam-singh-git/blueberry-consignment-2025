package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0003\u001a\u001e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u0016\u0010\u000e\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a \u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0003\u001a4\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0003\u001a\u0018\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0003\u001a\b\u0010\"\u001a\u00020\u0001H\u0003\u001a\u0010\u0010#\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0003\u001a,\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0012\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u001aH\u0003\u001a\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0003H\u0003\u001a\f\u0010*\u001a\u00020\u0003*\u00020\u0003H\u0002\u00a8\u0006+"}, d2 = {"ConsignmentDetailScreen", "", "consignmentId", "", "onNavigateBack", "Lkotlin/Function0;", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/ConsignmentDetailViewModel;", "ModernConsignmentOverviewCard", "consignment", "Lcom/example/modernandroidapp/data/Consignment;", "ModernErrorState", "message", "onRetry", "ModernHeaderSection", "ModernInfoChip", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "value", "ModernItemDetailCard", "item", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "index", "", "onDeliveredQuantityChange", "Lkotlin/Function1;", "canEdit", "", "ModernItemStatusBadge", "deliveredQuantity", "totalQuantity", "ModernItemsSectionHeader", "itemCount", "ModernLoadingShimmer", "ModernProgressSummaryCard", "ModernQuantityUpdater", "currentQuantity", "maxQuantity", "onQuantityChange", "ModernStatusBadge", "status", "capitalize", "app_release"})
public final class ConsignmentDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ConsignmentDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernHeaderSection(kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernConsignmentOverviewCard(com.example.modernandroidapp.data.Consignment consignment) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernProgressSummaryCard(com.example.modernandroidapp.data.Consignment consignment) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernItemsSectionHeader(int itemCount, boolean canEdit) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernItemDetailCard(com.example.modernandroidapp.data.ConsignmentItem item, int index, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onDeliveredQuantityChange, boolean canEdit) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernStatusBadge(java.lang.String status) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernItemStatusBadge(int deliveredQuantity, int totalQuantity) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernInfoChip(androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String label, java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernQuantityUpdater(int currentQuantity, int maxQuantity, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onQuantityChange) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernLoadingShimmer() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernErrorState(java.lang.String message, kotlin.jvm.functions.Function0<kotlin.Unit> onRetry) {
    }
    
    private static final java.lang.String capitalize(java.lang.String $this$capitalize) {
        return null;
    }
}