package org.tustcs.lockers.entity;

public class Box {
    private Integer boxId;

    private String lockersId;

    private Integer typeId;

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public String getLockersId() {
        return lockersId;
    }

    public void setLockersId(String lockersId) {
        this.lockersId = lockersId == null ? null : lockersId.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}