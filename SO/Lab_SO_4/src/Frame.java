public class Frame {
    private Page page;
    private int frameId;

    public Frame(int _id){
        this.frameId = _id;
        this.page = new Page(_id);
    }
    public void insertPage(Page _curPage){
        this.page = _curPage;
        this.frameId = _curPage.getPageId();
    }
    public void clearFrame(){
        this.page = null;
        this.frameId = -1;
    }

    public Page getPage() {
        return page;
    }

    public int getFrameId() {
        return frameId;
    }
    public boolean isFull(){
        if(this.frameId == -1)
            return false;
        return true;
    }
}
