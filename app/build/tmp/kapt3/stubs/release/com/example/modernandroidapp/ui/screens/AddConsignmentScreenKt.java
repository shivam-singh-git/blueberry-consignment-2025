package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a,\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003\u001a\u0016\u0010\r\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001aT\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\fH\u0003\u001a\u001e\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001a@\u0010\u001a\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#\u001a$\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\nH\u0003\u001a&\u0010\'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u001a\u0016\u0010+\u001a\u00020\u00012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0003\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006-"}, d2 = {"AddConsignmentScreen", "", "onNavigateBack", "Lkotlin/Function0;", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentViewModel;", "ModernCustomerInfoCard", "customerName", "", "onCustomerNameChange", "Lkotlin/Function1;", "isError", "", "ModernHeaderSection", "ModernItemCard", "item", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "index", "", "onItemUpdate", "onRemoveItem", "errorMessage", "canEdit", "ModernItemsSectionHeader", "itemCount", "onAddItem", "ModernPillButton", "onClick", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "text", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "ModernPillButton-jZ3TX3s", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;JJ)V", "ModernQuantityStepper", "quantity", "onQuantityChange", "ModernSubmitButton", "isLoading", "isEnabled", "onSubmit", "ModernSuccessDialog", "onDismiss", "app_release"})
public final class AddConsignmentScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AddConsignmentScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.AddConsignmentViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernHeaderSection(kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernCustomerInfoCard(java.lang.String customerName, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCustomerNameChange, boolean isError) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernItemsSectionHeader(int itemCount, kotlin.jvm.functions.Function0<kotlin.Unit> onAddItem) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernItemCard(com.example.modernandroidapp.data.ConsignmentItem item, int index, kotlin.jvm.functions.Function1<? super com.example.modernandroidapp.data.ConsignmentItem, kotlin.Unit> onItemUpdate, kotlin.jvm.functions.Function0<kotlin.Unit> onRemoveItem, boolean isError, java.lang.String errorMessage, boolean canEdit) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernQuantityStepper(int quantity, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onQuantityChange) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernSubmitButton(boolean isLoading, boolean isEnabled, kotlin.jvm.functions.Function0<kotlin.Unit> onSubmit) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ModernSuccessDialog(kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
}