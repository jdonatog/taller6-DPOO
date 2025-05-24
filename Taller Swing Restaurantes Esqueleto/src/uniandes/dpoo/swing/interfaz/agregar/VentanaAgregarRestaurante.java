package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        // Agrega el panel donde va a estar el mapa
        panelMapa=new PanelMapaAgregar();
        add(panelMapa,BorderLayout.CENTER);
        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        JPanel panelSur = new JPanel(new BorderLayout());
        panelBotones = new PanelBotonesAgregar(this);
        panelDetalles = new PanelEditarRestaurante();
        panelSur.add(panelBotones,BorderLayout.SOUTH);
        panelSur.add(panelDetalles,BorderLayout.CENTER);
        add(panelSur,BorderLayout.SOUTH);

        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
    	String nombre = panelDetalles.getNombre();
    	int calificacion = panelDetalles.getCalificacion();
    	int[] coordendas=panelMapa.getCoordenadas();
		int x=coordendas[0];
		int y=coordendas[1];
		boolean visitado = panelDetalles.getVisitado();
        ventanaPrincipal.agregarRestaurante(nombre, calificacion, x, y, visitado);
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
