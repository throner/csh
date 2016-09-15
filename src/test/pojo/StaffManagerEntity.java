package test.pojo;

import javax.persistence.*;

/**
 * Created by chenjiansheng on 2016-4-27.
 */
@Entity
@Table(name = "staff_manager", schema = "test", catalog = "")
public class StaffManagerEntity {
    private String staffName;
    private String staffId;
    private String deptId;

    @Basic
    @Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Id
    @Column(name = "staff_id")
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffManagerEntity that = (StaffManagerEntity) o;

        if (staffName != null ? !staffName.equals(that.staffName) : that.staffName != null) return false;
        if (staffId != null ? !staffId.equals(that.staffId) : that.staffId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffName != null ? staffName.hashCode() : 0;
        result = 31 * result + (staffId != null ? staffId.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "dept_id")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
