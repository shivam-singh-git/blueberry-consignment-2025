package com.example.modernandroidapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a:\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a:\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001aD\u0010\u001a\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u0019H\u0007\u001a+\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0002\b#H\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006$"}, d2 = {"AddConsignmentScreen", "", "viewModel", "Lcom/example/modernandroidapp/ui/viewmodels/AddConsignmentViewModel;", "onConsignmentAdded", "Lkotlin/Function0;", "ModernErrorCard", "error", "", "ModernIconButton", "onClick", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "tint", "Landroidx/compose/ui/graphics/Color;", "ModernIconButton-g2O1Hgs", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;J)V", "ModernItemForm", "item", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "onItemChange", "Lkotlin/Function1;", "onRemove", "canRemove", "", "ModernPillButton", "text", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "isPrimary", "ModernSectionCard", "title", "content", "Landroidx/compose/runtime/Composable;", "app_debug"})
public final class AddConsignmentScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AddConsignmentScreen(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.ui.viewmodels.AddConsignmentViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onConsignmentAdded) {
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