package com.lanou3g.dev.domain;

/**
 * Created by doubleyLin on 17/11/24.
 * 作者:徐颢
 */

public class Department {
    private int depId;
    private String depName;

    public Department() {
    }

    public Department(String depName) {
        this.depName = depName;
    }

    public Department(int depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                '}';
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
