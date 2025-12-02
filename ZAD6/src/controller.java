import javax.swing.*;

public class controller {

    private View view;
    private Model model;

    public controller(View view, Model model) {
        this.view = view;
        this.model = model;
        dodajNasluchiwanie();
    }

    private void dodajNasluchiwanie() {

        view.loginButton.addActionListener(e -> {

            view.loginButton.setEnabled(false);
            view.statusLabel.setText("Trwa weryfikacja danych...");

            String login = view.loginField.getText();
            String haslo = new String(view.hasloField.getPassword());

            SwingWorker<Boolean, Void> worker = new SwingWorker<>() {

                @Override
                protected Boolean doInBackground() {
                    return model.walidujLogowanie(login, haslo);
                }

                @Override
                protected void done() {

                    try {
                        boolean wynik = get();

                        if (wynik) {
                            view.statusLabel.setText("Logowanie pomyślne!");
                        } else {
                            view.statusLabel.setText("Błędny login lub hasło!");
                        }

                        view.loginButton.setEnabled(true);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            worker.execute();
        });
    }
}
