import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static void main(String[] args) throws IOException {
        String a = "https://rur.hitmotop.com/get/music/20230110/Wichu_kujopjop_Wichu_kujopjop_kujopjop_Wichu_-_ZXC_DOTA2_GHOUL_SSS_RANK_75371926.mp3";
        URL website = new URL(a);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("dota2.mp3");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}