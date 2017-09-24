package com.cheer.assets.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AssetsFinanceRecordEntity implements Serializable {
    private String id;

    private String assetsId;

    private String desc;

    private String type;

    private BigDecimal beforeVal;

    private BigDecimal turnover;

    private BigDecimal afterVal;

    private Date createDate;

    private String createBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId == null ? null : assetsId.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getBeforeVal() {
        return beforeVal;
    }

    public void setBeforeVal(BigDecimal beforeVal) {
        this.beforeVal = beforeVal;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getAfterVal() {
        return afterVal;
    }

    public void setAfterVal(BigDecimal afterVal) {
        this.afterVal = afterVal;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", assetsId=").append(assetsId);
        sb.append(", desc=").append(desc);
        sb.append(", type=").append(type);
        sb.append(", beforeVal=").append(beforeVal);
        sb.append(", turnover=").append(turnover);
        sb.append(", afterVal=").append(afterVal);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}