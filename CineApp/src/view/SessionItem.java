package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import control.DataControl;
import control.MovieControl;
import control.RoomControl;
import model.Movie;
import model.MovieRoom;

/**
 * Menu/Janela com informações detalhadas sobre a sessão selecionada
 * @author Mauricio
 * @version 1.0 (Out 2021)
 *
 */
public class SessionItem implements ActionListener{
	private JFrame window;
	private JLabel labelMovieName= new JLabel("Selecione o filme: ");
	private JLabel movieName;
	private JLabel labelRoomNumber = new JLabel("Selecione a sala: ");
	private JLabel roomNumber;
	private JLabel labelSessionDate = new JLabel("Data da Sessão: ");
	private JLabel labelDateExemple = new JLabel("YYYY-MM-DD");
	private JTextField sessionDate;
	private JLabel labelSessionId = new JLabel("Número da Sessão: ");
	private JTextField sessionId;
	private JButton delete = new JButton("Excluir");
	private JButton save = new JButton("Salvar");
	private String[] editedSession= new String[5];
	private Movie editedMovie;
	private MovieRoom editedRoom;
	private String[] newSession = new String[4];
	private JList<String> listMovies;
	private JList<String> listRooms;
	private String[] moviesNames = new String[100];
	private String[] roomNumberList = new String[100];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	private SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Execução da operação selecionada no SessionSubMenu
	 * || (1) Cadastro de nova sessão
	 * || (2) edição/exclusão de sessão selecioanada
	 * @param op
	 * @param d Recebe todas as informações de dados já cadastrados no sistema.
	 * @param session
	 * @param p Posição do item selecionado
	 */
	public void addEdit(int op, DataControl d, 
			SessionSubMenu session, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Sessão";
		}
		if (op == 2) {
			windowLabel = "Sessão: Informações";
		}
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 1:
			
			roomNumberList = new RoomControl(data).getRoomsNumber();
			listRooms = new JList<String>(roomNumberList);
			listRooms.setLayoutOrientation(JList.VERTICAL);
			listRooms.setBounds(270, 30, 150, 160);
			listRooms.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listRooms.setVisibleRowCount(30);
			this.window.add(listRooms);
			
			moviesNames = new MovieControl(data).getMoviesName();
			listMovies = new JList<String>(moviesNames);
			listMovies.setLayoutOrientation(JList.VERTICAL);
			listMovies.setBounds(100, 30, 150, 160);
			listMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listMovies.setVisibleRowCount(30);
			this.window.add(listMovies);
			
			sessionDate = new JTextField(200);
			sessionId = new JTextField(String.valueOf((int)Math.floor(Math.random()*(100)+1)), 200);
			sessionDate = new JTextField("ANO-MES-DIA", 200);
			
			save.setBounds(180, 310, 115, 30);
			labelMovieName.setBounds(100, 10, 150, 25);
			labelRoomNumber.setBounds(270, 10, 150, 25);
			labelSessionDate.setBounds(30, 210, 150, 25);
			labelDateExemple.setBounds(30, 230, 150, 25);
			sessionDate.setBounds(180, 210, 180, 25);
			labelSessionId.setBounds(30, 260, 150, 25);
			sessionId.setBounds(180, 260, 180, 25);
			
			this.window.add(save);
			
			break;
			
		case 2:
			movieName = new JLabel(data.getSession().get(p).getMovie().getName());
			roomNumber = new JLabel(String.valueOf(data.getSession().get(p).getRoom().getRoomNumber()));
			sessionDate = new JTextField(dataFormat.format(data.getSession().get(p).getSchedule()), 200);
			sessionId = new JTextField(String.valueOf(data.getSession().get(p).getSessionId()), 200);
			
			movieName.setBounds(180, 20, 180, 25);
			labelMovieName.setBounds(30, 20, 150, 25);
			labelRoomNumber.setBounds(30, 50, 150, 25);
			roomNumber.setBounds(180, 50, 180, 25);
			labelSessionDate.setBounds(30, 80, 150, 25);
			labelDateExemple.setBounds(30, 100, 150, 25);
			sessionDate.setBounds(180, 80, 180, 25);
			labelSessionId.setBounds(30, 130, 150, 25);
			sessionId.setBounds(180, 130, 180, 25);
			save.setBounds(120, 175, 115, 30);
			delete.setBounds(245, 175, 115, 30);
			
			this.window.add(movieName);
			this.window.add(roomNumber);
			this.window.add(save);
			this.window.add(delete);
			
			break;
		
		default:
			break;
		
		}
		
		this.window.add(labelMovieName);
		this.window.add(labelRoomNumber);
		this.window.add(labelSessionDate);
		this.window.add(labelDateExemple);
		this.window.add(sessionDate);
		this.window.add(labelSessionId);
		this.window.add(sessionId);

		this.window.setLayout(null);

		window.setSize(500, 400);
		window.setLocationRelativeTo(null);
		this.window.setVisible(true);

		delete.addActionListener(this);
		save.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == save) {
			if(option==1) { //cadastro
				newSession[0] =  sessionDate.getText();
				newSession[1] =  Integer.toString(listRooms.getSelectedIndex());
				newSession[2] =  Integer.toString(listMovies.getSelectedIndex());
				newSession[3] =  sessionId.getText();
				
				try {
					data.addSession(newSession);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			} else { //edicao
				editedSession[0] = Integer.toString(position);
				
				editedSession[1] =  sessionDate.getText();
				editedSession[2] =  sessionId.getText();
				editedRoom = data.getSession().get(position).getRoom();
				editedMovie = data.getSession().get(position).getMovie();
				
				data.editSession(editedSession, editedRoom, editedMovie);
			}
		}
		if(source == delete) {
			data.deleteSession(position);
		}
	}
}
