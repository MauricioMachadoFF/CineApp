package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.*;

public class MovieSubMenu implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton createMovie;
	private JButton refreshMovie;
	private JLabel labelSearchByName = new JLabel("Pesquisar por Nome:");
	private JTextField searchByName = new JTextField(200);
	private static DataControl data;
	private JList<String> listMovies;
	private String[] moviesNames = new String[100];
	
	public void showData(DataControl d){
		data = d;

			moviesNames = new MovieControl(data).getMoviesName();
			listMovies = new JList<String>(moviesNames);
			listMovies.setLayoutOrientation(JList.VERTICAL);
			
			
			window = new JFrame("Filmes");
			title = new JLabel("Filmes Cadastrados");
			createMovie = new JButton("Novo Filme");
			refreshMovie = new JButton("Atualizar");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setBounds(150, 10, 250, 30);
			listMovies.setBounds(100, 80, 150, 160);
			listMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listMovies.setVisibleRowCount(30);
			labelSearchByName.setBounds(100, 50, 250, 30);
			searchByName.setBounds(250, 50, 250, 30);

			createMovie.setBounds(10, 250, 150, 30);
			refreshMovie.setBounds(330, 250, 150, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listMovies);
			window.add(labelSearchByName);
			window.add(searchByName);
			window.add(createMovie);
			window.add(refreshMovie);

			window.setSize(500, 350);
			window.setLocationRelativeTo(null);
			window.setVisible(true);

			
			//Preciso de algum trigger pra chamar a função searchTxtKeyReleased
			searchByName.addKeyListener(listener);
			createMovie.addActionListener(this);
			refreshMovie.addActionListener(this);
			listMovies.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == createMovie) {
			new MovieItem().addEdit(1, data, this, 1);
		}
		//atualiza a lista de lanches
		if(src == refreshMovie) {
			listMovies.setListData(new MovieControl(data).getMoviesName());
			listMovies.updateUI();
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listMovies) {
			new MovieItem().addEdit(2, data, this, 
			listMovies.getSelectedIndex());
		}
		
	}
	
	private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {
		searchFilter(searchByName.getText());
	}
	
	//Erro na hora de filtrar está aqui em alguma parte da funçao searchFilter
	private void searchFilter(String searchTerm) {
		String[] filteredList = new String[100];
		int i = 0;
		int j = 0;
		
		while(i != -1) {
			if(this.moviesNames[i].toLowerCase().contains(searchTerm.toLowerCase())) {
				filteredList[j] = moviesNames[i];
				j++;
			}
			
			if(this.moviesNames[i] == null) {
				i = -1;
			} else {
				i++;
			}
		}
		this.listMovies = new JList<String>(filteredList);
	}
	
	KeyListener listener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			searchTxtKeyReleased(e);
		}
		
	};
}
