package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudanteStorage {

    public static void inserir(Estudante estudante) {
        final String query = "INSERT INTO estudante (nome, idade, email, endereco, cep, telefone, usuario, senha, curso, textolivre, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;

        try {
            conn = ConexaoFactory.getConexao();

            prepStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, estudante.getNome());
            prepStmt.setInt(2, estudante.getIdade());
            prepStmt.setString(3, estudante.getEmail());
            prepStmt.setString(4, estudante.getEndereco());
            prepStmt.setString(5, estudante.getCep());
            prepStmt.setString(6, estudante.getTelefone());
            prepStmt.setString(7, estudante.getUsuario());
            prepStmt.setString(8, estudante.getSenha());
            prepStmt.setString(9, estudante.getCurso());
            prepStmt.setString(10, estudante.getTextolivre());
            prepStmt.setBoolean(11, estudante.getAtivo());
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
        final String query = "UPDATE estudante SET nome = ?, idade = ?, email = ?, endereco = ?, cep = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, textolivre = ?, ativo = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement prepStmt = null;

        try {
            conn = ConexaoFactory.getConexao();

            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, estudante.getNome());
            prepStmt.setInt(2, estudante.getIdade());
            prepStmt.setString(3, estudante.getEmail());
            prepStmt.setString(4, estudante.getEndereco());
            prepStmt.setString(5, estudante.getCep());
            prepStmt.setString(6, estudante.getTelefone());
            prepStmt.setString(7, estudante.getUsuario());
            prepStmt.setString(8, estudante.getSenha());
            prepStmt.setString(9, estudante.getCurso());
            prepStmt.setString(10, estudante.getTextolivre());
            prepStmt.setBoolean(11, estudante.getAtivo());
            prepStmt.setInt(12, estudante.getId());
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
                Estudante estudante = new Estudante();
                estudante.setId(rs.getInt("id"));
                estudante.setNome(rs.getString("nome"));
                estudante.setIdade(rs.getInt("idade"));
                estudante.setEmail(rs.getString("email"));
                estudante.setEndereco(rs.getString("endereco"));
                estudante.setCep(rs.getString("cep"));
                estudante.setTelefone(rs.getString("telefone"));
                estudante.setUsuario(rs.getString("usuario"));
                estudante.setSenha(rs.getString("senha"));
                estudante.setCurso(rs.getString("curso"));
                estudante.setTextolivre(rs.getString("textolivre"));
                estudante.setAtivo(rs.getBoolean("ativo"));

                tarefas.add(estudante);
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
