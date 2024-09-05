import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

public class WeatherApp extends JFrame {

    public WeatherApp() {
        // setup our gui and add a title
        super( "Weather App");

        // configure gui to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of our gui (in pixels)
        setSize(450,650);

        // load our gui at the center of the screen
        setLocationRelativeTo(null);

        // make our layout manager null to manually position our components  within the gui
        setLayout(null);

        // prevent any resize of our gui
        setResizable(false);

        addGuiComponents();

    }

    private void addGuiComponents() {

        // search field
        JTextField searchTetField = new JTextField();

        // set the location and size our components
        searchTetField.setBounds(15,15,351,45);

        // change the font style and size
        searchTetField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTetField);

        // search button
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        // change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375,13,47,45);
        add(searchButton);

        // weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/cloudy.png"));
        weatherConditionImage.setBounds(0,125,450,217);
        add(weatherConditionImage);

        // temperature text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0,350, 450, 54);
        temperatureText.setFont((new Font("Dialog", Font.BOLD, 48)));

        // center the text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);

    }

    // used to create images in our gui components
    private ImageIcon loadImage(String resourcePath) {
        try{

            // read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));

            // return an image icon so that our component can render it
            return new ImageIcon(image);

        }catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Could not find resource.");
        return null;
    }


}
