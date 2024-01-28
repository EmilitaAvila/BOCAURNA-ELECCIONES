package ec.edu.pucem.elecciones.formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import ec.edu.puce.elecciones.dominio.Prefecto;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CrearPrefectoEleccion extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;

    private Prefecto prefecto;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnGuardar;
    private JButton btnNuevo;
    private JButton btnCancelar;
    private JComboBox comboBox;

    private List<Prefecto> prefectos;
    private int idPrefecto;

    public CrearPrefectoEleccion(List<Prefecto> prefectosEleccion) {
        getContentPane().setBackground(new Color(245, 243, 148));
        idPrefecto = 1;
        this.prefectos = prefectosEleccion;
        setTitle("CANDIDATOS A PREFECTO");
        setBounds(100, 100, 443, 385);
        getContentPane().setLayout(null);

        JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tw Cen MT", Font.ITALIC, 11));
		lblNombres.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\usuario (2).png"));
		lblNombres.setBounds(12, 52, 89, 29);
		getContentPane().add(lblNombres);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarPrefecto();
			}
		});
		txtNombre.setBounds(100, 56, 231, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnNuevo.setBackground(new Color(85, 219, 95));
		btnNuevo.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\nuevo-documento.png"));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(31, 99, 117, 25);
		getContentPane().add(btnNuevo);

		btnGuardar = new JButton("Agregar");
		btnGuardar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnGuardar.setBackground(new Color(85, 219, 95));
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\agregar-usuario.png"));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(157, 99, 117, 25);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 11));
		btnCancelar.setBackground(new Color(85, 219, 95));
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cancelar.png"));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(291, 99, 117, 25);
		getContentPane().add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 148, 416, 163);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(model.getValueAt(0, 0));
            }
        });
        
        // Aquí se establecen los encabezados de las columnas
        model = new DefaultTableModel(new Object[][]{}, new String[]{"Nombre", "Provincia"});
        table.setModel(model);
        
        scrollPane.setViewportView(table);
		
	
		
		JLabel lblNombres_1 = new JLabel("Provincia");
		lblNombres_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 11));
		lblNombres_1.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\distrito.png"));
		lblNombres_1.setBounds(12, 14, 91, 25);
		getContentPane().add(lblNombres_1);
		
		comboBox = new JComboBox();
        comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Azuay", "Cañar", "Pichincha", "Manabí", "Guayas", "Esmeraldas", "Imbabura", "Chimborazo", "Carchi", "Tungurahua", "Santa Elena"}));
        comboBox.setBounds(100, 14, 231, 24);
        getContentPane().add(comboBox);

        model = (DefaultTableModel) table.getModel();
        agregarFila();
    }

    private void nuevo() {
        prefecto = new Prefecto();
        txtNombre.setText(prefecto.getNombre());
    }

    private void agregarPrefecto() {
        prefecto = new Prefecto();
        prefecto.setId(idPrefecto);
        prefecto.setNombre(txtNombre.getText());
        // Obtener la provincia seleccionada del JComboBox
        String provinciaSeleccionada = comboBox.getSelectedItem().toString();
        prefecto.setProvincia(provinciaSeleccionada);
        prefecto.setVotos(0);
        prefectos.add(prefecto);
        agregarFila();
        txtNombre.setText("");
        idPrefecto++;
    }

    private void agregarFila() {
        model.setRowCount(0);
        for (Prefecto prefecto : prefectos) {
            Object[] fila = new Object[] { prefecto.getNombre(), prefecto.getProvincia() };
            model.addRow(fila);
        }
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			nuevo();
		} else if (e.getSource() == btnGuardar) {
			agregarPrefecto();
		} else if (e.getSource() == btnCancelar) {
			dispose();
		}
		else if (e.getSource() == txtNombre) {
			agregarPrefecto();
		}
	}

	public List<Prefecto> getPrefectos() {
		return prefectos;
	}

	public void setPrefectos(List<Prefecto> prefectos) {
	    this.prefectos = prefectos; // Corregir aquí
	}
}

