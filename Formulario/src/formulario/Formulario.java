
package formulario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import static java.awt.Font.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
public class Formulario {

    public static void main(String[] args) {
        // TODO code application logic here
    MarcoTexto miMarco= new MarcoTexto();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
class MarcoTexto extends JFrame{
    public MarcoTexto(){
        setTitle("Formulario para participar en el desafio de los gimnasios");
        setBounds(600, 300, 600, 500);
        LaminaTexto miLamina = new LaminaTexto();
        miLamina.setLayout(new GridLayout(50,2));
        miLamina.setPreferredSize(new Dimension(500-42, getHeight()+700));
        JScrollPane scroll= new JScrollPane(miLamina);
        scroll.setPreferredSize(new Dimension(500, getHeight()-65));
        add(scroll);
        
    }
}

class LaminaTexto extends JPanel{
	
	private URL url = getClass().getResource("/img/logo.png");
    Image image = new ImageIcon(url).getImage();

    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
	JTextField nom;
	JTextField apell;
	JTextField dor;
	JTextField patro;
	JTextArea datos;
	
    public LaminaTexto(){
     JLabel titulo= new JLabel("INSCRIPCION");
     JLabel datosuno= new JLabel("Formulario");
     //Primera parte del formulario
     //Nombre
     JLabel nombre= new JLabel("Nombre*:  ");
     nom= new JTextField();
     JLabel apellidos= new JLabel("Apellidos*:  ");
     apell= new JTextField();
     //Dorsal
     JLabel dorsal= new JLabel("Numero de dorsal*:  ");
     dor = new JTextField(3);
     dor.addKeyListener(new KeyAdapter()
     {
      public void keyTyped(KeyEvent e)
     {
      char caracter = e.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         e.consume();  // ignorar el evento de teclado
      }
   }
});
     //Origen
     JLabel region= new JLabel("Region de procedencia:  ");
     JTextField reg= new JTextField();
     JLabel ciudad= new JLabel("Ciudad o pueblo de origen:  ");
     JTextField ciud= new JTextField();
     //Patrocinador
     JLabel patrocinador= new JLabel("Patrocinador*:  ");
     patro= new JTextField();
     //Edad
     JLabel edad= new JLabel("Edad*:  ");
     JSpinner eda;
     JTextField ed = new JTextField(10);
  // Creacion del JSpinner y valor incial.
  		eda = new JSpinner();
  		eda.setValue(10);
  		
  		// Nos suscribimos a cambios en el JSpinner
  		eda.addChangeListener(new ChangeListener() {
  			@Override
  			public void stateChanged(ChangeEvent e) {
  				// Ponemos el valor del JSpinner en el JTextField
  				ed.setText(eda.getValue().toString());
  			}
  		
  		});
  	//Pokemon inicial
     JLabel pokemoninicial= new JLabel("Pokemon inicial:  ");
     JTextField pokeini= new JTextField();
     
 //Segunda parte del formulario
     
     //Genero
     JLabel genero= new JLabel("Genero:");
     JComboBox<String>gen;
     String [] gener;
     gener= new String[] {"","Hombre","Mujer","NB","Otro"};
     gen=new JComboBox<>(gener);
     
    //Participaciones en el desafio
    JLabel participacion= new JLabel("¿Ha participado alguna vez?");
    JRadioButton si=new JRadioButton("Si, indique cuantas: ", false);
    JTextField s = new JTextField(10);
     s.addKeyListener(new KeyAdapter()
    {
    public void keyTyped(KeyEvent e)
    {
      char caracter = e.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         e.consume();  // ignorar el evento de teclado
      }
   }
});
    JRadioButton no=new JRadioButton("No", false);
    ButtonGroup migrupoparticipacion= new ButtonGroup();
        migrupoparticipacion.add(si);
        migrupoparticipacion.add(no);
    
    //Modalidad de combate
    JLabel modalidad= new JLabel("Indique sus modalidades de combate");
    JCheckBox individual=new JCheckBox("Individual");
    JCheckBox dobles=new JCheckBox("Dobles");
    JCheckBox multiples=new JCheckBox("Multiples");
    JCheckBox otra=new JCheckBox("Otra");
    //Modalidad preferida
    JLabel modalidad2= new JLabel("Indique su preferida de estas:");
    JComboBox<String>combate;
    String [] combatmod;
    combatmod= new String[] {"","Individual","Dobles"};
    combate=new JComboBox<>(combatmod);
    
    //Tipos de pokemon preferentes
    JLabel tipos= new JLabel("Indique sus tipos de Pokemon preferentes");
    JCheckBox Normal=new JCheckBox("Normal");
    JCheckBox Lucha=new JCheckBox("Lucha");
    JCheckBox Volador=new JCheckBox("Volador");
    JCheckBox Veneno=new JCheckBox("Veneno");
    JCheckBox Tierra=new JCheckBox("Tierra");
    JCheckBox Roca=new JCheckBox("Roca");
    JCheckBox Bicho=new JCheckBox("Bicho");
    JCheckBox Fantasma=new JCheckBox("Fantasma");
    JCheckBox Acero=new JCheckBox("Acero");
    JCheckBox Fuego=new JCheckBox("Fuego");
    JCheckBox Agua=new JCheckBox("Agua");
    JCheckBox Planta=new JCheckBox("Planta");
    JCheckBox Electrico=new JCheckBox("Electrico");
    JCheckBox Psiquico=new JCheckBox("Psiquico");
    JCheckBox Hielo=new JCheckBox("Hielo");
    JCheckBox Dragon=new JCheckBox("Dragon");
    JCheckBox Siniestro=new JCheckBox("Siniestro");
    JCheckBox Hada=new JCheckBox("Hada");
    //Tipo favorito
    JLabel tipos2= new JLabel("Indique su tipo de Pokemon favorito");
    JComboBox<String>tip;
    String [] tipfav;
    tipfav= new String[] {"","Normal","Lucha","Volador","Veneno","Tierra","Roca","Bicho","Fantasma","Acero",
    		"Fuego","Agua","Planta","Electrico","Psiquico","Hielo","Dragon","Siniestro","Hada"};
    tip=new JComboBox<>(tipfav);
    
 //Tercera parte del formulario
    //Sobre ti
    JLabel sobre= new JLabel("Sobre ti: ");
    JTextArea tu= new JTextArea(15, 20);
    tu.setLineWrap(true);
    JScrollPane uno= new JScrollPane(tu);
        uno.setPreferredSize(new Dimension(500, getHeight()-65));
    //Nivel de entrenador    
    JLabel nivel= new JLabel("Indique su nivel como entrenador: ");
    JSlider niv;
    niv = new JSlider(0, 100, 50);
    niv.setMinorTickSpacing(5);
    niv.setMajorTickSpacing(25);
    niv.setPaintLabels(true);
    niv.setOrientation(SwingConstants.HORIZONTAL);
    niv.setPaintTicks(true);
    //Pokemon en el equipo
    JLabel pokemon= new JLabel("Numero de Pokemon en su equipo: ");
    JSlider poke;
    poke = new JSlider(1, 6, 3);
    poke.setMinorTickSpacing(1);
    poke.setMajorTickSpacing(2);
    poke.setPaintLabels(true);
    poke.setOrientation(SwingConstants.HORIZONTAL);
    poke.setPaintTicks(true);
    //Regiones visitadas
    JLabel visitas= new JLabel("Numero de regiones visitadas: ");
    JSlider visit;
    visit = new JSlider(1, 8, 4);
    visit.setMinorTickSpacing(1);
    visit.setMajorTickSpacing(2);
    visit.setPaintLabels(true);
    visit.setOrientation(SwingConstants.HORIZONTAL);
    visit.setPaintTicks(true);
    //Carta de recomendacion
    JLabel carta= new JLabel("Carta de recomendacion: ");
    JTextArea recom= new JTextArea(15, 20);
    recom.setLineWrap(true);
    JScrollPane dos= new JScrollPane(recom);
        dos.setPreferredSize(new Dimension(500, getHeight()-65));
    //Mas comentarios
    JLabel mas= new JLabel("Algun comentario mas:  ");
    JTextField comen= new JTextField();
    
 //Recopilacion de datos
    JLabel recop= new JLabel("Datos mas importantes recopilados: ");
    datos= new JTextArea(15, 20);
    datos.setLineWrap(true);
    JScrollPane tres= new JScrollPane(datos);
        tres.setPreferredSize(new Dimension(500, getHeight()-65));
   
 //Boton enviar
    JButton botonEnviar= new JButton("Enviar");
    botonEnviar.setPreferredSize(new Dimension(getWidth(),40));
    ObtenerTexto miEvento= new ObtenerTexto();
    botonEnviar.addActionListener(miEvento);
        
 //Titulos letras
     titulo.setFont(new Font("Lato", BOLD,30));
     datosuno.setFont(new Font("Lato", BOLD,25));
     genero.setFont(new Font("Serif", BOLD,15));
     sobre.setFont(new Font("Serif", BOLD,15));
     carta.setFont(new Font("Serif", BOLD,15));
     
 //vacios
     JLabel vacio=new JLabel(" ");
     JLabel vacio2=new JLabel(" ");
     JLabel vacio3=new JLabel(" ");
     JLabel vacio4=new JLabel(" ");
     JLabel vacio5=new JLabel(" ");
     JLabel vacio6=new JLabel(" ");
     JLabel vacio7=new JLabel(" ");
     JLabel vacio8=new JLabel(" ");
     JLabel vacio9=new JLabel(" ");
     JLabel vacio10=new JLabel(" ");
     JLabel vacio11=new JLabel(" ");
     
     
 //adds
     add(titulo);
     add(vacio);
     add(datosuno);
     add(vacio2);
     add(nombre);
     add(nom);
     add(apellidos);
     add(apell);
     add(dorsal);
     add(dor);
     add(region);
     add(reg);
     add(ciudad);
     add(ciud);
     add(patrocinador);
     add(patro);
     add(edad);
     add(eda);
     
     add(pokemoninicial);
     add(pokeini);
     add(genero);
     add(vacio3);
     add(gen);
     add(vacio11);
     add(participacion);
     add(vacio4);
     add(si);
     add(s);
     add(no);
     add(vacio5);
     add(modalidad);
     add(vacio6);
     add(individual);
     add(dobles);
     add(multiples);
     add(otra);
     add(modalidad2);
     add(combate);
     add(tipos);
     add(vacio7);
     add(Normal);
     add(Lucha);
     add(Volador);
     add(Veneno);
     add(Tierra);
     add(Roca);
     add(Bicho);
     add(Fantasma);
     add(Acero);
     add(Fuego);
     add(Agua);
     add(Planta);
     add(Electrico);
     add(Psiquico);
     add(Hielo);
     add(Dragon);
     add(Siniestro);
     add(Hada);
     add(tipos2);
     add(tip);
     add(sobre);
     add(uno);
     add(nivel);
     add(niv);
     add(pokemon);
     add(poke);
     add(visitas);
     add(visit);
     add(carta);
     add(dos);
     add(mas);
     add(comen);
     add(vacio8);
     add(vacio9);
     add(recop);
     add(tres);
     add(vacio10);
     add(botonEnviar, BorderLayout.SOUTH);
     
}
    private class ObtenerTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			datos.setText("");
			
			if(nom.getText().isEmpty()) {
				nom.setBackground(Color.red);
				
			}else {
				nom.setBackground(Color.white);
				datos.append("Nombre: "+nom.getText());
			}
			if(apell.getText().isEmpty()) {
				apell.setBackground(Color.red);
				
			}else {
				apell.setBackground(Color.white);
				datos.append("Apellidos: "+apell.getText());
			}
			if(dor.getText().isEmpty()) {
				dor.setBackground(Color.red);
				
			}else {
				dor.setBackground(Color.white);
				datos.append("Dorsal: "+dor.getText());
			}
			if(patro.getText().isEmpty()) {
				patro.setBackground(Color.red);
				
			}else {
				patro.setBackground(Color.white);
				datos.append("Patrocinador: "+patro.getText());
			}
		}
    	
    }
   
}
