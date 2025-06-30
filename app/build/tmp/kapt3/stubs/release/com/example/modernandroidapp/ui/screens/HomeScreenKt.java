package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a4\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001a\b\u0010\r\u001a\u00020\u0001H\u0003\u001a\u0016\u0010\u000e\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001a\b\u0010\u000f\u001a\u00020\u0001H\u0003\u001a\b\u0010\u0010\u001a\u00020\u0001H\u0003\u001a[\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u00a2\u0006\u0002\b\u001cH\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0006H\u0003\u001a2\u0010!\u001a\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u0016\u0010\'\u001a\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#H\u0003\u001a\f\u0010(\u001a\u00020\u0006*\u00020\u0006H\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006)"}, d2 = {"HomeScreen", "", "onNavigateToAddConsignment", "Lkotlin/Function0;", "onNavigateToConsignmentDetail", "Lkotlin/Function1;", "", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/HomeViewModel;", "ModernConsignmentCard", "consignment", "Lcom/example/modernandroidapp/data/Consignment;", "onClick", "ModernEmptyState", "ModernFloatingActionButton", "ModernHeaderSection", "ModernLoadingShimmer", "ModernStatsCard", "modifier", "Landroidx/compose/ui/Modifier;", "title", "value", "subtitle", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "iconTint", "Landroidx/compose/ui/graphics/Color;", "content", "Landroidx/compose/runtime/Composable;", "ModernStatsCard-hftG7rw", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLkotlin/jvm/functions/Function0;)V", "ModernStatusBadge", "status", "OngoingConsignmentsSection", "consignments", "", "isLoading", "", "onConsignmentClick", "QuickStatsSection", "capitalize", "app_release"})
public final class HomeScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAddConsignment, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToConsignmentDetail, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.HomeViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernHeaderSection() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void QuickStatsSection(java.util.List<com.example.modernandroidapp.data.Consignment> consignments) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void OngoingConsignmentsSection(java.util.List<com.example.modernandroidapp.data.Consignment> consignments, boolean isLoading, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConsignmentClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernConsignmentCard(com.example.modernandroidapp.data.Consignment consignment, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernStatusBadge(java.lang.String status) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernLoadingShimmer() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernEmptyState() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernFloatingActionButton(kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    private static final java.lang.String capitalize(java.lang.String $this$capitalize) {
        return null;
    }
}