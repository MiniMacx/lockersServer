package org.tustcs.lockers.entity;

public class LockersBox {
    private String lockersId;

    private Integer id;

    private Integer boxId;

    private Integer isUsed;

    private Integer avail;

    public String getLockersId() {
        return lockersId;
    }

    public void setLockersId(String lockersId) {
        this.lockersId = lockersId == null ? null : lockersId.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getAvail() {
        return avail;
    }

    public void setAvail(Integer avail) {
        this.avail = avail;
    }
}