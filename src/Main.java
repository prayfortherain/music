import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static void main(String[] args) {
        Thread saveMp3 = new Thread(() -> {
            try {
                URL website = new URL("https://rur.hitmotop.com/get/music/20201219/HEALTH_Window_Weather_-_Major_Crimes_72017415.mp3");
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream("Major_crimes.mp3");
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Скачивание музыки завершено. \nВоспроизводим.");
            playMp3("C:\\Users\\acer\\IdeaProjects\\untitled6\\Major_crimes.mp3");
        });
        Thread savePic = new Thread(() -> {
            try {
                URL website = new URL("https://i.pinimg.com/564x/c0/f8/fd/c0f8fd69e0f80d1150dc7725a5200b9c.jpg");
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream("pic.jpg");
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Скачивание картинки завершено.");
        });
        saveMp3.start();
        savePic.start();
    }

    public static void playMp3(String filePath) {
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            Player player = new Player(inputStream);
            player.play();
            System.out.println("Песенка кончилась.");
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}