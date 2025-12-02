public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            View view = new View();
            Model model = new Model();
            new controller(view, model);

            view.setVisible(true);
        });
    }
}
