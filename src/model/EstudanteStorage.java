package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudanteStorage {

	public static void inserir(Estudante estudante) {
		final String query = "INSERT INTO estudante (nome, descricao) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, estudante.getNome());
//			prepStmt.setString(2, estudante.getDescricao());
			prepStmt.execute();

			rs = prepStmt.getGeneratedKeys();
			if (rs.next()) {
				estudante.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void atualizar(Estudante estudante) {
		final String query = "UPDATE estudante SET nome = ?, idade = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, estudante.getNome());
			prepStmt.setInt(2, estudante.getIdade());
			prepStmt.setInt(3, estudante.getId());
			prepStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void remover(Estudante estudante) {
		final String query = "DELETE FROM estudante WHERE id = ?";

		Connection conn = null;
		PreparedStatement prepStmt = null;

		try {
			conn = ConexaoFactory.getConexao();

			prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, estudante.getId());
			prepStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepStmt != null)
					prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Estudante> listar() {
		List<Estudante> tarefas = new ArrayList<>();

		final String query = "SELECT * FROM estudante ORDER BY Id";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Estudante tarefa = new Estudante();
				tarefa.setId(rs.getInt("id"));
				tarefa.setNome(rs.getString("nome"));
//				tarefa.setDescricao(rs.getString("descricao"));

				tarefas.add(tarefa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();

				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return tarefas;
	}
}
