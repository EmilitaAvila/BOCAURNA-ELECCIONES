package ec.edu.pucem.elecciones;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import ec.edu.puce.elecciones.dominio.Prefecto;
import ec.edu.pucem.elecciones.formulario.BocaUrnaEleccion;
import ec.edu.pucem.elecciones.formulario.CrearPrefectoEleccion;
import ec.edu.pucem.elecciones.formulario.InformacionEleccion;
import ec.edu.pucem.elecciones.formulario.PanelBienvenidaEleccion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;


public class MenuPrincipalEleccion extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contenedor;
    private JDesktopPane desktopPane;
    private JMenuItem mntmSalir;
    private JMenuItem mntmCrearPrefectos;
    private JMenuItem mntmBocaUrnaEleccion;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmIngresar;
    private JMenuItem mntmInformacion;
    private String ciudadSeleccionada ="";
    private String provinciaSeleccionada ="";
    

  
    public List<Prefecto> prefectos = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipalEleccion frame = new MenuPrincipalEleccion();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuPrincipalEleccion() {
        setTitle("SISTEMA CONTEO DE VOTOS BOCA DE URNA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(199, 152, 226));
        setJMenuBar(menuBar);

        JMenu mnSistema = new JMenu("Sistema");
        mnSistema.setBackground(new Color(187, 149, 210));
        mnSistema.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 16));
        menuBar.add(mnSistema);

        mntmSalir = new JMenuItem("Salir");
        mntmSalir.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\boton (1).png"));
        mntmSalir.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
        mnSistema.add(mntmSalir);

        JMenu mnAdministracin = new JMenu("Votar");
        mnAdministracin.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 16));
        menuBar.add(mnAdministracin);

        mntmIngresar = new JMenuItem("Ingresar");
        mntmIngresar.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\ingresar.png"));
        mntmIngresar.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
        mnAdministracin.add(mntmIngresar);

        mntmCrearPrefectos = new JMenuItem("CrearPrefectos");
        mntmCrearPrefectos.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\alcalde.png"));
        mntmCrearPrefectos.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
        mnAdministracin.add(mntmCrearPrefectos);

        JMenu mnProceso = new JMenu("Proceso");
        mnProceso.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 16));
        menuBar.add(mnProceso);

        mntmBocaUrnaEleccion = new JMenuItem("Boca de Urna");
        mntmBocaUrnaEleccion.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\urna-electoral (1).png"));
        mntmBocaUrnaEleccion.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
        mnProceso.add(mntmBocaUrnaEleccion);

        JMenu mnReportes = new JMenu("Reportes");
        mnReportes.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 16));
        menuBar.add(mnReportes);

        mntmNewMenuItem_1 = new JMenuItem("Resultado Barras");
        mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\diagrama.png"));
        mntmNewMenuItem_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
        mnReportes.add(mntmNewMenuItem_1);
   

        mntmNewMenuItem_2 = new JMenuItem("Resultados Pastel");
        mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\cuota-de-mercado.png"));
        mntmNewMenuItem_2.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
        mnReportes.add(mntmNewMenuItem_2);

        JMenu mnNewMenu = new JMenu("Contáctanos");
        mnNewMenu.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 16));
        menuBar.add(mnNewMenu);

        mntmInformacion = new JMenuItem("Información");
        mntmInformacion.setIcon(new ImageIcon("C:\\Users\\navar\\Downloads\\informacion.png"));
        mntmInformacion.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
        mnNewMenu.add(mntmInformacion);

        contenedor = new JPanel();
        contenedor.setBackground(new Color(255, 255, 255));
        contenedor.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        setContentPane(contenedor);
        contenedor.setLayout(new CardLayout(0, 0));

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(247, 250, 220));
        contenedor.add(desktopPane, "name_35522358088801");
        desktopPane.setLayout(null);

        // Agregamos los listeners para los eventos
        mntmSalir.addActionListener(this);
        mntmCrearPrefectos.addActionListener(this);
        mntmBocaUrnaEleccion.addActionListener(this);
        mntmInformacion.addActionListener(this);
        mntmIngresar.addActionListener(this);
        mntmNewMenuItem_1.addActionListener(this); // Agrega el listener para "Resultado Barras"
        mntmNewMenuItem_2.addActionListener(this);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == mntmSalir) {
                dispose();
            } else if (e.getSource() == mntmIngresar) {
                // Código para abrir el formulario PanelBienvenidaEleccion
                PanelBienvenidaEleccion panelBienvenida = new PanelBienvenidaEleccion(desktopPane);
                desktopPane.add(panelBienvenida);
                // Activar el formulario y llevarlo al frente
                try {
                    panelBienvenida.setSelected(true);
                    panelBienvenida.setVisible(true);
                } catch (java.beans.PropertyVetoException ex) {
                    ex.printStackTrace();
                }
            } else if (e.getSource() == mntmCrearPrefectos) {
                // Código para abrir el formulario CrearPrefectoEleccion
                String ciudad = "";  // Puedes obtener la ciudad de alguna manera, ya que no la tienes aquí
                String provincia = "";  // Puedes obtener la provincia de alguna manera, ya que no la tienes aquí

                CrearPrefectoEleccion crearPrefecto = new CrearPrefectoEleccion(prefectos);
                desktopPane.add(crearPrefecto);
                crearPrefecto.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
                crearPrefecto.setSize(443, 385);
                crearPrefecto.setVisible(true);
            } else if (e.getSource() == mntmBocaUrnaEleccion) {
                // Código para abrir el formulario de BocaDeUrna
                BocaUrnaEleccion bocaUrna = new BocaUrnaEleccion(prefectos, ciudadSeleccionada, provinciaSeleccionada); // Pasar la lista de prefectos
                desktopPane.add(bocaUrna);
                bocaUrna.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
                bocaUrna.setSize(800, 600);
                bocaUrna.setVisible(true);
            } else if (e.getSource() == mntmInformacion) {
                InformacionEleccion informacion = new InformacionEleccion();
                JOptionPane.showMessageDialog(this, informacion, "Información de Contacto", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == mntmNewMenuItem_1) {
                // Código para abrir el gráfico de barras
                crearResultadosEnBarras();
            } else if (e.getSource() == mntmNewMenuItem_2) {
                // Código para abrir el gráfico de pastel
                crearResultadosEnPastel();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

private void crearResultadosEnBarras() {
	final JInternalFrame frame = new JInternalFrame("Resultado en Barras", true);

	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	for (Prefecto prefecto : prefectos) {
		dataset.addValue(prefecto.getVotos(), "Prefecto", prefecto.getNombre());
	}
	final JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "Category", "Series", dataset,
			PlotOrientation.VERTICAL, true, true, false);
	final ChartPanel chartPanel = new ChartPanel(chart);
	chartPanel.setPreferredSize(new Dimension(600, 400));

	final JPanel panel = new JPanel();
	panel.setBounds(0, 0, 600, 400);
	panel.setLayout(new BorderLayout());
	panel.add(chartPanel);

	JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
		}
	});

	panel.add(btnCancelar, BorderLayout.SOUTH);
	frame.getContentPane().add(panel);
	desktopPane.add(frame);
	frame.pack();
	frame.setVisible(true);
}

private void crearResultadosEnPastel() {
	final JInternalFrame frame = new JInternalFrame("Resultado en Pastel", true);

	DefaultPieDataset datos = new DefaultPieDataset();
	for (Prefecto prefecto : prefectos) {
		datos.setValue(prefecto.getNombre(), prefecto.getVotos());
	}

	JFreeChart grafico = ChartFactory.createPieChart("Prefectos", datos);
	ChartPanel chartPanel = new ChartPanel(grafico);
	chartPanel.setBounds(10, 50, 450, 350);

	final JPanel panel = new JPanel();
	panel.setBounds(0, 0, 600, 400);
	panel.setLayout(new BorderLayout());
	panel.add(chartPanel);

	JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
		}
	});

	panel.add(btnCancelar, BorderLayout.SOUTH);
	frame.getContentPane().add(panel);
	desktopPane.add(frame);
	frame.pack();
	frame.setVisible(true);
}
}
