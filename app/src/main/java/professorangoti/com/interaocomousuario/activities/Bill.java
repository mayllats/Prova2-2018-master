package professorangoti.com.interaocomousuario.activities;

public class Bill {

    private String produto;
    private String valor;

    public Bill(){}

    public Bill(String produto, String valor){
        this.produto = produto;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Price{" +
                "produto='" + produto + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

}
