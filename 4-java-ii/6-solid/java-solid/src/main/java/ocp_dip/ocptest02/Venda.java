package ocp_dip.ocptest02;

import java.util.List;

public class Venda {
    private String cliente;
    private TipoClientes tipoCliente;

    private double frete;
    private double desconto;

    private String estado;
    private List<Item> itens;

    public Venda(String cliente, TipoClientes tipoCliente, String estado, List<Item> itens) {
        this.cliente = cliente;
        this.tipoCliente = tipoCliente;
        this.estado = estado;
        this.itens = itens;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public TipoClientes getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoClientes tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public double getDesconto() {
        return tipoCliente.valorDesconto(this.valorTotal());
    }

    public double getFrete() {
        return this.frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double valorTotal() {
        return this.getItens().stream()
                .mapToDouble(Item::preco)
                .sum();
    }

    public void setDesconto(double v) {
    }
}
