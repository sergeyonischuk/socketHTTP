import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class HttpImageStatusCli {
    public void askStatus() throws IOException {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        while (true) {
            boolean validation;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter HTTP status code");
            String value = reader.readLine();
            validation = isStringInt(value);
            if (validation) {
                try {
                    downloader.downloadStatusImage(Integer.parseInt(value));
                    System.out.println("image added");
                } catch (MalformedURLException e) {
                    System.out.println("There is not image for HTTP status " + value);
                }
            }
            if (value.equals("STOP")) {
                break;
            }
        }
    }

    private boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Please enter valid number");
            return false;
        }
    }
}
