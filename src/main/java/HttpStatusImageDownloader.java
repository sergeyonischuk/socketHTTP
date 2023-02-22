import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String path = "";
        try {
            path = httpStatusChecker.getStatusImage(code);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        URL url = new URL(path + ".jpg");
        BufferedImage img = ImageIO.read(url);
        File file = new File("src/main/resources/cats/" + code + ".jpg");
        ImageIO.write(img, "jpg", file);
    }
}
