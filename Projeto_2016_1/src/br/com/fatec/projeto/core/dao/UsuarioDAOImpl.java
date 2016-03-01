package br.com.fatec.projeto.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.collect.Lists;

import br.com.fatec.projeto.api.entity.Usuario;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.query.GeradorIdService;

public class UsuarioDAOImpl {
	
	@Test
	public Usuario findById(Long id){
		
		Connection conn = null;
		PreparedStatement select = null;
		Usuario retorno = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Usuario.TABLE + " WHERE " + Usuario.COL_ID + 
					" = ?;";
			select = conn.prepareStatement(sql);
			select.setLong(1,  id);
			ResultSet resultado = select.getResultSet();
			
			while (resultado.next()){
				retorno = new Usuario(resultado.getLong(Usuario.COL_ID),
						resultado.getString(Usuario.COL_NOME),
						resultado.getString(Usuario.COL_LOGIN),
						resultado.getString(Usuario.COL_SENHA));
			}
			
			return retorno;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(select);
			DbUtils.closeQuietly(conn);
		}
		
	}

	@Test
	public void Update(Usuario usuario){
		
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			List<String> sets = Lists.newArrayList();
			sets.add(Usuario.COL_NOME + " = ?");
			sets.add(Usuario.COL_SENHA + " = ?");
			sets.add(Usuario.COL_LOGIN + " = ?");
			String setValores = StringUtils.join(sets, ", "); //pacote do google
			
			update = conn.prepareStatement("UPDATE " + Usuario.TABLE + "SET " + setValores + "WHERE" +
			 usuario.COL_ID + " = ? " +
			usuario.COL_ID + " = ?");			
			update.setString(2,  usuario.getNome());
			update.setString(3,  usuario.getLogin());
			update.setString(4,  usuario.getSenha());
			update.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(update);
			DbUtils.closeQuietly(conn);
		}
		
	}
	
	@Test
	public void delete(Long id) {
		
		Connection conn = null;
		PreparedStatement delete = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			delete = conn.prepareStatement("DELETE FROM" + Usuario.TABLE + "SET " + setValores + "WHERE" +
			 usuario.COL_ID + " = ? " +
			usuario.COL_ID + " = ?");			
			delete.setString(2,  usuario.getNome());
			delete.setString(3,  usuario.getLogin());
			delete.setString(4,  usuario.getSenha());
			delete.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(update);
			DbUtils.closeQuietly(conn);
		}
		
	}
	
	@Test
	public List<Usuario> findAll(){
		Connection conn = null;
		PreparedStatement select = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Usuario.TABLE + " ORDER BY " + Usuario.COL_ID + 
					" = ?;";
			select = conn.prepareStatement(sql);
			ResultSet resultado = select.executeQuery();
			return this.buildUsuarios(resultado);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(select);
			DbUtils.closeQuietly(conn);
		}
		
	}
	
	private Usuario buildUsuarios(ResultSet resultado) throws SQLException {
		return new Usuario(resultado.getLong(Usuario.COL_ID)),
				resultado.getString(Usuario.COL_NOME),
				resultado.getString(Usuario.COL_LOGIN),
				resultado.getString(Usuario.COL_SENHA));
	}
	
	private List<Usuario> buildUsuarios2(ResultSet resultado) throws SQLException {
		return new Usuario(resultado.getLong(Usuario.COL_ID)),
				resultado.getString(Usuario.COL_NOME),
				resultado.getString(Usuario.COL_LOGIN),
				resultado.getString(Usuario.COL_SENHA));
	}
	
}