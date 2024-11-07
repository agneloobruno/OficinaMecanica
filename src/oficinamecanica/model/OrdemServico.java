package oficinamecanica.model;

import java.util.Date;

public class OrdemServico {
    private int id;
    private int clienteId;
    private int veiculoId;
    private Date dataAbertura;
    private Date dataFechamento;
    private double valorTotal;
    private String status;
    
    //Construtores
    public OrdemServico(){}

    public OrdemServico(int id, int clienteId, int veiculoId, Date dataAbertura, Date dataFechamento, float valorTotal, String status) {
        this.id = id;
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.valorTotal = valorTotal;
        this.status = status;
    }
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
