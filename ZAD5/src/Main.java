import javax.swing.*;
import java.util.List;

public class Main extends JFrame {

    private JButton startButton;
    private JLabel statusLabel;

    public Main() {
        setTitle("Wersja NAPRAWIONA");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        startButton = new JButton("Start");
        startButton.setBounds(90, 10, 100, 30);

        statusLabel = new JLabel("Status...");
        statusLabel.setBounds(60, 60, 200, 30);

        add(startButton);
        add(statusLabel);

        startButton.addActionListener(e -> {

            SwingWorker<Void, String> worker = new SwingWorker<>() {

                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        publish("Pracuję... " + (i + 1) + "s");
                    }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {
                    statusLabel.setText(chunks.get(chunks.size() - 1));
                }

                @Override
                protected void done() {
                    statusLabel.setText("Zakończono pomyślnie!");
                }
            };

            worker.execute();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
