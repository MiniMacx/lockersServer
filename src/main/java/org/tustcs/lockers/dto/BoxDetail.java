package org.tustcs.lockers.dto;

/**
 * Created by Airmacx on 2017/11/4.
 */
public class BoxDetail {
    private String lockersId;
    private int id;
    private int boxId;
    private int isUsed;
    private String typeName;
    private int cost;

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(int isUsed) {
        this.isUsed = isUsed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLockersId() {
        return lockersId;
    }

    public void setLockersId(String lockersId) {
        this.lockersId = lockersId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
