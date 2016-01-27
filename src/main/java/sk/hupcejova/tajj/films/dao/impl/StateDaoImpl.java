package sk.hupcejova.tajj.films.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sk.hupcejova.tajj.films.dao.StateDao;
import sk.hupcejova.tajj.films.database.Database;
import sk.hupcejova.tajj.films.dto.State;
import sk.hupcejova.tajj.films.factory.Factory;

/**
 * 
 * Implementacia Interface StateDao
 *
 */

public class StateDaoImpl implements StateDao{
	
	private Database db = Factory.getInstance();

	/**
	 * konkretna imlementacia metody pre vypis vsetkych hodnot
	 */
	@Override
	public List<State> findAll(){
		ArrayList<State> states = new ArrayList<State>();
		
		Connection conn = this.db.getConnection();
		PreparedStatement statement;
		ResultSet result;
		try{
			statement = conn.prepareStatement("SELECT * FROM Stav");
			result = statement.executeQuery();
			
			while(result.next()){
				State s = Factory.getStateInstance();				
				s.setId(result.getLong("ID"));
				s.setName(result.getString("Nazov"));
				
				states.add(s);
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return states;
	}
	
	/**
	 * implementacia metody pre najdenie nazvu stavu podla id
	 */
	@Override
	public State findStateById(Long id){
		State state = Factory.getStateInstance();
		Connection conn = this.db.getConnection();
		try {
			PreparedStatement stateStatement = conn.prepareStatement("SELECT * FROM Stav WHERE ID = ?");
			stateStatement.setLong(1, id);
			ResultSet stateResult = stateStatement.executeQuery();
			
			while(stateResult.next()){
			state.setId(stateResult.getLong("ID"));
			state.setName(stateResult.getString("Nazov"));
			}
			return state;
		}
		catch(SQLException e){
			return null;
		}
	}
}
