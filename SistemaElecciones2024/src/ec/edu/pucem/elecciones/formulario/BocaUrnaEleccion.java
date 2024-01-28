package ec.edu.pucem.elecciones.formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import ec.edu.puce.elecciones.dominio.Prefecto;
import java.util.List;

public class BocaUrnaEleccion extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel model;
    private List<Prefecto> prefectos;
    private JButton btnCancelar;
    private JButton btnNewButton;
    private JPanel panel;
    private String ciudadSeleccionada;
    private String provinciaSeleccionada;
    private boolean votosMostrados = false;

    public BocaUrnaEleccion(List<Prefecto> prefectos, String ciudadSeleccionada, String provinciaSeleccionada) {
        getContentPane().setBackground(new Color(171, 231, 217));
        this.prefectos = prefectos;
        this.ciudadSeleccionada = ciudadSeleccionada;
        this.provinciaSeleccionada = provinciaSeleccionada;

        setTitle("BOCA DE URNA - REGISTRO");
        setBounds(100, 100, 779, 550);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(129, 233, 566, 167);
        getContentPane().add(scrollPane);

        // Tabla para mostrar votos de candidatos
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(model.getValueAt(0, 0));
            }
        });

        // Modifica el modelo de la tabla para agregar la columna "Provincia"
        model = new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Provincia", "Votos" });
        table.setModel(model);

        scrollPane.setViewportView(table);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(128, 0, 255));
        btnCancelar.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
        btnCancelar.addActionListener(this);
        btnCancelar.setBounds(364, 427, 117, 25);
        getContentPane().add(btnCancelar);

        btnNewButton = new JButton("Registrar mi voto");
        btnNewButton.setBackground(new Color(128, 0, 255));
        btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
        btnNewButton.setBounds(349, 202, 147, 23);
        btnNewButton.addActionListener(this);
        getContentPane().add(btnNewButton);

        panel = new JPanel();
        panel.setBackground(new Color(222, 243, 171));
        panel.setBounds(23, 13, 727, 167);
        getContentPane().add(panel);

        cargarCandidatos();
        llenarTabla();
    }

    private void cargarCandidatos() {
        int x = 0;
        for (Prefecto prefecto : prefectos) {
            JButton btnPrefecto = new JButton(prefecto.getNombre());
            btnPrefecto.setBounds(x * 155, 0, 150, 80);
            btnPrefecto.addActionListener(this);
            panel.setLayout(null);
            panel.add(btnPrefecto);
            x++;
        }
    }

    private void llenarTabla() {
        if (votosMostrados) {
            model.setRowCount(0);
            for (Prefecto prefecto : prefectos) {
                Object[] fila = new Object[3];
                fila[0] = prefecto.getNombre();
                fila[1] = prefecto.getProvincia(); // Cambiado a obtener provincia
                fila[2] = prefecto.getVotos();
                model.addRow(fila);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            dispose();
        } else if (e.getSource() == btnNewButton) {
            votosMostrados = true;
            llenarTabla();
        } else {
            for (Prefecto prefecto : prefectos) {
                if (prefecto.getNombre().equals(e.getActionCommand())) {
                    prefecto.setVotos(prefecto.getVotos() + 1);
                    llenarTabla();
                }
            }
        }
    }

    public List<Prefecto> getPrefectos() {
        return prefectos;
    }

    public void setPrefectos(List<Prefecto> prefectos) {
        this.prefectos = prefectos;
    }
}
