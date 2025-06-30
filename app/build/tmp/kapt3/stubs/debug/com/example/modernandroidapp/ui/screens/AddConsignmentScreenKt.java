package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\"\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a:\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a:\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u001aD\u0010\u001b\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\tH\u0007\u001a+\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\b$H\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006%"}, d2 = {"AddConsignmentItemCard", "", "item", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "onItemChange", "Lkotlin/Function1;", "onRemove", "Lkotlin/Function0;", "canRemove", "", "AddConsignmentScreen", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentViewModel;", "onConsignmentAdded", "ModernErrorCard", "error", "", "ModernIconButton", "onClick", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "tint", "Landroidx/compose/ui/graphics/Color;", "ModernIconButton-g2O1Hgs", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;J)V", "ModernItemForm", "ModernPillButton", "text", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "isPrimary", "ModernSectionCard", "title", "content", "Landroidx/compose/runtime/Composable;", "app_debug"})
public final class AddConsignmentScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AddConsignmentScreen(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.AddConsignmentViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onConsignmentAdded) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AddConsignmentItemCard(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.ConsignmentItem item, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.modernandroidapp.data.ConsignmentItem, kotlin.Unit> onItemChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRemove, boolean canRemove) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernSectionCard(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ModernItemForm(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.ConsignmentItem item, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.modernandroidapp.data.ConsignmentItem, kotlin.Unit> onItemChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRemove, boolean canRemove) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernPillButton(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, boolean enabled, boolean isPrimary) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ModernErrorCard(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
}