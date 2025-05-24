package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
        // Crea el campo para el nombre con una etiqueta al frente
    	JLabel lNombre = new JLabel("Nombre:");
    	add(lNombre);
        txtNombre = new JTextField();
        add(txtNombre);

        // Crea el selector para la calificación con una etiqueta al frente
        JLabel lcalificacion = new JLabel("calificacion:");
        add(lcalificacion);
        cbbCalificacion = new JComboBox<>();
        for (int i = 1; i <= 5; i++) {
            cbbCalificacion.addItem(String.valueOf(i));
        }
        add(cbbCalificacion);
        
        

        // Crea el selector para indicar si ya ha sido visitado, con una etiqueta al frente
        JLabel lVisitado = new JLabel("¿esta visitado?: ");
        add(lVisitado);
        cbbVisitado = new JComboBox<>(new String[] { "Sí", "No" });
        add(cbbVisitado);
        //no me salen las labels no se porque
        // Agregar todos los elementos al panel
        //consulte y era mejor gridLayout porque lo hace de forma de filas y columnas en ves de todo lineal
        setVisible(true);
        setLayout(new GridLayout(3, 3, 20, 20));
        
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
    	String visit=(String) cbbVisitado.getSelectedItem();
    	if ( visit.equalsIgnoreCase("si")) {
    		return true;
    	}else {
    		return false;
    	}
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
        return txtNombre.getText();
    }
}
