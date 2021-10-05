package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.DataControl;

/**
 * Menu para acesso detalhado da informação de um filme
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class MovieItem implements ActionListener {
	private JFrame window;
	private JLabel labelMvName= new JLabel("Nome do Filme: ");
	private JTextField MvName;
	private JLabel labelMvYear = new JLabel("Ano de Lançamento: ");
	private JTextField MvYear;
	private JLabel labelMvGenre = new JLabel("Gênero: ");
	private JTextField MvGenre;
	private JLabel labelMvSynopsis = new JLabel("Sinopse do filme: ");
	private JTextField MvSynopsis;
	private JButton deleteMovie = new JButton("Excluir");
	private JButton saveMovie = new JButton("Salvar");
	private String[] editedMovie= new String[5];
	private String[] newMovie = new String[4];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	
	/**
	 * Execução da operação selecionada no MovieSubMenu
	 * (1) Cadastrar novo filme
	 * (2) Editar filme selecionado
	 * (3) Excluir filme selecionado
	 * @param op
	 * @param d Dados cadastrados em toda aplicação até o momento.
	 * @param movie
	 * @param p Posição do filme selecionado
	 */
	public void addEdit(int op, DataControl d, 
			MovieSubMenu movie, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Filme";
			labelMvName = new JLabel("Filme: ");
		}
		if (op == 2) {
			windowLabel = "Filme: Informações";
			labelMvName = new JLabel("Filme: ");
		}
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 1:
			MvName = new JTextField(200);
			MvYear = new JTextField(200);
			MvGenre = new JTextField(200);
			MvSynopsis = new JTextField(200);
			saveMovie.setBounds(245, 175, 115, 30);
			this.window.add(saveMovie);
			
			break;
			
		case 2:
			MvName = new JTextField(data.getMovies().get(p).getName(), 200);
			MvYear = new JTextField(String.valueOf(data.getMovies().get(p).getYear()), 200);
			MvGenre = new JTextField(String.valueOf(data.getMovies().get(p).getGenre()), 200);
			MvSynopsis = new JTextField(String.valueOf(data.getMovies().get(p).getSynopsis()), 200);
			
			saveMovie.setBounds(120, 175, 115, 30);
			deleteMovie.setBounds(245, 175, 115, 30);
			
			this.window.add(saveMovie);
			this.window.add(deleteMovie);
			
			break;
		
		default:
			break;
		
		}
		
		labelMvName.setBounds(30, 20, 150, 25);
		MvName.setBounds(180, 20, 180, 25);
		labelMvYear.setBounds(30, 50, 150, 25);
		MvYear.setBounds(180, 50, 180, 25);
		labelMvGenre.setBounds(30, 80, 150, 25);
		MvGenre.setBounds(180, 80, 180, 25);
		labelMvSynopsis.setBounds(30, 110, 150, 25);
		MvSynopsis.setBounds(180, 110, 180, 25);
		
		this.window.add(labelMvName);
		this.window.add(MvName);
		this.window.add(labelMvYear);
		this.window.add(MvYear);
		this.window.add(labelMvGenre);
		this.window.add(MvGenre);
		this.window.add(labelMvSynopsis);
		this.window.add(MvSynopsis);

		this.window.setLayout(null);

		window.setSize(500, 450);
		window.setLocationRelativeTo(null);
		this.window.setVisible(true);

		deleteMovie.addActionListener(this);
		saveMovie.addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveMovie) {
			if(option==1) { //cadastro
				newMovie[0] =  MvName.getText();
				newMovie[1] =  MvYear.getText();
				newMovie[2] =  MvGenre.getText();
				newMovie[3] =  MvSynopsis.getText();
				data.addMovie(newMovie);
				
			} else {
				// edição
				editedMovie[0] = Integer.toString(position);
				
				editedMovie[1] =  MvName.getText();
				editedMovie[2] =  MvYear.getText();
				editedMovie[3] =  MvGenre.getText();
				editedMovie[4] =  MvSynopsis.getText();
				data.editMovie(editedMovie);
			}
		}
		if(source == deleteMovie) {
			data.deleteMovie(position);
		}
	}
}
