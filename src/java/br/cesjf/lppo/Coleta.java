package br.cesjf.lppo;

import java.sql.Date;

/**
 *
 * @author José Flávio
 */
public class Coleta {
    
    private Long id;
    private String descricao;
    private Date dataColeta;

    public Coleta() {
    }

    public Coleta(Long id, String descricao, Date dataColeta) {
        this.id = id;
        this.descricao = descricao;
        this.dataColeta = dataColeta;
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

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }
    
    
    
}
