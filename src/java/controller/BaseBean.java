package controller;

/**
 *
 * @author Nour
 */
abstract class BaseBean {

    protected int page = 1;
    protected static int pageSize = 3;
    protected int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    abstract int getPageCount();

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public static void setPageSize(int pageSize) {
        BaseBean.pageSize = pageSize;
    }

    /// search
    private String searchTerm;

    public void search() {
        this.setPage(1);
    }

    public void clearSearch() {
        this.setSearchTerm(null);
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
