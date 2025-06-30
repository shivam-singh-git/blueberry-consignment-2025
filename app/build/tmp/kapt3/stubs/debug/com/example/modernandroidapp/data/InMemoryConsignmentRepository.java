package com.example.modernandroidapp.data;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005J\b\u0010\u0010\u001a\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0015J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0015H\u0016J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rJ\u0016\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u001e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/modernandroidapp/data/InMemoryConsignmentRepository;", "Lcom/example/modernandroidapp/data/ConsignmentRepository;", "()V", "_consignments", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/modernandroidapp/data/Consignment;", "_historyConsignments", "addConsignment", "", "consignment", "(Lcom/example/modernandroidapp/data/Consignment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerName", "", "items", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "addSampleData", "deleteConsignment", "consignmentId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConsignmentById", "Lkotlinx/coroutines/flow/Flow;", "id", "getHistoryConsignments", "getOngoingConsignments", "moveToHistory", "updateConsignment", "updateDeliveredQuantity", "itemIndex", "", "deliveredQuantity", "updateItemDeliveryStatus", "delivered", "", "app_debug"})
public final class InMemoryConsignmentRepository implements com.example.modernandroidapp.data.ConsignmentRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.modernandroidapp.data.Consignment>> _consignments = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.modernandroidapp.data.Consignment>> _historyConsignments = null;
    
    @javax.inject.Inject()
    public InMemoryConsignmentRepository() {
        super();
    }
    
    private final void addSampleData() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.modernandroidapp.data.Consignment>> getOngoingConsignments() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.example.modernandroidapp.data.Consignment> getConsignmentById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addConsignment(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.Consignment consignment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateConsignment(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.Consignment consignment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.modernandroidapp.data.Consignment>> getHistoryConsignments() {
        return null;
    }
    
    public final void addConsignment(@org.jetbrains.annotations.NotNull()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.modernandroidapp.data.ConsignmentItem> items) {
    }
    
    public final void updateDeliveredQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, int itemIndex, int deliveredQuantity) {
    }
    
    public final void moveToHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId) {
    }
    
    public final void updateItemDeliveryStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, int itemIndex, boolean delivered) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteConsignment(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}