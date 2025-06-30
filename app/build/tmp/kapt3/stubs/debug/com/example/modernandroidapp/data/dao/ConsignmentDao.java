package com.example.modernandroidapp.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/example/modernandroidapp/data/dao/ConsignmentDao;", "", "deleteConsignmentById", "", "consignmentId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/modernandroidapp/data/entity/ConsignmentEntity;", "getById", "getCompleted", "getOngoing", "insert", "consignment", "(Lcom/example/modernandroidapp/data/entity/ConsignmentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsCompleted", "deliveryDate", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface ConsignmentDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.entity.ConsignmentEntity consignment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.example.modernandroidapp.data.entity.ConsignmentEntity consignment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM consignments")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.modernandroidapp.data.entity.ConsignmentEntity>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM consignments WHERE completed = 0")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.modernandroidapp.data.entity.ConsignmentEntity>> getOngoing();
    
    @androidx.room.Query(value = "SELECT * FROM consignments WHERE completed = 1 ORDER BY deliveryDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.modernandroidapp.data.entity.ConsignmentEntity>> getCompleted();
    
    @androidx.room.Query(value = "SELECT * FROM consignments WHERE id = :consignmentId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.modernandroidapp.data.entity.ConsignmentEntity> getById(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId);
    
    @androidx.room.Query(value = "UPDATE consignments SET completed = 1, deliveryDate = :deliveryDate WHERE id = :consignmentId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAsCompleted(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, long deliveryDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM consignments WHERE id = :consignmentId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteConsignmentById(@org.jetbrains.annotations.NotNull()
    java.lang.String consignmentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}