package br.cesjf.lppo;

import java.sql.Date;

/**
 *
 * @author José Flávio
 */
public class Coleta {
    
    private Long id;
    private String descricao;
    private Date datacoleta;

    public Coleta() {
    }

    public Coleta(Long id, String descricao, Date datacoleta) {
        this.id = id;
        this.descricao = descricao;
        this.datacoleta = datacoleta;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDatacoleta() {
        return datacoleta;
    }

    public void setDatacoleta(Date datacoleta) {
        this.datacoleta = datacoleta;
    }
    
    
    
}
