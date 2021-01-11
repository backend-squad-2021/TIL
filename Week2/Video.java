public class Video {

    private String id;
    private String title;
    private int playTime;
    private int index = 0;

    //Connect Info
    private Video previous = null;
    private Video next = null;

    public Video(String id, String title, int playTime) {
        this.id = id;
        this.title = title;
        this.playTime = playTime;
    }


    @Override
    public String toString() {
        return title+"("+ id +"):"+playTime;
    }

    public String addTime(){
        return "[" + id + ", " +title +" , " + playTime + "sec" +"]";
    }

    public void setPrevious(Video previous) {
        this.previous = previous;
    }

    public void setNext(Video next) {
        this.next = next;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPlayTime() {
        return playTime;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Video getPrevious() {
        return previous;
    }

    public Video getNext() {
        return next;
    }
}
