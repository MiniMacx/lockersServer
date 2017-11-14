package org.tustcs.lockers.entity;

public class Lockers {
    private String lockersId;

    private int boxTotal;

    private int boxUsed;

    private String addr;

    private int isFull;

    private int isDelete;

    public String getLockersId() {
        return lockersId;
    }

    public void setLockersId(String lockersId) {
        this.lockersId = lockersId;
    }

    public int getBoxTotal() {
        return boxTotal;
    }

    public void setBoxTotal(int boxTotal) {
        this.boxTotal = boxTotal;
    }

    public int getBoxUsed() {
        return boxUsed;
    }

    public void setBoxUsed(int boxUsed) {
        this.boxUsed = boxUsed;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getIsFull() {
        return isFull;
    }

    public void setIsFull(int isFull) {
        this.isFull = isFull;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}