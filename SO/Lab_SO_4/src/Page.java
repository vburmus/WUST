public class Page {
    private int pageId;
    private int time;

    private boolean allocated;

    public Page(int _id){
        this.pageId = _id;
        this.time = 0;
        this.allocated = false;
    }

    public int getPageId() {
        return pageId;
    }

    public int getTime() {
        return time;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocatedTrue() {
        this.allocated = true;
    }
    public void setAllocatedFalse() {
        this.allocated = false;
        time  = 0;
    }

    @Override
    public String toString() {
        return "Page " + pageId + " isAllocated=" + allocated ;
    }
}
