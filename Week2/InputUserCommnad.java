import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;

public class InputUserCommnad {

    private VideoList videoList = new VideoList();

    public void play() throws IOException {
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer commandTokens = new StringTokenizer(br.readLine());


            String command = commandTokens.nextToken();
            String videoTitle = commandTokens.nextToken();
            String vidoeIndex = "";

            if(commandTokens.hasMoreElements()){
                vidoeIndex = commandTokens.nextToken();
            }

            Commands inputCommand = Commands.valueOf(command);

            switch (inputCommand){
                case add :
                    Video video = new Video(autoGentratedId(), videoTitle, randomPlayTime());
                    videoList.add(video);
                    break;
                case insert:
                    Video insert = new Video(autoGentratedId(), videoTitle, randomPlayTime());
                    videoList.insert(insert, Integer.parseInt(vidoeIndex));
                    break;
                case delete:
                    videoList.delete(videoTitle);
                    break;
                case exit:
                    return;
            }
        }
    }

    private String autoGentratedId(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id;
    }

    private int randomPlayTime(){
        Random random = new Random();
        int playTime = random.nextInt();
        return playTime;
    }
}
