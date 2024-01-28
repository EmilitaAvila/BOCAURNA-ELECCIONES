package ec.edu.pucem.elecciones.formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBienvenidaEleccion extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboBoxProvincia;
    private JButton btnSiguiente;
    private JDesktopPane desktopPane;

    public PanelBienvenidaEleccion(JDesktopPane desktopPane) {
        getContentPane().setBackground(new Color(254, 192, 253));
        this.desktopPane = desktopPane;  // Guarda la referencia al escritorio

        setTitle("BIENVENIDO A LAS ELECCIONES 2024");
        setBounds(100, 100, 383, 171);
        getContentPane().setLayout(null);

        JLabel lblProvincia = new JLabel("Ingresa su Provincia");
        lblProvincia.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\distrito (1).png"));
        lblProvincia.setFont(new Font("Tw Cen MT", Font.ITALIC, 14));
        lblProvincia.setBounds(10, 38, 143, 25);
        getContentPane().add(lblProvincia);

        comboBoxProvincia = new JComboBox<String>();
        comboBoxProvincia.setBackground(new Color(213, 255, 234));
        comboBoxProvincia.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Selecciona...", "Azuay", "Cañar", "Pichincha", "Manabí", "Guayas", "Esmeraldas"}));
        comboBoxProvincia.setBounds(174, 38, 189, 24);
        getContentPane().add(comboBoxProvincia);

        btnSiguiente = new JButton("Registrado");
        btnSiguiente.setBackground(new Color(0, 128, 64));
        btnSiguiente.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
        btnSiguiente.setBounds(126, 88, 117, 25);
        btnSiguiente.addActionListener(this);
        getContentPane().add(btnSiguiente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnSiguiente) {
                // Obtener la provincia ingresada
                String provinciaSeleccionada = (String) comboBoxProvincia.getSelectedItem();

                // Puedes realizar otras acciones si es necesario

                // Cerrar el formulario actual
                dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
