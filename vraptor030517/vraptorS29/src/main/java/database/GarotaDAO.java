/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Garota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author iapereira
 */
@RequestScoped
public class GarotaDAO {

    public ArrayList<Garota> listar() throws ClassNotFoundException, SQLException, SQLException {
        ArrayList<Garota> vetGarota = new ArrayList();
        Connection connection = new Conexao().getConnection();
        String sql = "SELECT * FROM garota";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Garota g = new Garota();
            g.setAltura(rs.getDouble("altura"));
            g.setApelido(rs.getString("apelido"));
            g.setBumbum(rs.getDouble("bumbum"));
            g.setId(rs.getInt("id"));
            g.setValor(rs.getDouble("valor"));
            vetGarota.add(g);
        }
        preparedStatement.close();
        connection.close();
        return vetGarota;

    }

    public void excluir(int id) throws ClassNotFoundException, SQLException {
        Connection connection = new Conexao().getConnection();
        String sql = "DELETE FROM garota WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        //return resultado == 1;
    }

    public void inserir(Garota garota) throws ClassNotFoundException, SQLException {
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "INSERT INTO garota (apelido, altura, valor, bumbum) values (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, garota.getApelido());
            preparedStatement.setDouble(2, garota.getAltura());
            preparedStatement.setDouble(3, garota.getValor());
            preparedStatement.setDouble(4, garota.getBumbum());
            preparedStatement.execute();
            preparedStatement.close();
            //return resultado == 1;
        } catch (Exception e) {
            System.out.println("Ops....");
        }
    }

    public Object obter(int id) throws ClassNotFoundException, SQLException {
        Garota g = new Garota();

        try (Connection connection = new Conexao().getConnection()) {
            String sql = "SELECT * FROM garota WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    g.setAltura(rs.getDouble("altura"));
                    g.setApelido(rs.getString("apelido"));
                    g.setBumbum(rs.getDouble("bumbum"));
                    g.setId(rs.getInt("id"));
                    g.setValor(rs.getDouble("valor"));
                }
            }
        }
        return g;
    }

    public void alterar(Garota garota) {        
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "UPDATE garota SET apelido = ?, altura = ?, valor = ?, bumbum = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, garota.getApelido());
            preparedStatement.setDouble(2, garota.getAltura());
            preparedStatement.setDouble(3, garota.getValor());
            preparedStatement.setDouble(4, garota.getBumbum());
            preparedStatement.setInt(5, garota.getId());
            preparedStatement.execute();
            preparedStatement.close();
            //return resultado == 1;
        } catch (Exception e) {
            System.out.println("Ops....");
        }
    }

}
