package ex003;

public class PessoaJuridica extends Contribuinte{

    private Integer numeroFuncionarios;

    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(String name, Double rendaAnual, Integer numeroFuncionarios) {
        super(name, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double impostoDevido() {
        double impostoDevido = 0;
        if (numeroFuncionarios > 10) {
            impostoDevido = super.getRendaAnual() * 0.14;
        } else {
            impostoDevido = super.getRendaAnual() * 0.16;
        }
        return impostoDevido;
    }
}
