package com.example.modernandroidapp.data;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u0010J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\f\u0010\u001f\u001a\u00020\r*\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/modernandroidapp/data/RoomConsignmentRepository;", "Lcom/example/modernandroidapp/data/ConsignmentRepository;", "consignmentDao", "Lcom/example/modernandroidapp/data/dao/ConsignmentDao;", "consignmentItemDao", "Lcom/example/modernandroidapp/data/dao/ConsignmentItemDao;", "(Lcom/example/modernandroidapp/data/dao/ConsignmentDao;Lcom/example/modernandroidapp/data/dao/ConsignmentItemDao;)V", "addConsignment", "", "customerName", "", "items", "", "Lcom/example/modernandroidapp/data/ConsignmentItem;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConsignmentById", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/modernandroidapp/data/Consignment;", "id", "getHistoryConsignments", "getOngoingConsignments", "initializeSampleData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveToHistory", "consignmentId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeliveredQuantity", "itemIndex", "", "deliveredQuantity", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toConsignmentItem", "Lcom/example/modernandroidapp/data/entity/ConsignmentItemEntity;", "app_release"})
public final class RoomConsignmentRepository implements com.example.modernandroidapp.data.ConsignmentRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.dao.ConsignmentDao consignmentDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.modernandroidapp.data.dao.ConsignmentItemDao consignmentItemDao = null;
    
    @javax.inject.Inject()
    public RoomConsignmentRepository(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.dao.ConsignmentDao consignmentDao, @org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.dao.ConsignmentItemDao consignmentItemDao) {
        super();
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.modernandroidapp.data.Consignment>> getHistoryConsignments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addConsignment(@org.jetbrains.annotations.NotNull()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.modernandroidapp.data.ConsignmentItem> items, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateDeliveredQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, int itemIndex, int deliveredQuantity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object moveToHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object initializeSampleData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.example.modernandroidapp.data.ConsignmentItem toConsignmentItem(com.example.modernandroidapp.data.entity.ConsignmentItemEntity $this$toConsignmentItem) {
        return null;
    }
}