package br.cesjf.lppo.dao;

import br.cesjf.lppo.Coleta;
import br.cesjf.lppo.Leitura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Flávio
 */

public class ColetaDAO {
    private final PreparedStatement opNovaColeta;
    private final PreparedStatement opNovoPontoDeLeitura;
    private final PreparedStatement opListarColetas;
    private final PreparedStatement opListaLeituraPorColeta;
    private final PreparedStatement opListaLeituraPorLocal;
    
    public ColetaDAO ()throws Exception{
        Connection conexao = ConnectionFactory.createConnection();
        opNovaColeta = conexao.prepareStatement("INSERT INTO coleta(descricao) VALUES (?)");
        opNovoPontoDeLeitura = conexao.prepareCall("INSERT INTO leitura(coleta,unidade,localLeitura) values (?,?,?)");
        opListarColetas = conexao.prepareStatement("SELECT * FROM coleta");
        opListaLeituraPorColeta = conexao.prepareStatement("SELECT C.DESCRICAO, L.* FROM COLETA C INNER JOIN LEITURA L ON C.ID = L.COLETA WHERE C.ID = ?");
        opListaLeituraPorLocal = conexao.prepareStatement("SELECT C.DESCRICAO, L.* FROM COLETA C INNER JOIN LEITURA L ON C.ID = L.COLETA WHERE L.local = ?");
    }
    
    public void cria(Coleta novaColeta) throws Exception {
        try{
        opNovaColeta.setString(1, novaColeta.getDescricao());
        opNovaColeta.executeUpdate();
        
        }catch (SQLException ex){
            throw new Exception("Erro ao registrar a coleta", ex);
        }
    }
    
    public void criaPontoDeLeitura(Leitura leitura) throws Exception {
        try {
            opNovoPontoDeLeitura.setLong(1, leitura.getColeta());
            opNovoPontoDeLeitura.setString(2, leitura.getUnidade());
            opNovoPontoDeLeitura.setString(3, leitura.getLocalLeitura());
            opNovoPontoDeLeitura.executeUpdate();
        }catch (SQLException ex){
            throw new Exception("Erro ao criar ponto de leitura!", ex);
        }
    }
        
    public List<Coleta> listAll() throws Exception {
        try {
            List<Coleta> coletas = new ArrayList<>();
            ResultSet resultado = opListarColetas.executeQuery();
            while(resultado.next()) {
                Coleta coleta = new Coleta();
                coleta.setId(resultado.getLong(1));
                coleta.setDescricao(resultado.getString(2));
                coleta.setDataColeta(resultado.getDate(3));
                coletas.add(coleta);
            }
            return coletas;
        } catch (SQLException ex) {            
            throw new Exception("Erro ao listar coletas", ex);
        }
    }
    
    public List<Leitura> listaLeituraPorLocal(String local) throws Exception{
        try {
            List<Leitura> leituras = new ArrayList<>();
            opListaLeituraPorLocal.setString(1, local);
            ResultSet resultado = opListaLeituraPorLocal.executeQuery();
            while(resultado.next()) {
                Leitura leitura = new Leitura();
                leitura.setId(resultado.getLong(1));
                leitura.setColeta(resultado.getLong(2));
                leitura.setLocalLeitura(resultado.getString(3));
                leitura.setLeitura(resultado.getInt(4));
                leitura.setUnidade(resultado.getString(5));
                leitura.setAtualizacao(resultado.getDate(6));
                leituras.add(leitura);
            }
            return leituras;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar as leituras",ex);
        }
    }
    
    public List<Leitura> listaLeituraPorColeta(Long coleta) throws Exception{
        try {
            List<Leitura> leituras = new ArrayList<>();
            opListaLeituraPorColeta.setLong(1, coleta);
            ResultSet resultado = opListaLeituraPorColeta.executeQuery();
            while(resultado.next()) {
                Leitura leitura = new Leitura();
                leitura.setId(resultado.getLong(1));
                leitura.setColeta(resultado.getLong(2));
                leitura.setLocalLeitura(resultado.getString(3));
                leitura.setLeitura(resultado.getInt(4));
                leitura.setUnidade(resultado.getString(5));
                leitura.setAtualizacao(resultado.getDate(6));
                leituras.add(leitura);
            }
            return leituras;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar as leituras",ex);
        }
    }
}

    

