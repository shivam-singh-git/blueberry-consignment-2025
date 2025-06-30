package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001aN\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2 \b\u0002\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u001a4\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a$\u0010\u0018\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0007\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\rH\u0007\u00a8\u0006 "}, d2 = {"ConsignmentDetailScreen", "", "consignmentId", "", "onNavigateBack", "Lkotlin/Function0;", "onLogout", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/ConsignmentDetailViewModel;", "ConsignmentItemCard", "item", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "canEdit", "", "onQuantityChange", "Lkotlin/Function1;", "", "onItemEdit", "Lkotlin/Function3;", "ConsignmentTitleCard", "name", "itemCount", "isAdmin", "onNameChange", "DeleteConfirmationDialog", "onConfirm", "onDismiss", "QuantityBox", "value", "total", "StatusAssistChip", "isCompleted", "app_debug"})
public final class ConsignmentDetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ConsignmentDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.ConsignmentDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ConsignmentTitleCard(@org.jetbrains.annotations.NotNull()
    java.lang.String name, int itemCount, boolean isAdmin, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNameChange) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ConsignmentItemCard(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.ConsignmentItem item, boolean canEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onQuantityChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onItemEdit) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuantityBox(int value, int total) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatusAssistChip(boolean isCompleted) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DeleteConfirmationDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
}