package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Position;

import control.*;

/**
 * SubMenu para operações relacionadas com filmes.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class MovieSubMenu implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton createMovie;
	private JButton refreshMovie;
	private JButton searchMovie;
	private JLabel labelSearchByName = new JLabel("Pesquisar por Nome:");
	private JTextField searchByName = new JTextField(200);
	private JLabel labelSearchByGenre = new JLabel("Pesquisar por Genero:");
	private JTextField searchByGenre = new JTextField(200);
	private static DataControl data;
	private JList<String> listMovies;
	private String[] moviesNames = new String[100];
	/**
	 * Geração do SubMenu de filmes.
	 * @param d Passagem dos dados já cadastrados no início da aplicação. 
	 */
	public void showData(DataControl d){
		data = d;

			moviesNames = new MovieControl(data).getMoviesName();
			listMovies = new JList<String>(moviesNames);
			listMovies.setLayoutOrientation(JList.VERTICAL);
			
			
			window = new JFrame("Filmes");
			title = new JLabel("Filmes Cadastrados");
			createMovie = new JButton("Novo Filme");
			refreshMovie = new JButton("Atualizar");
			searchMovie = new JButton("Buscar Filme");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			listMovies.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			
			title.setBounds(150, 10, 250, 30);
			listMovies.setVisibleRowCount(30);
			labelSearchByName.setBounds(50, 50, 250, 30);
			searchByName.setBounds(210, 50, 250, 30);
			labelSearchByGenre.setBounds(50, 85, 250, 30);
			searchByGenre.setBounds(210, 90, 250, 30);
			searchMovie.setBounds(250, 125, 150, 30);
			listMovies.setBounds(50, 190, 410, 150);
			
			createMovie.setBounds(50, 350, 150, 30);
			refreshMovie.setBounds(310, 350, 150, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listMovies);
			window.add(labelSearchByName);
			window.add(searchByName);
			window.add(labelSearchByGenre);
			window.add(searchByGenre);
			window.add(searchMovie);
			window.add(createMovie);
			window.add(refreshMovie);

			window.setSize(500, 450);
			window.setLocationRelativeTo(null);
			window.setVisible(true);

			
			
			createMovie.addActionListener(this);
			refreshMovie.addActionListener(this);
			searchMovie.addActionListener(this);
			listMovies.addListSelectionListener(this);
	}
	
	/**
	 * Filtro de filmes disponíveis pelo nome.
	 * @param text Termo de busca, o filme procurado deverá conter o termo de busca em sua String
	 */
	private void searchTxt(String text) {
		int index=0;
		index = listMovies.getNextMatch(text, 0, Position.Bias.Forward);
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "Nenhuma correspondência encontrada!", "Erro", 0);
		} else {
			listMovies.setSelectedIndex(index);
			new MovieItem().addEdit(2, data, this, 
				listMovies.getSelectedIndex());
		}
	}
	
	/**
	 * Filtro de filmes disponíveis por gênero.
	 * @param text Termo de busca, o gênero do filme procurado deverá conter o termo de busca em sua String.
	 */
	private void searchGenre(String text) {
			int[] positions = new int[data.getMovies().size()];
	    	int j = 0;
			
			for(int i = 0; i < data.getMovies().size(); i++) {
				positions[i] = -1;
				if(data.getMovies().get(i).getGenre().toLowerCase().contains(text.toLowerCase())) {
					positions[j] = i;
					j++;
					moviesNames[i] = data.getMovies().get(i).getName() + " - "+ data.getMovies().get(i).getGenre();
				} else {
					moviesNames[i] = data.getMovies().get(i).getName();
				}
			}
			
			if (j==0) {
				JOptionPane.showMessageDialog(null, "Nenhuma correspondência encontrada!", "Erro", 0);
			} else {
				JOptionPane.showMessageDialog(null, "Foram encontrados "+j+" filmes do gênero '"+text+"'", "Informação", 1);
				listMovies.setListData(moviesNames);
				listMovies.updateUI();
				listMovies.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				listMovies.setSelectedIndices(positions);
			}
	}
	
	/**
	 * Escuta os eventos de clique.
	 * (1) Cadastrar novo filme
	 * (2) Atualizar lista de filmes
	 * (3) Filtrar lista de filmes
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == createMovie) {
			new MovieItem().addEdit(1, data, this, 1);
		}
		
		if(src == refreshMovie) {
			listMovies.setListData(new MovieControl(data).getMoviesName());
			listMovies.updateUI();
			searchByName.setText(null);
			searchByGenre.setText(null);
			
		}
		if(src == searchMovie) {
			if (searchByName.getText().length() > 0) {
				searchTxt(searchByName.getText());
			} else if (searchByGenre.getText().length() > 0) {
				searchGenre(searchByGenre.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Campo de busca vazio!", "Erro", 0);
			}
		}
	}

	/**
	 * Escuta por eventos de seleção na JList de filmes. Cria uma nova janela, com os dados do filme selecionado.
	 * (1) Permite a edição/exclusão do filme selecionado
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listMovies) {
			new MovieItem().addEdit(2, data, this, 
			listMovies.getSelectedIndex());
		}
		
	}

}

