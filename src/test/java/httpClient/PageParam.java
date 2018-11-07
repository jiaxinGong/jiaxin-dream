package httpClient;

import java.io.Serializable;

public class PageParam implements Serializable {

    private static final long serialVersionUID = -4887397152922563754L;
    private Integer pageNo;// 页码

    private Integer pageSize;// 页容量


    public Integer getPageNo() {
        if (pageNo == null) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return 200;
        }
        return pageSize;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageParam{" +
            "pageNo=" + pageNo +
            ", pageSize=" + pageSize +
            '}';
    }
}
