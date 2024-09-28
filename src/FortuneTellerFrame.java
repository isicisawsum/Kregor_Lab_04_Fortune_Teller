import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;


public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel bottomPnl;

    JLabel title;
    ImageIcon titleImage;
    JTextArea midText;
    JLabel midLabel;
    JScrollPane scroller;
    JButton fortuneReader;
    JButton quit;


    Font titleFont = new Font("Courier New", Font.BOLD, 28);
    Font midFont = new Font("Calibri", Font.ITALIC, 18);
    Font bottomFont = new Font("Impact", Font.PLAIN, 12);
    int num = 0;

    ArrayList<String> Fortunes = new ArrayList<>();
    int lastFortune = 0;
    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTop();
        mainPnl.add(topPnl, BorderLayout.NORTH);
        createMid();
        mainPnl.add(midPnl, BorderLayout.CENTER);
        createBottom();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        createFortunes();

        add(mainPnl);
        setSize(400,500);
        setLocation(0,0);
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTop(){
        topPnl = new JPanel();
        titleImage = new ImageIcon("src/FortuneTellerTitle.jpg");
        Image image = titleImage.getImage().getScaledInstance(350, 100, Image.SCALE_SMOOTH); //scaling the Image down because my selected one is way too big
        titleImage = new ImageIcon(image);

        title = new JLabel("Test Your Fortune!", titleImage, JLabel.CENTER);
        title.setFont(titleFont);

        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.add(title);
    }
    private void createMid(){
        midPnl = new JPanel();
        midLabel = new JLabel("Find Your Fortune:");
        midText = new JTextArea(10, 25);
        midText.setEditable(false);

        scroller = new JScrollPane(midText);
        midLabel.setFont(midFont);

        midLabel.setVerticalTextPosition(JLabel.CENTER);
        midLabel.setHorizontalTextPosition(JLabel.CENTER);

        midPnl.add(midLabel);
        midPnl.add(scroller);
    }
    private void createBottom(){
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));

        fortuneReader = new JButton("Read My Fortune");
        quit = new JButton("Quit");

        fortuneReader.addActionListener((ActionEvent ae) -> {
            Random random = new Random();

            int randomIndex = 0;


            do{
                for(int i = 0; i < Fortunes.size(); i++){
                    randomIndex = random.nextInt(Fortunes.size());
                }
            }while (lastFortune == randomIndex);


            lastFortune = randomIndex;


            String randomFortune = Fortunes.get(randomIndex);

            num++;

            midText.append(num + ". " +randomFortune + "\n");
        });

        fortuneReader.setFont(bottomFont);
        quit.setFont(bottomFont);

        bottomPnl.add(fortuneReader);
        bottomPnl.add(quit);
        quit.addActionListener((ActionEvent ae) -> System.exit(0));
    }

    private void createFortunes(){
        Fortunes.clear();
        Fortunes.add("Heads up! A loose AC unit will fall on you if you're not wary\n");
        Fortunes.add("You will realize you ran out of toilet paper while you're on the toilet\n");
        Fortunes.add("You will meet Curious George within the next week\n");
        Fortunes.add("You will find Van Gogh's missing ear\n");
        Fortunes.add("You will become friends with a poodle\n");
        Fortunes.add("You will suddenly find that one song that you didn't remember the name of\n");
        Fortunes.add("You will need to watch a two hour long tutorial to get your code to work\n");
        Fortunes.add("You will actually slip on a banana peel\n");
        Fortunes.add("You will find the real life Kool-Aid man\n");
        Fortunes.add("You will click the 'Read My Fortune' button again\n");
        Fortunes.add("You will find an orange that isn't actually orange\n");
        Fortunes.add("A McDonald's employee will forget to put ketchup in your bag\n");
    }

}
