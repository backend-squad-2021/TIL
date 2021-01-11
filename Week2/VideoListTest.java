import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class VideoListTest {

    Video martion;
    Video tenet;
    Video inception;
    Video titanic;
    Video Xman;
    Video IronMan;
    VideoList videoList;

    @Before // same as BeforEach
    public void initObject(){
        martion = new Video("abcd", "martion", 12);
        tenet = new Video("aofd", "tenet", 20);
        inception = new Video("dogh","inception",30);
        titanic = new Video("ftoh", "titanic", 60);
        Xman = new Video("ffads", "Xman", 70);
        IronMan = new Video("ggggg", "IronMan", 90);
        videoList = new VideoList();
    }


    @Test
    public void addVideoTest(){
        videoList.add(martion);
        videoList.add(tenet);

        int expectedSize = 2;
        Video expectedNextNode = tenet;
        Video expectedPreviousNode = martion;

        int sizeResult = videoList.getSize();
        Video prevoiusNodeResult = tenet.getPrevious();
        Video nextNodeResult = martion.getNext();

        Assertions.assertThat(sizeResult).isEqualTo(expectedSize);
        Assertions.assertThat(prevoiusNodeResult).isEqualTo(expectedPreviousNode);
        Assertions.assertThat(nextNodeResult).isEqualTo(nextNodeResult);
    }

    @Test
    public void deleteVideoTest(){
        videoList.add(martion);
        videoList.add(tenet);
        videoList.add(IronMan);
        videoList.delete("tenet");

        Video expectedNextNode = IronMan;
        Video expectedPreviousNode = martion;
        int expectedSize = 2;

        Video resultNextnode = martion.getNext();
        Video resultPreviousNode = IronMan.getPrevious();
        int resultSize = videoList.getSize();

        Assertions.assertThat(resultNextnode).isEqualTo(expectedNextNode);
        Assertions.assertThat(resultPreviousNode).isEqualTo(resultPreviousNode);
        Assertions.assertThat(resultSize).isEqualTo(expectedSize);
    }

    @Test
    public void insertVideoTest(){
        videoList.add(martion);
        videoList.add(tenet);
        videoList.add(IronMan);
        videoList.insert(titanic,1);

        Video expectedPrevious = titanic;
        Video expectedNext = martion;

        Assertions.assertThat(martion.getPrevious()).isEqualTo(expectedPrevious);
        Assertions.assertThat(titanic.getNext()).isEqualTo(expectedNext);
    }


}
