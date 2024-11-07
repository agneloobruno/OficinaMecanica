package oficinamecanica.model;
public class OrdemServico {
    private int id;
    private int clienteId;
    private int veiculoId;
    private int dataAbertura;
    private int dataFechamento;
    private float valorTotal;
    private String status;
    
    //Construtores
    public OrdemServico(){}

    public OrdemServico(int id, int clienteId, int veiculoId, int dataAbertura, int dataFechamento, float valorTotal, String status) {
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

    public int getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(int dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public int getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(int dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
