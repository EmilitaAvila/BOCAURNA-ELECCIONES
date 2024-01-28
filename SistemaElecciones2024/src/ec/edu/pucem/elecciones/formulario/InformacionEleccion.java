package ec.edu.pucem.elecciones.formulario;
import javax.swing.*;
import java.awt.*;

public class InformacionEleccion extends JPanel {
    public InformacionEleccion() {
        setBackground(new Color(254, 219, 209));
        setLayout(new GridLayout(2, 2, 10, 10));

        JLabel emailLabel = new JLabel("Correo:");
        emailLabel.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\correo (1).png"));
        emailLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        JLabel emailField = new JLabel("info@example.com");
        emailField.setFont(new Font("Tw Cen MT", Font.ITALIC, 11));
        emailField.setBackground(new Color(254, 219, 209));

        JLabel phoneLabel = new JLabel("Teléfono:");
        phoneLabel.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\llamada-telefonica.png"));
        phoneLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
        JLabel phoneField = new JLabel("+1234567890");
        phoneField.setFont(new Font("Tw Cen MT", Font.ITALIC, 11));
        phoneField.setBackground(new Color(254, 219, 209));

        // Agrega los componentes al panel
        add(emailLabel);
        add(emailField);
        add(phoneLabel);
        add(phoneField);

        // Configura el diseño del panel
        setBorder(BorderFactory.createTitledBorder("Contáctanos"));
        setPreferredSize(new Dimension(300, 100));
        setOpaque(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ejemplo de Contacto");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new InformacionEleccion());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

