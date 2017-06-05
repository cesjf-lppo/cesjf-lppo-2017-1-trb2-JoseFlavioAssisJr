package br.cesjf.lppo;

import java.sql.Date;
/**
 *
 * @author José Flávio
 */
public class Leitura {
    
    private Long id;
    private Long coleta;
    private String localLeitura;
    private int leitura;
    private String unidade;
    private Date atualizacao;

    public Leitura() {
    }

    public Leitura(Long id, Long coleta, String localLeitura, int leitura, String unidade, Date atualizacao) {
        this.id = id;
        this.coleta = coleta;
        this.localLeitura = localLeitura;
        this.leitura = leitura;
        this.unidade = unidade;
        this.atualizacao = atualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getColeta() {
        return coleta;
    }

    public void setColeta(Long coleta) {
        this.coleta = coleta;
    }

    public String getLocalLeitura() {
        return localLeitura;
    }

    public void setLocalLeitura(String localLeitura) {
        this.localLeitura = localLeitura;
    }

    public int getLeitura() {
        return leitura;
    }

    public void setLeitura(int leitura) {
        this.leitura = leitura;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }
    
    
    
}
